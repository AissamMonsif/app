package ma.eurafric.swifts.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.eurafric.swifts.entity.TypeChamp;

public interface TypeChampRepository extends JpaRepository<TypeChamp, Integer>  {

	List<TypeChamp> findByTypeSwift_libelle(String libelle);	
}
