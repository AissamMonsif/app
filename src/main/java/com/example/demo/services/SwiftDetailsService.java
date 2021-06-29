package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.SwiftDetails;
import com.example.demo.entity.TypeChamp;

public interface SwiftDetailsService {

	public Page<SwiftDetails> findAllSwiftsDetails(int pageNum, String sortField, String sortDir);
	
	public Page<SwiftDetails> findAllSwiftsDetailsByLibelleTypeSwift(String libelle,int pageNum, String sortField, String sortDir);
	
	public Page<SwiftDetails> findAllSwiftsDetailsByLibelleTypeChamp(String libelle,int pageNum, String sortField, String sortDir);

	public SwiftDetails findById(int id);

	public void saveSwiftDetails(SwiftDetails swiftDetails);

	public void deleteSwiftDetails(SwiftDetails swiftDetails);

	public List<SwiftDetails> findByIdSwift(int theId);
	
	public List<SwiftDetails> findByLibelleTypeSwift(String libelle);

	List<SwiftDetails> getDetailsFromLibelleTypeSwift(String libelle);
	 

}
