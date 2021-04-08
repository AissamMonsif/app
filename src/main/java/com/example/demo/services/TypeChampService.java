package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.TypeChamp;

public interface TypeChampService {

	public List<TypeChamp> findAllTypesChamps();
	
	public TypeChamp findTypeChampById(int theId);
	
	public void saveTypeChamp(TypeChamp typeChamp);
	
	public void deleteTypeChamp(TypeChamp typeChamp);
}
