package com.aledia.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class City  extends  BaseModel{
    @OneToMany(mappedBy = "city") // because this is already represented in theatre class hence to tell ORM to not repeat the relation to avoid changes of bugs.
    private List<Theatre> theatres;
    private String name;
}
