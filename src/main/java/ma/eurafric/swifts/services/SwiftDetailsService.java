package ma.eurafric.swifts.services;

import java.util.List;

import ma.eurafric.swifts.entity.SwiftDetails;

public interface SwiftDetailsService {

	public List<SwiftDetails> findAllDetails();

	public SwiftDetails findById(int id);

	public void saveSwiftDetails(SwiftDetails swiftDetails);

	public void deleteSwiftDetails(SwiftDetails swiftDetails);

	public List<SwiftDetails> findByIdSwift(int theId);

	List<SwiftDetails> getDetailsFromLibelleTypeSwift(String libelle);

	List<SwiftDetails> getDetailsFromLibelleTypeChamp(String libelle);

}
