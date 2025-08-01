package com.aledia.bookmyshow.services;

import com.aledia.bookmyshow.exceptions.InvalidArgumentException;
import com.aledia.bookmyshow.exceptions.SeatNotAvailableException;
import com.aledia.bookmyshow.models.*;
import com.aledia.bookmyshow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class TicketService {

    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;


    @Autowired
    public TicketService(SeatRepository seatRepository,
                         ShowSeatRepository showSeatRepository,
                         EventRepository eventRepository,
                         UserRepository userRepository,
                         TicketRepository ticketRepository){
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket BookTicket(List<Long> seatIds, Long showId, Long userId) throws Exception {

        List<Chair> chairs = seatRepository.findAllByIdIn(seatIds);
        Optional<Event> showOptional = eventRepository.findById(showId);

        if(showOptional.isEmpty()){
            throw new InvalidArgumentException("Show by: "+showId+" doesn't exist.");
        }

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(chairs, showOptional.get());

        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException();
            }
        }

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new InvalidArgumentException("user by id "+userId+" not found!");
        }
        Ticket ticket = new Ticket();
        ticket.setBookedBy(userOptional.get());
        ticket.setStatus(TicketStatus.PROCESSING);
        ticket.setEvent(showOptional.get());
        ticket.setChairs(chairs);
        ticket.setAmount(0);
        ticket.setTimeOfBooking(new Date());

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }
}
