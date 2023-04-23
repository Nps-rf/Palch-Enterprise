package com.example.t_24;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cargo {
    private Long id;
    private String v_name; //название груза
    private String content; //содержимое груза
    private String dispatch_city; //город отправки груза
    private String departure_date; //дата отправки груза
    private String arrival_city; //город прибытия груза
    private String arrival_date; //дата прибытия груза

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDispatch_city() {
        return dispatch_city;
    }

    public void setDispatch_city(String dispatch_city) {
        this.dispatch_city = dispatch_city;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }
}