package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.TypeChampRepository;
import com.example.demo.entity.TypeChamp;

@Service
public class TypeChampServiceImpl implements TypeChampService {

	@Autowired
	private TypeChampRepository typeChampRepository;

	@Override
	public List<TypeChamp> findAllTypesChamps() {

		return typeChampRepository.findAll();
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

}
