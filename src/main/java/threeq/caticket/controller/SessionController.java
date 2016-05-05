package threeq.caticket.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import threeq.caticket.entities.Session;
import threeq.caticket.services.SessionService;

@Controller
public class SessionController {
	@Autowired
	private SessionService sessionService;
	
	public SessionController() {
		super();
	}
	
	@ModelAttribute("sessions")
	public List<Session> populateSessions() {
		return this.sessionService.findAll();
	}

	@RequestMapping("/sessions")
	public String showAllSessions(Model model) {
		model.addAttribute("name", "The Huntsman");
		model.addAttribute("sessionDate",1);
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 1 * 24 * 60 * 60 * 1000);
		Date aftertomorrow = new Date(today.getTime() + 2 * 24 * 60 * 60 * 1000);
		model.addAttribute("today", today);
		model.addAttribute("tomorrow", tomorrow);
		model.addAttribute("aftertomorrow", aftertomorrow);
		return "movie-sessions";
	}
}
