package vn.jmango.grande.virtualstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
public class PieceController {

	private ClinicService clinicService;

	@Autowired
	public PieceController(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/products/{productId}/piece/new", method = RequestMethod.GET)
	public String initPiece(@PathVariable("productId") int productId,
			Map<String, Object> model) {
		List<Color> colors = this.clinicService.getAllColor();
		List<Material> materials = this.clinicService.getAllMaterial();
		Product product = this.clinicService.findProductById(productId);
		Piece piece = new Piece();
		System.out.println(product.getId());
		List<Piece> pieces = product.getPieces();
		if (pieces == null || pieces.isEmpty())
		{
			pieces = new ArrayList<Piece>();
			
			pieces.add(piece);
			
			product.setPieces(pieces);
			
		}
		else
		{
			product.getPieces().add(piece);
		}
		
		model.put("materials", materials);
		model.put("colors", colors);
		model.put("piece", piece);
		return "piece/createPiece";
	}

	@RequestMapping(value = "/products/{productId}/piece/new", method = RequestMethod.POST)
	public String creatPiece(@ModelAttribute("piece") Piece piece,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "piece/createPiece";
		} else {
			this.clinicService.savePiece(piece);
			status.setComplete();
			return "redirect:/products/{productId}";
		}

	}

}
