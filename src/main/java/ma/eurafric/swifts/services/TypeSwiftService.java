package ma.eurafric.swifts.services;

import java.util.List;


import ma.eurafric.swifts.entity.Swift;
import ma.eurafric.swifts.entity.TypeSwift;

public interface TypeSwiftService {

	public List<TypeSwift> listAll();

	public TypeSwift findTypeById(int theId);

	public void saveTypeSwift(TypeSwift typeSwift);

	public void deleteTypeSwift(TypeSwift typeSwift);

	public List<Swift> getByTypeSwift(int theId);

	public List<Swift> getByLibelleSwift(String libelle);

}
