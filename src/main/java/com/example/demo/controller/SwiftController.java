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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ServiceResponse;
import com.example.demo.entity.Swift;
import com.example.demo.entity.SwiftDetails;
import com.example.demo.services.SwiftDetailsService;
import com.example.demo.services.SwiftService;

@Controller
public class SwiftController {

	@Autowired
	SwiftDetailsService swiftDetailsService;
	@Autowired
	SwiftService swiftService;


	@GetMapping("/swifts")
	public String viewSwiftsPage(Model theModel) {

		return listSwifts(theModel, 1, "sens", "asc");
	}

	@GetMapping("/swifts/{pageNum}")
	public String listSwifts(Model theModel, @PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir) {

		Page<Swift> page = swiftService.findAllSwifts(pageNum, sortField, sortDir);
		List<Swift> theSwifts = page.getContent();

		theModel.addAttribute("currentPage", pageNum);
		theModel.addAttribute("totalPages", page.getTotalPages());
		theModel.addAttribute("totalItems", page.getTotalElements());

		theModel.addAttribute("sortField", sortField);
		theModel.addAttribute("sortDir", sortDir);
		theModel.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		theModel.addAttribute("listSwifts", theSwifts);

		return "list-swifts";
	}
	
	@GetMapping("/swifts/showDetails/{id}")
	public String detailsSwift(@RequestParam("swiftId") int theId, Model theModel) {

		List<SwiftDetails> theDetails = swiftDetailsService.findByIdSwift(theId);
		theModel.addAttribute("detailsSwift", theDetails);

		return "detail-swift";
	}

	@GetMapping("/get-swifts-sens")
	public ResponseEntity<Object> getSwiftsBySens(@RequestParam(name="sens",required=false) String sens) {
		List<Swift> swifts = swiftService.getSwiftsBySens(sens);
		ServiceResponse<List<Swift>> response = new ServiceResponse<>("successSwift", swifts);
		ResponseEntity<Object> o=null;
		try {
			o=new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return o;
	}
	


}
