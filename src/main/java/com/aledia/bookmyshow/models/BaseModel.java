package com.aledia.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass // dont create separate table , instead put this attribute to every child.
public class BaseModel {
    @Id
    private Long id;
}
