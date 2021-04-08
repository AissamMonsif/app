package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DAO.SwiftDetailsRepository;
import com.example.demo.DAO.SwiftRepository;
import com.example.demo.DAO.TypeChampRepository;
import com.example.demo.DAO.TypeSwiftRepository;
import com.example.demo.entity.Swift;
import com.example.demo.entity.SwiftDetails;
import com.example.demo.entity.TypeChamp;
import com.example.demo.entity.TypeSwift;
import com.example.demo.services.SwiftDetailsService;
import com.example.demo.services.SwiftService;
import com.example.demo.services.TypeSwiftService;

@Controller
@RequestMapping("/")
public class SwiftController {

	@Autowired
	TypeSwiftRepository typeSwiftRepository;
	@Autowired
	TypeChampRepository typeChampRepository;
	@Autowired
	SwiftRepository swiftRepository;
	@Autowired
	SwiftDetailsRepository swiftDetailsRepository;
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

	@GetMapping("/types")
	public String listTypeSwifts(Model theModel) {

		List<TypeSwift> theTypeSwifts = typeSwiftRepository.findAll();
		theModel.addAttribute("typeSwifts", theTypeSwifts);

		return "list-typeSwift";
	}

	@GetMapping("/champs")
	public String listTypeChamps(Model theModel) {

		List<TypeChamp> theTypeChamps = typeChampRepository.findAll();
		theModel.addAttribute("typeChamps", theTypeChamps);

		return "list-typeChamp";
	}

	@GetMapping("/swifts")
	public String listSwifts(Model theModel) {

		List<Swift> theSwifts = swiftRepository.findAll();
		theModel.addAttribute("listSwifts", theSwifts);

		return "list-swifts";
	}

	@GetMapping("/details")
	public String listSwiftDetails(Model theModel) {

		List<SwiftDetails> theSwiftDetails = swiftDetailsRepository.findAll();
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
	public String swiftsByTypes(@RequestParam("typeSwiftId")int theId,Model theModel) {

		List<Swift> swifts = typeSwiftService.getByTypeSwift(theId);
		theModel.addAttribute("swiftsByType", swifts);

		return "swifts-by-types";
	}

}
