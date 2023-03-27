package com.cm.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.app.model.APFDetails;
@Repository
public interface APFDetailsRepository extends JpaRepository<APFDetails, Integer>{

}
