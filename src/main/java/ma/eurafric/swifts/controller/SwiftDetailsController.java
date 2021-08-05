package ma.eurafric.swifts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.eurafric.swifts.ServiceResponse;
import ma.eurafric.swifts.DAO.TypeChampRepository;
import ma.eurafric.swifts.entity.Swift;
import ma.eurafric.swifts.entity.SwiftDetails;
import ma.eurafric.swifts.services.SwiftDetailsService;
import ma.eurafric.swifts.services.SwiftService;

@Controller
public class SwiftDetailsController {

	@Autowired
	SwiftDetailsService swiftDetailsService;

	@Autowired
	SwiftService swiftService;

	@Autowired
	TypeChampRepository typeChampRepo;

	@RequestMapping("/details")
	public String listDetails(Model theModel) {
		List<SwiftDetails> details = swiftDetailsService.findAllDetails();
		theModel.addAttribute("details", details);
		
		return "list-swiftDetails";
	}

	@GetMapping("/details/showSwift/{id}")
	public String editSwift(@RequestParam("swiftId") int theId, Model theModel) {

		Swift theSwift = swiftService.getSwiftFromDetails(theId);
		theModel.addAttribute("swift", theSwift);

		return "edit-swift";
	}

	@GetMapping("/get-details")
	public ResponseEntity<Object> getDetails(@RequestParam(name = "type", required = false) String type) {
		List<SwiftDetails> details = swiftDetailsService.getDetailsFromLibelleTypeSwift(type);
		ServiceResponse<List<SwiftDetails>> response = new ServiceResponse<>("successSwift", details);
		ResponseEntity<Object> o = null;
		try {
			o = new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return o;
	}


}
