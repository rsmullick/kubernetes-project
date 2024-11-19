package com.tutorial.spring.cloud.kubernetes.travelagency.repository;

import com.tutorial.spring.cloud.kubernetes.travelagency.entity.TravelDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface TravelDealRepository extends JpaRepository<TravelDeal, String> {
    public List<TravelDeal> findByDestination(String destination);
}
