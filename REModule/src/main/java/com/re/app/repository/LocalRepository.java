package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.Localadd;
@Repository
public interface LocalRepository extends JpaRepository<Localadd, Integer> {

}
