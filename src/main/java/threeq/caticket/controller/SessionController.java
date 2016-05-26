package threeq.caticket.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import threeq.caticket.services.CinemaService;
import threeq.caticket.services.MovieService;
import threeq.caticket.services.SessionService;


@Controller
public class SessionController {
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CinemaService cinemaService;
	
	public SessionController() {
		super();
	}
	
	@ModelAttribute  
    public void populateCinema(@RequestParam("cinemaId") int cinemaId, Model model) {  
		model.addAttribute("cinema", this.cinemaService.findById(cinemaId));
    }  
	
	@ModelAttribute  
    public void populateMovie(@RequestParam("movieId") int movieId, Model model) {  
		model.addAttribute("movie", this.movieService.findById(movieId));
    }
	
	@ModelAttribute
    public void populateSessions(@RequestParam(value="order", required=false) Integer order, Model model) {
		int orderVal = ((order == null) ? 1 : order.intValue());
		java.util.Date now = new java.util.Date();
		Date date = new Date(now.getTime() + (orderVal - 1) * 24 * 60 * 60 * 1000);
		Date today = new Date(now.getTime());
		Date tomorrow = new Date(now.getTime() + 1 * 24 * 60 * 60 * 1000);
		Date aftertomorrow = new Date(now.getTime() + 2 * 24 * 60 * 60 * 1000);
		model.addAttribute("today", today);
		model.addAttribute("tomorrow", tomorrow);
		model.addAttribute("aftertomorrow", aftertomorrow);
		model.addAttribute("order", orderVal);
		model.addAttribute("allSessions", this.sessionService.findByDate(date));
    }

	@RequestMapping(value="/session")
	public String showAllSessions(Model model) {
		return "movie-sessions";
	}
}
