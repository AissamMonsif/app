package ma.eurafric.swifts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.eurafric.swifts.DAO.SwiftDetailsRepository;
import ma.eurafric.swifts.DAO.SwiftRepository;
import ma.eurafric.swifts.entity.Swift;
import ma.eurafric.swifts.entity.SwiftDetails;

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

		if (sens.equals("ALL")) {
			return swiftRepository.findAll();
		}

		return swiftRepository.findBySens(sens);
	}

}
