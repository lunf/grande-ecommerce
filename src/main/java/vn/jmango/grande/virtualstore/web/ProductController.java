package vn.jmango.grande.virtualstore.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
@SessionAttributes(types = Product.class)
public class ProductController {

	private final ClinicService clinicService;

	@Autowired
	public ProductController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/products/new", method = RequestMethod.GET)
	public String initCreationForm(Map<String, Object> model) {
		List<Color> colors =this.clinicService.getAllColor();
		List<Material> materials= this.clinicService.getAllMaterial();
		model.put("materials", materials);
		model.put("colors", colors);
		model.put("product", new Product());
		return "products/createOrUpdateProductForm";
	}

	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Product product,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "products/createOrUpdateProductForm";
		} else {
			this.clinicService.saveProduct(product);
			status.setComplete();
			return "redirect:/products/" + product.getId();
		}
	}

	@RequestMapping(value = "/products/find", method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("product", new Product());
		return "products/findProducts";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String processFindForm(Product product, BindingResult result,
			Map<String, Object> model) {

		// allow parameterless GET request for /owners to return all records
		if (product.getName() == null) {
			product.setName(""); // empty string signifies broadest possible
		}

		// find owners by last name
		Collection<Product> results = this.clinicService
				.findProductByName(product.getName());
		if (results.size() < 1) {
			// no owners found
			result.rejectValue("name", "notFound", "not found");
			return "products/findProducts";
		}
		if (results.size() > 1) {
			// multiple products found
			model.put("selections", results);
			return "products/productsList";
		} else {
			// 1 product found
			product = results.iterator().next();
			return "redirect:/products/" + product.getId();
		}
	}

	@RequestMapping(value = "/products/{productId}/edit", method = RequestMethod.GET)
	public String initUpdateProductForm(
			@PathVariable("productId") int productId, Model model) {
		Product product = this.clinicService.findProductById(productId);
		model.addAttribute(product);
		List<Color> colors =this.clinicService.getAllColor();
		List<Material> materials= this.clinicService.getAllMaterial();
		model.addAttribute("materials", materials);
		model.addAttribute("colors", colors);
		return "products/createOrUpdateProductForm";
	}

	@RequestMapping(value = "/products/{productId}/edit", method = RequestMethod.PUT)
	public String processUpdateProductForm(@Valid Product product,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "product/createOrUpdateProductForm";
		} else {
			this.clinicService.saveProduct(product);
			status.setComplete();
			return "redirect:/products/{productId}";
		}
	}

	/**
	 * Custom handler for displaying an owner.
	 * 
	 * @param productId
	 *            the ID of the owner to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/products/{productId}")
	public ModelAndView showProduct(@PathVariable("productId") int productId) {
		ModelAndView mav = new ModelAndView("products/productDetails");
		mav.addObject(this.clinicService.findProductById(productId));
		return mav;
	}

}
