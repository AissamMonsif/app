package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Swift;

public interface SwiftService {
	
	public List<Swift> findAllSwifts();
	
	public Swift findById(int id);
	
	public void saveSwift(Swift swift);
	
	public void deleteSwift(Swift swift);
	
	public Swift getSwiftFromDetails(int theId);
	
	
}
