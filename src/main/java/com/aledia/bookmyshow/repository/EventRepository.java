package com.aledia.bookmyshow.repository;

import com.aledia.bookmyshow.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Override
    Optional<Event> findById(Long aLong);
}
