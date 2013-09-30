package vn.jmango.grande.virtualstore.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
@SessionAttributes("color")
public class ColorController {

	private final ClinicService clinicService;

	@Autowired
	public ColorController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@RequestMapping(value = "/color/new", method = RequestMethod.GET)
	public String newColor(Map<String, Object> model) {
		List<Color> colors = this.clinicService.getAllColor();
		model.put("color", new Color());
		model.put("colors", colors);
		return "color/createColor";
	}

	@RequestMapping(value = "/color/new", method = RequestMethod.POST)
	public String addColor(@Valid Color color, Map<String, Object> model,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			List<Color> colors = this.clinicService.getAllColor();
			model.put("color", new Color());
			model.put("colors", colors);
			return "color/createColor";
		} else {
			this.clinicService.saveColor(color);
			status.setComplete();
			List<Color> colors = this.clinicService.getAllColor();
			model.put("color", new Color());
			model.put("colors", colors);
			return "color/createColor";
		}
	}
}
