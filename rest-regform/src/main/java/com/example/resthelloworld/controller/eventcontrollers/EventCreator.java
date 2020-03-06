package com.example.resthelloworld.controller.eventcontrollers;

import com.example.resthelloworld.entity.Event;
import com.example.resthelloworld.services.EventService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EventCreator {

    @Resource
    EventService eventService;

    @RequestMapping(value ={"/testEvent", "/createEvent"},method = RequestMethod.POST)
    public void event(@RequestBody Event event) {
        eventService.addEvent(event);
    }

}
