package com.example.resthelloworld;

import java.util.Date;
import java.util.UUID;

public class Event
{
    private long eventId;
    private String Name;
    private Date eventDate;
    private boolean AgeAffilation;

    public Event(String name,boolean ageParameter, long date)
    {
        setEventId();
        Name = name;
        AgeAffilation = ageParameter;
        eventDate = new Date(date);
    }


    public long getEventId() {
        return eventId;
    }

    public void setEventId() {
        this.eventId = 1;
    }
}
