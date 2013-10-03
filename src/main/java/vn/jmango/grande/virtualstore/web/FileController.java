package vn.jmango.grande.virtualstore.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.engine.jdbc.NonContextualLobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.jmango.grande.virtualstore.model.JmFile;
import vn.jmango.grande.virtualstore.model.Piece;
import vn.jmango.grande.virtualstore.model.Product;
import vn.jmango.grande.virtualstore.service.ClinicService;

@Controller
public class FileController {

	private ClinicService clinicService;

	@Autowired
	public FileController(ClinicService clinicService) {
		// TODO Auto-generated constructor stub
		this.clinicService = clinicService;
	}

	@RequestMapping(value = "/products/{productId}/file/new", method = RequestMethod.GET)
	public String initFile(@PathVariable("productId") int productId,
			Map<String, Object> model) {
		model.put("file", new JmFile());
		return "file/createFile";
	}

	@RequestMapping(value = "/products/{productId}/file/new", method = RequestMethod.POST)
	public String createFile(@RequestParam("file") MultipartFile file,
			@PathVariable("productId") int productId,
			@ModelAttribute("Jmfile") JmFile jmFile) {
		Product product = this.clinicService.findProductById(productId);
		jmFile.setProduct(product);
		byte[] data = new byte[(int) file.getSize()];

		try {
			file.getInputStream().read(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jmFile.setContentType(file.getContentType());
		jmFile.setName(file.getOriginalFilename());
		jmFile.setData(data);
		this.clinicService.saveFile(jmFile);
		return "redirect:/products/{productId}";
	}

	@RequestMapping(value = "/download/{fileId}")
	public String downloadFile(@PathVariable("fileId") Integer fileId,
			HttpServletResponse response) {

		JmFile file = this.clinicService.findFileById(fileId);
		response.setHeader("Content-Disposition",
				"inline;filename=\"" + file.getName() + "\"");
		OutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			InputStream inputStream = new ByteArrayInputStream(file.getData());
			response.setContentType(file.getContentType());
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/products/{productId}";
	}

	@RequestMapping(value = "/products/{productId}/piece/{pieceId}/addfile", method = RequestMethod.GET)
	public String initFilePiece(Map<String, Object> model) {
		model.put("file", new JmFile());
		return "file/createFile";
	}

	@RequestMapping(value = "/products/{productId}/piece/{pieceId}/addfile", method = RequestMethod.POST)
	public String addFilePiece(@RequestParam("file") MultipartFile file,
			@ModelAttribute("Jmfile") JmFile jmFile,
			@PathVariable("pieceId") Integer pieceId) {
		Piece piece = this.clinicService.findPieceById(pieceId);
		jmFile.setPiece(piece);
		byte[] data = new byte[(int) file.getSize()];

		try {
			file.getInputStream().read(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jmFile.setContentType(file.getContentType());
		jmFile.setName(file.getOriginalFilename());
		jmFile.setData(data);
		this.clinicService.saveFile(jmFile);
		return "redirect:/products/{productId}";
	}

	public static Blob createBlob(byte[] bytes) {
		return NonContextualLobCreator.INSTANCE
				.wrap(NonContextualLobCreator.INSTANCE.createBlob(bytes));
	}

}
