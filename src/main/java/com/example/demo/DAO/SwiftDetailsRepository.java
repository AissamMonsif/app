package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SwiftDetails;

public interface SwiftDetailsRepository extends JpaRepository<SwiftDetails, Integer> {

	List<SwiftDetails> findBySwift_typeSwift_libelle(String libelle);

}
