package com.aledia.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    @OneToMany
    private List<Chair> chairs;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> feature;
}
