package ma.eurafric.swifts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.eurafric.swifts.DAO.SwiftDetailsRepository;
import ma.eurafric.swifts.DAO.SwiftRepository;
import ma.eurafric.swifts.DAO.TypeChampRepository;
import ma.eurafric.swifts.entity.SwiftDetails;

@Service
public class SwiftDetailsServiceImpl implements SwiftDetailsService {

	@Autowired
	SwiftDetailsRepository swiftDetailsRespository;
	@Autowired
	SwiftRepository swiftRepository;
	@Autowired
	TypeChampRepository typeChampRepository;

	@Override
	public List<SwiftDetails> findAllDetails() {
		// TODO Auto-generated method stub
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
	public List<SwiftDetails> getDetailsFromLibelleTypeChamp(String libelle) {
		
		if (libelle.equals("ALL")) {
			return swiftDetailsRespository.findAll();
		}

		return swiftDetailsRespository.findByTypeChamp_libelle(libelle);
	}

	@Override
	public List<SwiftDetails> getDetailsFromLibelleTypeSwift(String libelle) {

		if (libelle.equals("ALL")) {
			return swiftDetailsRespository.findAll();
		}

		return swiftDetailsRespository.findBySwift_typeSwift_libelle(libelle);
	}



}
