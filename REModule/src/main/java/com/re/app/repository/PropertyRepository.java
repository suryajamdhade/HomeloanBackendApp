package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.PropertyInfo;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyInfo, Integer> {

}
