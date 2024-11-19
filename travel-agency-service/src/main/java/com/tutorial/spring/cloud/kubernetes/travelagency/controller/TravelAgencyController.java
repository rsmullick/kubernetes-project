package com.tutorial.spring.cloud.kubernetes.travelagency.controller;

import com.tutorial.spring.cloud.kubernetes.travelagency.entity.TravelDeal;
import com.tutorial.spring.cloud.kubernetes.travelagency.model.TravelDealRequestResponse;
import com.tutorial.spring.cloud.kubernetes.travelagency.service.TravelDealService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TravelAgencyController {

@Autowired
    TravelDealService travelDealService;
    private static final Log log = LogFactory.getLog(TravelAgencyController.class);

    @RequestMapping(method = GET, path = "/deals")
    public String deals() {
        log.info("Client is requesting new deals!");
        System.out.println("COMES HERE TO TRAVEL SERVICE &&^^%$$####@@");
        List<TravelDealRequestResponse> travelDealList = travelDealService.findAllDeals();
        if (!travelDealList.isEmpty()) {
            int randomDeal = new Random().nextInt(travelDealList.size());
            return travelDealList.get(randomDeal)
                    .toString();
        } else {
            return "NO DEALS";
        }
    }
    @RequestMapping(method = GET, path = "/deal-new")
    @ResponseBody
    public List<TravelDealRequestResponse> dealsnew() {
        log.info("Client is requesting new deals!");
        return travelDealService.addnew();
    }
    @PostMapping(value="/add-deal", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TravelDealRequestResponse addDeal(@RequestBody TravelDealRequestResponse travelDealRequest) {

        return travelDealService.post(travelDealRequest);
    }
    @RequestMapping(method = GET, path = "/")
    @ResponseBody
    public String get() throws UnknownHostException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Host: ")
                .append(InetAddress.getLocalHost()
                        .getHostName())
                .append("<br/>");
        stringBuilder.append("IP: ")
                .append(InetAddress.getLocalHost()
                        .getHostAddress())
                .append("<br/>");
        stringBuilder.append("Type: ")
                .append("Travel Agency")
                .append("<br/>");
        return stringBuilder.toString();
    }
}