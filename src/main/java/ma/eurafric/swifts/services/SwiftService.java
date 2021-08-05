package ma.eurafric.swifts.services;

import java.util.List;


import ma.eurafric.swifts.entity.Swift;

public interface SwiftService {

	public List<Swift> findAllSwifts();

	public List<Swift> getSwiftsBySens(String sens);

	public Swift findById(int id);

	public void saveSwift(Swift swift);

	public void deleteSwift(Swift swift);

	public Swift getSwiftFromDetails(int theId);

}
