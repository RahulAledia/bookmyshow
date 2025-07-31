package com.aledia.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Ticket extends BaseModel {
    private int amount;
    private Date timeOfBooking;
    @ManyToMany
    private List<Chair> chairs;
    @ManyToOne
    private User bookedBy;
    @ManyToOne
    private Event event;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;
}
