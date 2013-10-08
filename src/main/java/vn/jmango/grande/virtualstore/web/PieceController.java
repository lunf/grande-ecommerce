package vn.jmango.grande.virtualstore.web;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import vn.jmango.grande.virtualstore.model.Color;
import vn.jmango.grande.virtualstore.model.JmFile;
import vn.jmango.grande.virtualstore.model.Material;
import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
@SessionAttributes("pieces")
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
		model.put("materials", materials);
		model.put("colors", colors);
		model.put("piece", new Piece());
		return "piece/createPiece";
	}

	@RequestMapping(value = "/products/{productId}/piece/new", method = RequestMethod.POST)
	public String creatPiece(@PathVariable("productId") int productId,
			@ModelAttribute("piece") Piece piece, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "piece/createPiece";
		} else {

			Product product = this.clinicService.findProductById(productId);
			product.addPiece(piece);
			this.clinicService.savePiece(piece);
			status.setComplete();
			return "redirect:/products/{productId}";
		}

	}

	@RequestMapping(value = "/products/{productId}/piece/{pieceId}/edit", method = RequestMethod.GET)
	public String initEditPiece(@PathVariable("pieceId") int pieceId,
			Model model) {
		Piece piece = this.clinicService.findPieceById(pieceId);
		model.addAttribute("piece", piece);
		List<Color> colors = this.clinicService.getAllColor();
		List<Material> materials = this.clinicService.getAllMaterial();
		model.addAttribute("materials", materials);
		model.addAttribute("colors", colors);
		return "piece/createPiece";
	}

	@RequestMapping(value = "/products/{productId}/piece/{pieceId}/edit", method = RequestMethod.PUT)
	public String updatePiece(@Valid Piece piece,
			@PathVariable("productId") int productId,
			@PathVariable("pieceId") int pieceId, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "piece/createPiece";
		} else {
			Product product = this.clinicService.findProductById(productId);
			piece.setId(pieceId);
			product.addPiece(piece);
			this.clinicService.savePiece(piece);
			status.isComplete();
			return "redirect:/products/{productId}";
		}
	}

	@RequestMapping(value = "/products/{productId}/piece/{pieceId}/deletePiece", method = RequestMethod.GET)
	public String deletePiece(@PathVariable("pieceId") Integer pieceId,
			@PathVariable("productId") Integer productId) {
		System.out.println("sdfsdgf" + pieceId);
		Product product = this.clinicService.findProductById(productId);
		for (Piece piece : product.getPieces()) {
			if (piece.getId() == pieceId) {
				for (JmFile file : piece.getImages()) {
//					this.clinicService.deleteFile(file.getId());
					piece.getImages().remove(file);
					piece.getImages().clear();
				}
				
				this.clinicService.deletePiece(pieceId);
				product.getPieces().remove(piece);
				product.getPieces();
			}
		}
		this.clinicService.saveProduct(product);
		
		
		return "redirect:/products/{productId}";
	}

}
