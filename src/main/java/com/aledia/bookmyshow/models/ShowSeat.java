package com.aledia.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Chair chair;
    @ManyToOne
    private Event event;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;
    private Date lockedAt;
}

