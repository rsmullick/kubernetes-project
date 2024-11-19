package com.tutorial.spring.cloud.kubernetes.travelagency;

import com.tutorial.spring.cloud.kubernetes.travelagency.controller.TravelAgencyController;
import jakarta.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Log log = LogFactory.getLog(TravelAgencyController.class);

    public static void main(String[] args) {
        log.info("Travel Agency Started! ");
        SpringApplication.run(Application.class, args);
    }

//docker build -t travel-agency-service 'C:\Users\Shahriar Mullick\Documents\spring-cloud-tutorial\kubernetes-guide\travel-agency-service'


}   // p455w0rd    //user