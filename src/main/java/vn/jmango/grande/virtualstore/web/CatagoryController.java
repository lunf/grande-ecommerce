package vn.jmango.grande.virtualstore.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import vn.jmango.grande.virtualstore.model.Catagory;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
public class CatagoryController {

	private ClinicService clinicService;

	@Autowired
	public CatagoryController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	@RequestMapping(value = "/catagory/new", method = RequestMethod.GET)
	public String newCatagory(Map<String, Object> model) {
		List<Catagory> catagories = this.clinicService.getAllCatagory();
		model.put("catagory", new Catagory());
		model.put("catagories", catagories);
		return "catagory/createCatagory";
	}

	@RequestMapping(value = "/catagory/new", method = RequestMethod.POST)
	public String addCatagory(@Valid Catagory catagory, Map<String, Object> model,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			List<Catagory> catagories = this.clinicService.getAllCatagory();
			model.put("catagory", new Catagory());
			model.put("catagories", catagories);
			return "catagory/createCatagory";
		} else {
			this.clinicService.saveCatagory(catagory);
			status.setComplete();
			List<Catagory> catagories = this.clinicService.getAllCatagory();
			model.put("catagory", new Catagory());
			model.put("catagories", catagories);
			return "catagory/createCatagory";
		}
	}

}
