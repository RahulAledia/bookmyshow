package com.aledia.bookmyshow.repository;

import com.aledia.bookmyshow.models.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Chair, Long> {

    List<Chair> findAllByIdIn(List<Long> seatIds);

}
