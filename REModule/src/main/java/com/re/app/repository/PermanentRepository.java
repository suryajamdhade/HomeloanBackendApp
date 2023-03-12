package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.Permanent;
@Repository
public interface PermanentRepository extends JpaRepository<Permanent, Integer> {

}
