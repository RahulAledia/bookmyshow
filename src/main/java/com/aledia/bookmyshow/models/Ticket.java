package com.aledia.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Ticket extends BaseModel {
    private int amount;
    private Date timeOfBooking;
    private List<Seat> seats;
    private User user;
    private Show show;
    private Payment payment;
    private TicketStatus status;
}
