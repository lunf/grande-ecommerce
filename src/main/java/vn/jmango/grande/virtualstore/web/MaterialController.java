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
	public String addMaterial(@Valid Material material, Map<String, Object> model,
			BindingResult result, SessionStatus status) {
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
}
