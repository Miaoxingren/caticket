package threeq.caticket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import threeq.caticket.entities.Cinema;
import threeq.caticket.services.CinemaService;
import threeq.caticket.services.MovieService;

@Controller
public class CinemaController {
	@Autowired
	private CinemaService cinemaService;
	@Autowired
	private MovieService movieService;
	
	public CinemaController() {
		super();
	}
	
	@ModelAttribute
	public void cinemaControlMain(@RequestParam(value="movieId",required=false) Integer movieId,
			@RequestParam(value="searchkey",required=false) String searchkey,
			Model model) {
		List<Cinema> cinemas;
		int movieid = 0;
		if (searchkey != null) {
			cinemas = this.cinemaService.findAll();
			for (int i = 0, len = cinemas.size(); i < len; len = cinemas.size()) {
				if (!cinemas.get(i).getName().contains(searchkey)) {
					cinemas.remove(i);
				} else {
					++i;
				}
			}
		} else if (movieId == null) {
			cinemas = this.cinemaService.findAll();
		} else {
			movieid = movieId.intValue();
			cinemas = this.cinemaService.findPartById(this.movieService.findById(movieid).getCinemaList());
		}
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("movie", movieid);
	}

	@RequestMapping({"/", "/cinemas"})
	public String showCinemas(HttpServletRequest req,  HttpServletRequest res, Model model) {
		return "home-cinema";
	}
	
	
	
}
