package com.example.resthelloworld.entity;

import java.util.Date;


public class Event
{
    private long id = -1;
    private String Name;
    private Date eventDate;
    private boolean AgeAffilation;
    private String description;

    public Event(String name, boolean ageParameter, long date, String desc)
    {

        Name = name;
        AgeAffilation = ageParameter;
        eventDate = new Date(date);
        description = desc;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isAgeAffilation() {
        return AgeAffilation;
    }

    public void setAgeAffilation(boolean ageAffilation) {
        AgeAffilation = ageAffilation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
