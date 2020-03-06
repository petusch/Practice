package com.example.resthelloworld.services.impl;

import com.example.resthelloworld.entity.Event;
import com.example.resthelloworld.repository.EventRepository;
import com.example.resthelloworld.services.EventService;
import com.github.jasync.sql.db.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    Connection connection;

    @Autowired
    EventRepository eventRepository;

    @Override
    public void addEvent(Event event) {
        eventRepository.saveAndFlush(event);
    }

    @Override
    public void delete(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event editEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }
}
