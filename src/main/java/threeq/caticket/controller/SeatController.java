package threeq.caticket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import threeq.caticket.entities.SeatInfo;
import threeq.caticket.entities.Session;
import threeq.caticket.services.CinemaService;
import threeq.caticket.services.MovieService;
import threeq.caticket.services.SeatService;
import threeq.caticket.services.SessionService;

@Controller
public class SeatController {
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private SeatService seatService;
	
	public SeatController() {
		super();
	}
	
	@ModelAttribute  
    public void populateSession(@RequestParam("sessionId") int sessionId, Model model) {  
		Session session = this.sessionService.findById(sessionId);
		model.addAttribute("sessionItem", session);
		model.addAttribute("lines", this.seatService.findById(session.getSeatId()));
		model.addAttribute("cinema", this.cinemaService.findById(session.getCinemaId()));
		model.addAttribute("movie", this.movieService.findById(session.getMovieId()));
    }
	
	@RequestMapping(value="/seat", params={"sessionId"})
	public String showAllReservations(@ModelAttribute(value="seatInfo") SeatInfo seatInfo,Model model) {
		return "session-seat";
	}

}
