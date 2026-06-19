package com.jared.hngout.repository;
import com.jared.hngout.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Long> {}

