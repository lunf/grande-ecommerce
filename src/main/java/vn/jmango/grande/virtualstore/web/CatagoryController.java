package vn.jmango.grande.virtualstore.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String addCatagory(@Valid Catagory catagory,
			Map<String, Object> model, BindingResult result,
			SessionStatus status) {
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

	@RequestMapping(value = "/catagory/{catagoryId}/edit", method = RequestMethod.GET)
	public String editCatagory(@PathVariable("catagoryId") Integer catagoryId,
			Map<String, Object> model) {
		Catagory catagory = this.clinicService.findCatagoryById(catagoryId);
		List<Catagory> catagories = this.clinicService.getAllCatagory();
		model.put("catagory", catagory);
		model.put("catagories", catagories);
		return "catagory/createCatagory";
	}

	@RequestMapping(value = "/catagory/{catagoryId}/edit", method = RequestMethod.PUT)
	public String UpdateCatagory(@Valid Catagory catagory,
			@PathVariable("catagoryId") Integer catagoryId,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "redirect:/catagory/new";
		} else {
			catagory.setId(catagoryId);
			this.clinicService.saveCatagory(catagory);
			status.setComplete();
			return "redirect:/catagory/new";
		}
	}

	@RequestMapping(value = "/catagory/{catagoryId}/delete", method = RequestMethod.GET)
	public String deleteCatagory(
			@PathVariable("catagoryId") Integer catagoryId,
			Map<String, Object> model) {
		System.out.println("Gia tri cua Catagory:" + catagoryId);
		this.clinicService.deleteCatagory(catagoryId);
		List<Catagory> catagories = this.clinicService.getAllCatagory();
		model.put("catagory", new Catagory());
		model.put("catagories", catagories);
		return "redirect:/catagory/new";
	}

}
