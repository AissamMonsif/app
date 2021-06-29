package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Swift;

public interface SwiftRepository extends JpaRepository<Swift, Integer> {

	List<Swift> findBySens(String sens);
	
	List<Swift> findByTypeSwift_libelle(String libelle);
}
