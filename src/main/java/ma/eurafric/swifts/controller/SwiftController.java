package ma.eurafric.swifts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.eurafric.swifts.entity.Swift;
import ma.eurafric.swifts.entity.SwiftDetails;
import ma.eurafric.swifts.services.SwiftDetailsService;
import ma.eurafric.swifts.services.SwiftService;

@Controller
public class SwiftController {

	@Autowired
	SwiftDetailsService swiftDetailsService;
	@Autowired
	SwiftService swiftService;

	@GetMapping("/swifts/showDetails/{id}")
	public String detailsSwift(@RequestParam("swiftId") int theId, Model theModel) {

		List<SwiftDetails> theDetails = swiftDetailsService.findByIdSwift(theId);
		theModel.addAttribute("detailsSwift", theDetails);

		return "detail-swift";
	}

	@GetMapping("/swifts")
	public String listSwifts(Model theModel) {

		List<Swift> swifts = swiftService.findAllSwifts();
		theModel.addAttribute("swifts", swifts);

		return "list-swifts";
	}

	@GetMapping("/swiftsEntrant")
	public String listSwiftsEntrant(Model theModel) {

		List<Swift> swiftsEntrant = swiftService.getSwiftsBySens("Entrant");
		theModel.addAttribute("swiftsEntrant", swiftsEntrant);

		return "list-swifts-entrant";
	}

	@GetMapping("/swiftsSortant")
	public String listSwiftsSortant(Model theModel) {

		List<Swift> swiftsSortant = swiftService.getSwiftsBySens("Sortant");
		theModel.addAttribute("swiftsSortant", swiftsSortant);

		return "list-swifts-sortant";
	}

}
