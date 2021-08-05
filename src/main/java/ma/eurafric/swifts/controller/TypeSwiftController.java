package ma.eurafric.swifts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.eurafric.swifts.entity.Swift;
import ma.eurafric.swifts.entity.TypeSwift;
import ma.eurafric.swifts.services.TypeChampService;
import ma.eurafric.swifts.services.TypeSwiftService;

@Controller
public class TypeSwiftController {

	@Autowired
	TypeSwiftService typeSwiftService;

	@Autowired
	TypeChampService typeChampService;

	@RequestMapping("/types")
	public String viewTypesSwiftsPage(Model theModel) {
		
		List<TypeSwift> types = typeSwiftService.listAll();
		theModel.addAttribute("types", types);
		
		return "list-typeSwift";
	}

	

	@GetMapping("/types/showSwiftsByTypes/{id}")
	public String swiftsByTypes(@RequestParam("typeSwiftId") int theId, Model theModel) {

		List<Swift> swifts = typeSwiftService.getByTypeSwift(theId);
		theModel.addAttribute("swiftsByType", swifts);

		return "swifts-by-types";
	}

	
}
