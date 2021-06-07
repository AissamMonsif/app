package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.SwiftDetailsRepository;
import com.example.demo.DAO.SwiftRepository;
import com.example.demo.DAO.TypeChampRepository;
import com.example.demo.entity.SwiftDetails;
import com.example.demo.entity.TypeChamp;

@Service
public class SwiftDetailsServiceImpl implements SwiftDetailsService {

	@Autowired
	SwiftDetailsRepository swiftDetailsRespository;
	@Autowired
	SwiftRepository swiftRepository;
	@Autowired
	TypeChampRepository typeChampRepository;

	@Override
	public List<SwiftDetails> findAllSwiftsDetails() {
		return swiftDetailsRespository.findAll();
	}

	@Override
	public SwiftDetails findById(int id) {
		Optional<SwiftDetails> result = swiftDetailsRespository.findById(id);
		SwiftDetails theSwiftDetails = null;
		if (result.isPresent()) {
			theSwiftDetails = result.get();
		} else {
			throw new RuntimeException("Did not find swift details id - " + id);

		}
		return theSwiftDetails;
	}

	@Override
	public void saveSwiftDetails(SwiftDetails swiftDetails) {
		swiftDetailsRespository.save(swiftDetails);
	}

	@Override
	public void deleteSwiftDetails(SwiftDetails swiftDetails) {
		swiftDetailsRespository.delete(swiftDetails);

	}

	@Override
	public List<SwiftDetails> findByIdSwift(int theId) {

		List<SwiftDetails> details = swiftDetailsRespository.findAll();
		List<SwiftDetails> theDetails = new ArrayList<SwiftDetails>();

		for (SwiftDetails detail : details) {
			if (detail.getSwift().getIdSwift() == theId) {
				theDetails.add(detail);
			}
		}
		return theDetails;
	}

	@Override
	public List<SwiftDetails> findByLibelleTypeSwift(String libelle) {
		// TODO Auto-generated method stub
		List<SwiftDetails> details = new ArrayList<SwiftDetails>();
		for(SwiftDetails detail:swiftDetailsRespository.findAll()) {
			if(detail.getSwift().getTypeSwift().getLibelle().equals(libelle)) {
				details.add(detail);
			}
		}
		return details;
	}

	@Override
	public List<SwiftDetails> getDetailsFromTypeChampLibelle(String libelle) {
		// TODO Auto-generated method stub
		List<SwiftDetails> details = new ArrayList<SwiftDetails>();
		for( SwiftDetails detail:swiftDetailsRespository.findAll()) {
			if(detail.getTypeChamp().getLibelle().equals(libelle)) {
				details.add(detail);
			}
		}
		return details;
	}


}
