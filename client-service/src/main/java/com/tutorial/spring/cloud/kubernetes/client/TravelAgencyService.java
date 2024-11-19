package com.tutorial.spring.cloud.kubernetes.client;

/*import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;*/
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TravelAgencyService {
    private final RestTemplate restTemplate;

    public TravelAgencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*  @HystrixCommand(fallbackMethod = "getFallbackName", commandProperties = {
              @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })*/
    public String getDeals() {
        return this.restTemplate.getForObject("http://travel-agency-service:8080/deals", String.class);
    }
    public TravelDealRequestResponse addDeals(TravelDealRequestResponse travelDealRequestResponse) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TravelDealRequestResponse> request = new HttpEntity<>(travelDealRequestResponse, headers);
        System.out.println(travelDealRequestResponse.toString());
        return this.restTemplate.postForObject("http://travel-agency-service:8080/add-deal",request, TravelDealRequestResponse.class);
    }


    public String getDealNew() {
        return this.restTemplate.getForObject("http://travel-agency-service:8080/deal-new", String.class);
    }//
    private String getFallbackName() {
        return "Fallback";
    }
}
