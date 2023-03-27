package com.oe.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oe.app.model.OffersSection;

@Repository
public interface OfferSecRepository extends JpaRepository<OffersSection, Integer> {

}
