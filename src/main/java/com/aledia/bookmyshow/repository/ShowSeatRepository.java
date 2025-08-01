package com.aledia.bookmyshow.repository;

import com.aledia.bookmyshow.models.Chair;
import com.aledia.bookmyshow.models.Event;
import com.aledia.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findAllBySeatInAndShow(List<Chair> seats, Event show);

    ShowSeat save(ShowSeat showSeat);
}
