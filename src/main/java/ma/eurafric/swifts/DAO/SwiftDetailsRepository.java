package ma.eurafric.swifts.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.eurafric.swifts.entity.SwiftDetails;

public interface SwiftDetailsRepository extends JpaRepository<SwiftDetails, Integer> {

	List<SwiftDetails> findBySwift_typeSwift_libelle(String libelle);
	
	List<SwiftDetails> findByTypeChamp_libelle(String libelle);

}
