package com.example.resthelloworld.controller.eventcontrollers;

import com.example.resthelloworld.entity.Event;
import com.example.resthelloworld.services.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EventReader {


    @Resource
    EventService eventService;

    @RequestMapping(value ={"/readEvents"},method = RequestMethod.POST)
    public List<Event> event()
    {

        return eventService.getAll();
    }

}
