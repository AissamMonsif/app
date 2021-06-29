package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ServiceResponse;
import com.example.demo.entity.Swift;
import com.example.demo.entity.SwiftDetails;
import com.example.demo.services.SwiftDetailsService;
import com.example.demo.services.SwiftService;

@Controller
public class SwiftDetailsController {

	@Autowired
	SwiftDetailsService swiftDetailsService;

	@Autowired
	SwiftService swiftService;

	@RequestMapping("/details")
	public String viewDetailsPage(Model theModel) {
		return listSwiftDetails(theModel, 1, "typeChamp", "asc");
	}

	@GetMapping("/details/{pageNum}")
	public String listSwiftDetails(Model theModel, @PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir) {
		Page<SwiftDetails> page = swiftDetailsService.findAllSwiftsDetails(pageNum, sortField, sortDir);
		List<SwiftDetails> theSwiftDetails = page.getContent();

		theModel.addAttribute("currentPage", pageNum);
		theModel.addAttribute("totalPages", page.getTotalPages());
		theModel.addAttribute("totalItems", page.getTotalElements());

		theModel.addAttribute("sortField", sortField);
		theModel.addAttribute("sortDir", sortDir);
		theModel.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		theModel.addAttribute("listSwiftDetails", theSwiftDetails);

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
		//return new ResponseEntity<Object>(response, HttpStatus.OK);
		ResponseEntity<Object> o=null;
		try {
			o=new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return o;
	}
}
