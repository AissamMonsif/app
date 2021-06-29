package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Swift;
import com.example.demo.entity.TypeSwift;

public interface TypeSwiftService {

	public Page<TypeSwift> findAllTypes(int pageNum, String sortField, String sortDir);
	
	public List<TypeSwift> listAll();
	
	public TypeSwift findTypeById(int theId);
	
	public void saveTypeSwift(TypeSwift typeSwift);
	
	public void deleteTypeSwift(TypeSwift typeSwift);
	
	public List<Swift> getByTypeSwift(int theId);

	public List<Swift> getByLibelleSwift(String libelle);
		
	public List<Swift> getByCategorieSwift(String categorie);

}
