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
		new ColorValidator().validate(color, result);
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
	
	@RequestMapping(value = "/color/{colorId}/edit", method = RequestMethod.GET)
	public String editCatagory(@PathVariable("colorId") Integer colorId,
			Map<String, Object> model) {
		Color color  = this.clinicService.findColorById(colorId);
		List<Color> colors = this.clinicService.getAllColor();
		model.put("color", color);
		model.put("colors", colors);
		return "color/createColor";
	}

	@RequestMapping(value = "/color/{colorId}/edit", method = RequestMethod.PUT)
	public String UpdateCatagory(@Valid Color color,
			@PathVariable("colorId") Integer colorId,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "redirect:/color/new";
		} else {
			color.setId(colorId);
			this.clinicService.saveColor(color);
			status.setComplete();
			return "redirect:/color/new";
		}
	}
	
	@RequestMapping(value = "/color/{colorId}/delete", method = RequestMethod.GET)
	public String deleteCatagory(
			@PathVariable("colorId") Integer colorId,
			Map<String, Object> model) {
		System.out.println("Gia tri cua Catagory:" + colorId);
		this.clinicService.deleteColor(colorId);
		List<Color> colors = this.clinicService.getAllColor();
		model.put("color", new Color());
		model.put("colors", colors);
		return "redirect:/color/new";
	}
}
