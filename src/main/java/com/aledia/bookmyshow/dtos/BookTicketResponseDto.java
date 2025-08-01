package com.aledia.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private int amt;
    private Long ticketId;
    private List<String> seatNumbers;
    private String auditoriumName;
}
