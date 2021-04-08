package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<TypeSwift> findAllTypes() {

		return typeSwiftRepository.findAll();
	}

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
				if (swift.getTypeSwift().getIdTypeSwift()==theId) 
					theSwifts.add(swift);
				}
			
		}
		return theSwifts;
	}
}
