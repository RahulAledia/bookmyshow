package com.aledia.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Chair chair;
    @ManyToOne
    private Event event;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

