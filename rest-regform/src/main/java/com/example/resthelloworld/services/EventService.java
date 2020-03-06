package com.example.resthelloworld.services;

import com.example.resthelloworld.entity.Event;

import java.util.List;

public interface EventService {
    void addEvent(Event event);
    void delete(long id);
    Event editEvent(Event event);
    List<Event> getAll();

}
