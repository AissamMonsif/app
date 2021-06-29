package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.SwiftDetailsRepository;
import com.example.demo.DAO.TypeChampRepository;
import com.example.demo.DAO.TypeSwiftRepository;
import com.example.demo.entity.SwiftDetails;
import com.example.demo.entity.TypeChamp;

@Service
public class TypeChampServiceImpl implements TypeChampService {

	@Autowired
	private TypeChampRepository typeChampRepository;

	@Autowired
	private SwiftDetailsRepository swiftDetailsRepository;
	

	@Override
	public Page<TypeChamp> findAllTypesChamps(int pageNum, String sortField, String sortDir) {
		Pageable pageable = PageRequest.of(pageNum - 1, 10, 
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
									  : Sort.by(sortField).descending()
		);
		return typeChampRepository.findAll(pageable);
	}

	@Override
	public TypeChamp findTypeChampById(int theId) {
		Optional<TypeChamp> result = typeChampRepository.findById(theId);

		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Did not find type champ id - " + theId);

		}
	}

	@Override
	public void saveTypeChamp(TypeChamp typeChamp) {
		typeChampRepository.save(typeChamp);

	}

	@Override
	public void deleteTypeChamp(TypeChamp typeChamp) {
		typeChampRepository.delete(typeChamp);

	}

	@Override
	public List<SwiftDetails> findByTypeChamp(int theId) {
		// TODO Auto-generated method stub
		List<SwiftDetails> theDetails = new ArrayList<SwiftDetails>();
		for (SwiftDetails detail : swiftDetailsRepository.findAll()) {
			if (detail.getTypeChamp().getIdTypeChamp() == theId) {
				theDetails.add(detail);
			}
		}
		return theDetails;
	}

	@Override
	public List<SwiftDetails> findByLibelleTypeChamp(String libelle) {
		// TODO Auto-generated method stub
		List<SwiftDetails> theDetails = new ArrayList<SwiftDetails>();
		for (SwiftDetails detail : swiftDetailsRepository.findAll()) {
			if (detail.getTypeChamp().getLibelle().equals(libelle)) {
				theDetails.add(detail);
			}
		}
		return theDetails;
	}

	@Override
	public List<TypeChamp> getFieldsFromLibelleTypeSwift(String libelle) {
		// TODO Auto-generated method stub
		List<TypeChamp> champs = new ArrayList<TypeChamp>();
		for(TypeChamp champ:typeChampRepository.findAll()) {
			if(champ.getTypeSwift().getLibelle().equals(libelle)) {
				champs.add(champ);
			}
		}
		return champs;
	}

}
