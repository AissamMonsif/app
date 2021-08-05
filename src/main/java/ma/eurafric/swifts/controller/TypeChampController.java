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
import ma.eurafric.swifts.entity.TypeChamp;
import ma.eurafric.swifts.services.TypeChampService;

@Controller
public class TypeChampController {

	@Autowired
	TypeChampService typeChampService;

	@RequestMapping("/champs")
	public String listChamps(Model theModel) {
		
		List<TypeChamp> champs = typeChampService.findAllTypesChamps();
		theModel.addAttribute("champs", champs);
		
		return "list-typeChamp";
	}

	@GetMapping("/get-fields")
	public ResponseEntity<Object> getFields(@RequestParam(name = "type", required = false) String type) {
		List<TypeChamp> fields = typeChampService.getFieldsByTypeSwiftLibelle(type);
		ServiceResponse<List<TypeChamp>> response = new ServiceResponse<>("successSwift", fields);
		ResponseEntity<Object> o=null;
		try {
			o=new ResponseEntity<Object>(response, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return o;
	}
}
