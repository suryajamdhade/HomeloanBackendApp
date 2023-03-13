package com.re.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.re.app.model.AllDocuments;
@Repository
public interface DocumentRepository extends JpaRepository<AllDocuments, Integer> {


}
