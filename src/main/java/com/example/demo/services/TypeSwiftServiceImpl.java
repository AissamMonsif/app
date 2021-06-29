package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.SwiftRepository;
import com.example.demo.DAO.TypeSwiftRepository;
import com.example.demo.entity.Swift;
import com.example.demo.entity.TypeSwift;

@Service
public class TypeSwiftServiceImpl implements TypeSwiftService {

	@Autowired
	private TypeSwiftRepository typeSwiftRepository;
	@Autowired
	private SwiftRepository swiftRepository;
	
	@Override
	public TypeSwift findTypeById(int theId) {

		Optional<TypeSwift> result = typeSwiftRepository.findById(theId);
		TypeSwift typeSwift = null;
		if (result.isPresent()) {
			typeSwift = result.get();
		} else {
			throw new RuntimeException("Did not find type swift id - " + theId);

		}
		return typeSwift;
	}

	@Override
	public void saveTypeSwift(TypeSwift typeSwift) {
		typeSwiftRepository.save(typeSwift);

	}

	@Override
	public void deleteTypeSwift(TypeSwift typeSwift) {
		typeSwiftRepository.delete(typeSwift);

	}

	@Override
	public List<Swift> getByTypeSwift(int theId) {

		List<Swift> theSwifts = new ArrayList<Swift>();

		for (Swift swift : swiftRepository.findAll()) {
			{
				if (swift.getTypeSwift().getIdTypeSwift() == theId)
					theSwifts.add(swift);
			}

		}
		return theSwifts;
	}

	@Override
	public Page<TypeSwift> findAllTypes(int pageNum, String sortField, String sortDir) {
		// TODO Auto-generated method stub

		Pageable pageable = PageRequest.of(pageNum - 1, 35,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		return typeSwiftRepository.findAll(pageable);
	}
	

	@Override
	public List<Swift> getByLibelleSwift(String libelle) {
		// TODO Auto-generated method stub
		List<Swift> theSwifts = new ArrayList<Swift>();
		for (Swift swift : swiftRepository.findAll()) {
			if (swift.getTypeSwift().getLibelle().equals(libelle)) {
				theSwifts.add(swift);
			}
		}
		return theSwifts;
	}

	@Override
	public List<Swift> getByCategorieSwift(String categorie) {
		// TODO Auto-generated method stub
		List<Swift> theSwifts = new ArrayList<Swift>();
		for (Swift swift : swiftRepository.findAll()) {
			if (swift.getTypeSwift().getCategorie().equals(categorie)) {
				theSwifts.add(swift);
			}
		}
		return theSwifts;
	}

	@Override
	public List<TypeSwift> listAll() {
		// TODO Auto-generated method stub
		return typeSwiftRepository.findAll();
	}





}
