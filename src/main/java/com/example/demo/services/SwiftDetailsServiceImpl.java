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
	public Page<SwiftDetails> findAllSwiftsDetails(int pageNum, String sortField, String sortDir) {
		Pageable pageable = PageRequest.of(pageNum - 1, 50,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		return swiftDetailsRespository.findAll(pageable);
	}

	@Override
	public Page<SwiftDetails> findAllSwiftsDetailsByLibelleTypeSwift(String libelle, int pageNum, String sortField,
			String sortDir) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum - 1, 2100,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<SwiftDetails> details = swiftDetailsRespository.findAll(pageable);
		
		List<SwiftDetails> d = new ArrayList<SwiftDetails>();
		for (SwiftDetails det : details.getContent()) {
			if (det.getSwift().getTypeSwift().getLibelle().equals(libelle)) {
				d.add(det);
			}
		}
		Pageable pageableR = PageRequest.of(pageNum - 1, 30,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<SwiftDetails> result = new PageImpl<SwiftDetails>(d,pageableR,d.size());
		return result;
	}

	@Override
	public Page<SwiftDetails> findAllSwiftsDetailsByLibelleTypeChamp(String libelle, int pageNum, String sortField,
			String sortDir) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum - 1, 50,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		Page<SwiftDetails> details = swiftDetailsRespository.findAll(pageable);
		List<SwiftDetails> d = new ArrayList<SwiftDetails>();
		for (SwiftDetails det : details.getContent()) {
			if (det.getTypeChamp().getLibelle().equals(libelle)) {
				d.add(det);
			}
		}
		Page<SwiftDetails> result = new PageImpl<SwiftDetails>(d);
		return result;
		
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
		for (SwiftDetails detail : swiftDetailsRespository.findAll()) {
			if (detail.getSwift().getTypeSwift().getLibelle().equals(libelle)) {
				details.add(detail);
			}
		}
		return details;
	}


	@Override
	public List<SwiftDetails> getDetailsFromLibelleTypeSwift(String libelle) {
;
		if (libelle.equals("ALL")) {
			return swiftDetailsRespository.findAll();
		}
		
		return swiftDetailsRespository.findBySwift_typeSwift_libelle(libelle);
	}

}
