package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Swift;

public interface SwiftService {

	public List<Swift> findAllSwifts();
	
	public Page<Swift> findAllSwifts(int pageNum, String sortField, String sortDir);

	public List<Swift> getSwiftsBySens(String sens);
		
	public Swift findById(int id);

	public void saveSwift(Swift swift);

	public void deleteSwift(Swift swift);

	public Swift getSwiftFromDetails(int theId);



	
}
