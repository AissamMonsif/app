package ma.eurafric.swifts.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.eurafric.swifts.entity.Swift;

public interface SwiftRepository extends JpaRepository<Swift, Integer> {

	List<Swift> findBySens(String sens);
	
	List<Swift> findByTypeSwift_libelle(String libelle);
	
	Page<Swift> findBySens(String sens, Pageable pageable);
}
