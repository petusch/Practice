package com.example.resthelloworld.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="events")
public class Event
{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name="id", nullable = false)
    private long id;
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

    public Event() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    @Column(name = "name")
    public void setName(String name) {
        this.Name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    @Column(name = "event_date")
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isAgeAffilation() {
        return AgeAffilation;
    }

    @Column(name = "age_affilattion")
    public void setAgeAffilation(boolean ageAffilation) {
        this.AgeAffilation = ageAffilation;
    }

    public String getDescription() {
        return description;
    }

    @Column(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

}
