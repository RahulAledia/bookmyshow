package com.aledia.bookmyshow.repository;

import com.aledia.bookmyshow.models.Ticket;
import com.aledia.bookmyshow.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}
