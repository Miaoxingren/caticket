package threeq.caticket.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import threeq.caticket.entities.CImage;
import threeq.caticket.services.CImageService;

@Controller
public class ImageController {
	
	@Autowired
	private CImageService cimageService;
	
	public ImageController() {
		super();
	}
	
	@RequestMapping(value= "/img")
	public void showCImages(@RequestParam(value="imgId") int imgId, 
			HttpServletRequest req,  HttpServletResponse res) throws SQLException, IOException {
		CImage img = this.cimageService.findById(imgId);
		if (img != null) {
			res.setContentType("image/jpg;charset=UTF-8");
			res.setCharacterEncoding("UTF-8");
            Blob blob = img.getSource();
            int size = (int) blob.length();
            InputStream inputStream = blob.getBinaryStream();
			ServletOutputStream outputStream = res.getOutputStream();
	        byte[] bytes = new byte[size];
	        int len = 0;
	        while ((len = inputStream.read(bytes)) != -1) {
	        	outputStream.write(bytes, 0, len);
	        }
	        outputStream.flush();
	        outputStream.close();
            inputStream.close();
        }
	}
	
}
