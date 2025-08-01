package com.aledia.bookmyshow.controllers;

import com.aledia.bookmyshow.dtos.BookTicketRequestDto;
import com.aledia.bookmyshow.dtos.BookTicketResponseDto;
import com.aledia.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request){

        return null;
    }
}
