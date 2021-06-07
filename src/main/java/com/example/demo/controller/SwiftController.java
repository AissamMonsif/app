package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Swift;
import com.example.demo.entity.SwiftDetails;
import com.example.demo.entity.TypeChamp;
import com.example.demo.entity.TypeSwift;
import com.example.demo.services.SwiftDetailsService;
import com.example.demo.services.SwiftService;
import com.example.demo.services.TypeChampService;
import com.example.demo.services.TypeSwiftService;

@Controller
public class SwiftController {

	@Autowired
	TypeChampService typeChampService;
	@Autowired
	SwiftDetailsService swiftDetailsService;
	@Autowired
	SwiftService swiftService;
	@Autowired
	TypeSwiftService typeSwiftService;

	Swift swift = new Swift();

	@GetMapping("/")
	public String welcome(Model theModel) {

		return "home";
	}

//	@GetMapping("/login")
//	public String login(Model theModel) {
//
//		return "login";
//	}

	@GetMapping("/types")
	public String listTypeSwifts(Model theModel) {

		List<TypeSwift> theTypeSwifts = typeSwiftService.findAllTypes();
		theModel.addAttribute("typeSwifts", theTypeSwifts);

		return "list-typeSwift";
	}

	@GetMapping("/champs")
	public String listTypeChamps(Model theModel) {

		List<TypeChamp> theTypeChamps = typeChampService.findAllTypesChamps();
		theModel.addAttribute("typeChamps", theTypeChamps);

		return "list-typeChamp";
	}

	@GetMapping("/swifts")
	public String listSwifts(Model theModel) {

		List<Swift> theSwifts = swiftService.findAllSwifts();
		theModel.addAttribute("listSwifts", theSwifts);

		return "list-swifts";
	}
	
	@GetMapping("/details")
	public String listSwiftDetails(Model theModel) {

		List<SwiftDetails> theSwiftDetails = swiftDetailsService.findAllSwiftsDetails();
		theModel.addAttribute("listSwiftDetails", theSwiftDetails);

		return "list-swiftDetails";
	}

	@GetMapping("/swifts/showDetails/{id}")
	public String detailsSwift(@RequestParam("swiftId") int theId, Model theModel) {

		List<SwiftDetails> theDetails = swiftDetailsService.findByIdSwift(theId);
		theModel.addAttribute("detailsSwift", theDetails);

		return "detail-swift";
	}

	@GetMapping("/details/showSwift/{id}")
	public String editSwift(@RequestParam("swiftId") int theId, Model theModel) {

		Swift theSwift = swiftService.getSwiftFromDetails(theId);
		theModel.addAttribute("swift", theSwift);

		return "edit-swift";
	}

	@GetMapping("/types/showSwiftsByTypes/{id}")
	public String swiftsByTypes(@RequestParam("typeSwiftId") int theId, Model theModel) {

		List<Swift> swifts = typeSwiftService.getByTypeSwift(theId);
		theModel.addAttribute("swiftsByType", swifts);

		return "swifts-by-types";
	}

	@GetMapping("/swifts/showSwiftsBySens/{sens}")
	public String swiftsBySens(@RequestParam("sensSwift") String sens, Model theModel) {

		List<Swift> swifts = swiftService.getSwiftsBySens(sens);
		theModel.addAttribute("swiftsBySens", swifts);

		return "swifts-by-sens";
	}

	@GetMapping("/details/showSwiftsByLibelleType/{libelleType}")
	public String detailsByLibelleTypeSwift(@RequestParam("libelleTypeSwift") String libelle, Model theModel) {

		List<SwiftDetails> details = swiftDetailsService.findByLibelleTypeSwift(libelle);
		List<TypeChamp> fields = typeChampService.getFieldsFromLibelleTypeSwift(libelle);
		
		theModel.addAttribute("detailsByLibelleTypeSwift", details);
		theModel.addAttribute("theFields",fields);
		
		return "details-by-libelle-type-swift";
	}
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	  

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
