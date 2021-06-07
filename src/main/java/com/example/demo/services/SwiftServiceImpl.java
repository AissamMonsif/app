package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.SwiftDetailsRepository;
import com.example.demo.DAO.SwiftRepository;
import com.example.demo.entity.Swift;
import com.example.demo.entity.SwiftDetails;

@Service
public class SwiftServiceImpl implements SwiftService {

	@Autowired
	private SwiftRepository swiftRepository;
	@Autowired
	private SwiftDetailsRepository swiftDetailsRepository;

	@Override
	public List<Swift> findAllSwifts() {
		return swiftRepository.findAll();
	}

	@Override
	public Swift findById(int id) {
		Optional<Swift> result = swiftRepository.findById(id);
		Swift theSwift = null;

		if (result.isPresent()) {
			theSwift = result.get();
		} else {
			throw new RuntimeException("Did not find swift id - " + id);
		}

		return theSwift;
	}

	@Override
	public void saveSwift(Swift swift) {
		swiftRepository.save(swift);

	}

	@Override
	public void deleteSwift(Swift swift) {
		swiftRepository.delete(swift);
	}

	@Override
	public Swift getSwiftFromDetails(int theId) {

		List<SwiftDetails> details = swiftDetailsRepository.findAll();
		for (SwiftDetails detail : details) {
			if (detail.getSwift().getIdSwift() == theId) {
				return detail.getSwift();
			}
		}
		return null;
	}

	@Override
	public List<Swift> getSwiftsBySens(String sens) {
		// TODO Auto-generated method stub
		List<Swift> theSwifts = new ArrayList<Swift>();
		for(Swift swift:swiftRepository.findAll()) {
			if(swift.getSens().equals(sens)) {
				theSwifts.add(swift);
			}
		}
		return theSwifts;
	}

}
