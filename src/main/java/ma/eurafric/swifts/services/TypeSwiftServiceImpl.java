package ma.eurafric.swifts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.eurafric.swifts.DAO.SwiftRepository;
import ma.eurafric.swifts.DAO.TypeChampRepository;
import ma.eurafric.swifts.DAO.TypeSwiftRepository;
import ma.eurafric.swifts.entity.Swift;
import ma.eurafric.swifts.entity.TypeSwift;

@Service
public class TypeSwiftServiceImpl implements TypeSwiftService {

	@Autowired
	private TypeSwiftRepository typeSwiftRepository;
	@Autowired
	private SwiftRepository swiftRepository;
	@Autowired
	TypeChampRepository typeChampRepository;

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
	public List<TypeSwift> listAll() {
		// TODO Auto-generated method stub
		return typeSwiftRepository.findAll();
	}

}
