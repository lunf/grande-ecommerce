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

import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
public class MaterialController {

	private ClinicService clinicService;

	@Autowired
	public MaterialController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@RequestMapping(value = "/material/new", method = RequestMethod.GET)
	public String newMaterial(Map<String, Object> model) {
		List<Material> materials = this.clinicService.getAllMaterial();
		model.put("material", new Material());
		model.put("materials", materials);
		return "material/createMaterial";
	}

	@RequestMapping(value = "/material/new", method = RequestMethod.POST)
	public String addMaterial(@Valid Material material,
			Map<String, Object> model, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			List<Material> materials = this.clinicService.getAllMaterial();
			model.put("material", new Material());
			model.put("materials", materials);
			return "material/createMaterial";
		} else {
			this.clinicService.saveMaterial(material);
			status.setComplete();
			List<Material> materials = this.clinicService.getAllMaterial();
			model.put("material", new Material());
			model.put("materials", materials);
			return "material/createMaterial";
		}
	}

	@RequestMapping(value = "/material/{materialId}/edit", method = RequestMethod.GET)
	public String editCatagory(@PathVariable("materialId") Integer materialId,
			Map<String, Object> model) {
		Material material = this.clinicService.findMaterialById(materialId);
		List<Material> materials = this.clinicService.getAllMaterial();
		model.put("material", material);
		model.put("materials", materials);
		return "material/createMaterial";
	}

	@RequestMapping(value = "/material/{materialId}/edit", method = RequestMethod.PUT)
	public String UpdateCatagory(@Valid Material material,
			@PathVariable("materialId") Integer materialId,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "redirect:/material/new";
		} else {
			material.setId(materialId);
			this.clinicService.saveMaterial(material);
			status.setComplete();
			return "redirect:/material/new";
		}
	}

	@RequestMapping(value = "/material/{materialId}/delete", method = RequestMethod.GET)
	public String deleteCatagory(
			@PathVariable("materialId") Integer materialId,
			Map<String, Object> model) {
		System.out.println("Gia tri cua Catagory:" + materialId);
		this.clinicService.deleteMaterial(materialId);
		List<Material> materials = this.clinicService.getAllMaterial();
		model.put("color", new Material());
		model.put("colors", materials);
		return "redirect:/material/new";
	}
}
