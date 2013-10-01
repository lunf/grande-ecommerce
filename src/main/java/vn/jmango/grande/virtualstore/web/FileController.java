package vn.jmango.grande.virtualstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileController {

	@RequestMapping(value = "/products/{productId}/file/new", method = RequestMethod.GET)
	public String initFile(Model model) {
		//model.addAttribute()
		return "file/createFile";
	}
}
