package threeq.caticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import threeq.caticket.entities.Movie;
import threeq.caticket.services.CinemaService;
import threeq.caticket.services.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	@Autowired
	private CinemaService cinemaService;
	
	public MovieController() {
		super();
	}
	
	@ModelAttribute
	public void cinemaControlMain(@RequestParam(value="cinemaId",required=false) Integer cinemaId, Model model) {
		List<Movie> movies;
		int cinemaid = 0;
		if (cinemaId == null) {
			movies = this.movieService.findAll();
		}
		else {
			cinemaid = cinemaId.intValue();
			movies = this.movieService.findPartById(this.cinemaService.findById(cinemaid).getMovieList());
		}
		model.addAttribute("movies", movies);
		model.addAttribute("cinema", cinemaid);
	}

	@RequestMapping("/movies")
	public String showMovies(@RequestParam(value="movieId", required=false) Integer id, Model model) {
		if (id != null) {
			Movie movie = movieService.findById(id.intValue());
			if (movie != null) {
				model.addAttribute("movie", movie);
				return "movie-info";
			}
		}
		return "home-movie";
	}
}
