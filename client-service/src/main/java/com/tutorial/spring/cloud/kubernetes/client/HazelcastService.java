package com.tutorial.spring.cloud.kubernetes.client;

/*import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

//@Service
public class HazelcastService {
    private final RestTemplate restTemplate;
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    public HazelcastService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String  get(){
      return   this.restTemplate.getForObject("http://hazelcast-spring-service:8080/get?key=key1", String.class);
    }
    private String getFallbackName() {
        return "Fallback";
    }


    //@PostConstruct
    void testService () {
        System.out.println("TESTING SERVVICES WITH HYSTRIX");
        get();
        this.restTemplate.getForObject("http://hazelcast-spring-service:8080/put?key=key1&value=hazelcast", Object.class);
        System.out.println(get());
    }
}
