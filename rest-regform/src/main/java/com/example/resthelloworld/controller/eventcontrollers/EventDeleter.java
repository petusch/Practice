package com.example.resthelloworld.controller.eventcontrollers;

import com.example.resthelloworld.entity.Event;
import com.example.resthelloworld.services.EventService;
import com.github.jasync.sql.db.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class EventDeleter {

    @Autowired
    Connection connection;

    @Resource
    EventService eventService;

    @RequestMapping(value ={"/deleteEvent"},method = RequestMethod.POST)
    public void event(@RequestParam long id) {
        eventService.delete(id);
    }

}
