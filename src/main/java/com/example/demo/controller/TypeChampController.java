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

import com.example.demo.entity.TypeChamp;
import com.example.demo.services.TypeChampService;

@Controller
public class TypeChampController {

	@Autowired
	TypeChampService typeChampService;

	@RequestMapping("/champs")
	public String viewTypesChampsPage(Model theModel) {
		return listTypeChamps(theModel, 1, "libelle", "asc");
	}

	@GetMapping("/champs/{pageNum}")
	public String listTypeChamps(Model theModel, @PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir) {

		Page<TypeChamp> page = typeChampService.findAllTypesChamps(pageNum, sortField, sortDir);
		List<TypeChamp> theTypeChamps = page.getContent();

		theModel.addAttribute("currentPage", pageNum);
		theModel.addAttribute("totalPages", page.getTotalPages());
		theModel.addAttribute("totalItems", page.getTotalElements());

		theModel.addAttribute("sortField", sortField);
		theModel.addAttribute("sortDir", sortDir);
		theModel.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		theModel.addAttribute("typeChamps", theTypeChamps);

		return "list-typeChamp";
	}
}
