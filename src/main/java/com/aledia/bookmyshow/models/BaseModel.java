package com.aledia.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass // dont create separate table , instead put this attribute to every child.
public class BaseModel {
    @Id
    private Long id;
}
