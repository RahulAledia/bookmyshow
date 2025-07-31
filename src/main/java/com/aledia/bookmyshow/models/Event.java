package com.aledia.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Event extends BaseModel{
    @ManyToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;
    @Enumerated(EnumType.ORDINAL)
    private Language language;

}
