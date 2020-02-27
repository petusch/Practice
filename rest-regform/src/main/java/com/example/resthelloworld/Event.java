package com.example.resthelloworld;

import java.util.Date;
import java.util.UUID;

public class Event
{
    private UUID eventId;
    private String Name;
    private Date eventDate;
    private boolean AgeAffilation;

    public Event(String name,boolean ageParameter, long date)
    {
        eventId = UUID.randomUUID();
        Name = name;
        AgeAffilation = ageParameter;
        eventDate = new Date(date);
    }


}
