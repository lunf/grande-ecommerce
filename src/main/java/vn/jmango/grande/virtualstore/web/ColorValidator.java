package vn.jmango.grande.virtualstore.web;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import vn.jmango.grande.virtualstore.model.Color;

public class ColorValidator {

	public void validate(Color color, Errors errors) {
		String name = color.getName();
		if (!StringUtils.hasLength(name)) {
			errors.rejectValue("name", "required", "required");
		} else if (color.isNew() && color.getCodeColor() == null) {
			errors.rejectValue("Code", "required", "required");
		}
	}
}
