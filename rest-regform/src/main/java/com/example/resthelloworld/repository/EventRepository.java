package com.example.resthelloworld.repository;

import com.example.resthelloworld.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
