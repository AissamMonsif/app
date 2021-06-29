package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Swift;
import com.example.demo.entity.TypeSwift;
import com.example.demo.services.TypeSwiftService;

@Controller
public class TypeSwiftController {

	@Autowired
	TypeSwiftService typeSwiftService;
	
	@RequestMapping("/types")
	public String viewTypesSwiftsPage(Model theModel) {
		return listTypeSwifts(theModel, 1, "libelle", "asc");
	}

	@GetMapping("/types/{pageNum}")
	public String listTypeSwifts(Model theModel, @PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir) {

		Page<TypeSwift> page = typeSwiftService.findAllTypes(pageNum, sortField, sortDir);
		List<TypeSwift> listTypeSwifts = page.getContent();

		theModel.addAttribute("currentPage", pageNum);
		theModel.addAttribute("totalPages", page.getTotalPages());
		theModel.addAttribute("totalItems", page.getTotalElements());

		theModel.addAttribute("sortField", sortField);
		theModel.addAttribute("sortDir", sortDir);
		theModel.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		theModel.addAttribute("listTypeSwifts", listTypeSwifts);

		return "list-typeSwift";
	}
	
	@GetMapping("/types/showSwiftsByTypes/{id}")
	public String swiftsByTypes(@RequestParam("typeSwiftId") int theId, Model theModel) {

		List<Swift> swifts = typeSwiftService.getByTypeSwift(theId);
		theModel.addAttribute("swiftsByType", swifts);

		return "swifts-by-types";
	}
}
