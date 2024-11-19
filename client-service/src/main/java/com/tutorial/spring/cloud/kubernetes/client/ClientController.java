package com.tutorial.spring.cloud.kubernetes.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/")
public class ClientController {
   /* @Autowired
    private DiscoveryClient discoveryClient;
*/
 /*   @Autowired
    private ClientConfig config;*/

    @Autowired
    private TravelAgencyService travelAgencyService;
    /*    @Autowired
        private CircuitBreakerFactory circuitBreakerFactory;*/
    @GetMapping(value = "trial")
    public String getString() {
        return "GET METHOD REACHED";
    }
    @GetMapping(value = "a-value")
    public String get() {
        return travelAgencyService.getDeals();
    }

    @GetMapping(value = "deal-new")
    public String getNew() {
        return travelAgencyService.getDealNew();
    }


    @PostMapping(value = "save-deal", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public TravelDealRequestResponse save(@RequestBody TravelDealRequestResponse travelDealRequestResponse) {
        System.out.println("COmes here to post method " + travelDealRequestResponse);
        String serviceList = "";
        return travelAgencyService.addDeals(travelDealRequestResponse);
        // return String.format(config.getMessage(), requestResponse., serviceList);
    }



      /* if (discoveryClient != null) {
            List<String> services = this.discoveryClient.getServices();

            for (String service : services) {

                List<ServiceInstance> instances = this.discoveryClient.getInstances(service);

                serviceList += ("[" + service + " : " + ((!CollectionUtils.isEmpty(instances)) ? instances.size() : 0) + " instances ]");
            }
        }*/
}
