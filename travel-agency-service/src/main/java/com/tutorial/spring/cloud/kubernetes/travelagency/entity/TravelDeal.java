package com.tutorial.spring.cloud.kubernetes.travelagency.entity;




import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "travel_deal")
public class TravelDeal implements Serializable {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private long id;

    private String destination;

    private String description;


    private double dealPrice;


    private double oldPrice;


    private Date departureDate;

    private Date arrivalDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "TravelDeal{" + "id=" + id + ", destination='" + destination + '\'' + ", description='" + description + '\'' + ", dealPrice=" + dealPrice + ", oldPrice=" + oldPrice + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + '}';
    }
}
