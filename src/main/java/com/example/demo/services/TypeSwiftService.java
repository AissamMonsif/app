package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Swift;
import com.example.demo.entity.TypeSwift;

public interface TypeSwiftService {

	public List<TypeSwift> findAllTypes();
	
	public TypeSwift findTypeById(int theId);
	
	public void saveTypeSwift(TypeSwift typeSwift);
	
	public void deleteTypeSwift(TypeSwift typeSwift);
	
	public List<Swift> getByTypeSwift(int theId);
}
