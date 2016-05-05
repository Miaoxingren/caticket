package threeq.caticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import threeq.caticket.entities.Cinema;
import threeq.caticket.services.CinemaService;

@Controller
public class CinemaController {
	@Autowired
	private CinemaService cinemaService;
	
	public CinemaController() {
		super();
	}
	
	@ModelAttribute("cinemas")
	public List<Cinema> populateCinemas() {
		return this.cinemaService.findAll();
	}

	@RequestMapping({"/", "/cinemas"})
	public String showAllCinemas(Model model) {
		return "home-cinema";
	}
}
