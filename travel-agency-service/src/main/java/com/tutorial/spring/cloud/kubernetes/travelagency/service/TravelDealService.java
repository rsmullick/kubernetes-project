package com.tutorial.spring.cloud.kubernetes.travelagency.service;

import com.tutorial.spring.cloud.kubernetes.travelagency.entity.TravelDeal;
import com.tutorial.spring.cloud.kubernetes.travelagency.model.TravelDealRequestResponse;
import com.tutorial.spring.cloud.kubernetes.travelagency.repository.TravelDealRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class TravelDealService {
    @Autowired
    private TravelDealRepository travelDealRepository;


    public List<TravelDealRequestResponse> findAllDeals() {
        List<TravelDeal> travelDealList = travelDealRepository.findAll();
        List<TravelDealRequestResponse> travelDealRequestResponses = new ArrayList<>();
        for (TravelDeal travelDeal: travelDealList) {
            TravelDealRequestResponse requestResponse = new TravelDealRequestResponse();
            requestResponse.setDealPrice(travelDeal.getDealPrice());
            requestResponse.setDescription(travelDeal.getDescription());
            requestResponse.setDestination(travelDeal.getDestination());
            requestResponse.setDepartureDate(travelDeal.getDepartureDate());
            requestResponse.setArrivalDate(travelDeal.getArrivalDate());
            travelDealRequestResponses.add(requestResponse);
        }
        return travelDealRequestResponses;
    }
    public List<TravelDealRequestResponse> addnew() {
        return addObjects(new Date());
    }
    public TravelDealRequestResponse post(TravelDealRequestResponse travelDealRequestResponse) {
        TravelDeal requestResponse = new TravelDeal();
        requestResponse.setDealPrice(travelDealRequestResponse.getDealPrice());
        requestResponse.setDescription(travelDealRequestResponse.getDescription());
        requestResponse.setDestination(travelDealRequestResponse.getDestination());
        requestResponse.setDepartureDate(travelDealRequestResponse.getDepartureDate());
        requestResponse.setArrivalDate(travelDealRequestResponse.getArrivalDate());
        TravelDeal travelDeal = travelDealRepository.save(requestResponse);
        if (travelDeal!=null) travelDealRequestResponse.setId(requestResponse.getId());
        return travelDealRequestResponse;

    }
   // @PostConstruct
    public List<TravelDealRequestResponse> addObjects(Date date) {
        System.out.println("CREATING OBJECTS TO DATABSE ");
        //List<>
        List<TravelDealRequestResponse> ret = new ArrayList<>();
        for (int i=0;i<10; i++) {
            TravelDealRequestResponse requestResponse = new TravelDealRequestResponse();
            requestResponse.setDealPrice(111.11);
            requestResponse.setDescription("test"+i +" on " + date.toString());
            requestResponse.setDestination("test destination"+i);
            requestResponse.setDepartureDate(new Date());
            requestResponse.setArrivalDate(new Date());
            ret.add(post(requestResponse));
        }
        return ret;
    }
}
