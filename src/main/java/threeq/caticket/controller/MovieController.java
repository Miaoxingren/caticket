package threeq.caticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import threeq.caticket.entities.Movie;
import threeq.caticket.services.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	public MovieController() {
		super();
	}
	
	@ModelAttribute("movies")
	public List<Movie> populateMovies() {
		return this.movieService.findAll();
	}

	@RequestMapping("/movies")
	public String showAllMovies(Model model) {
		return "home-movie";
	}
}
