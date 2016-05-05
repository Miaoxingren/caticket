package threeq.caticket.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import threeq.caticket.entities.Line;
import threeq.caticket.entities.Reservation;
import threeq.caticket.services.ReservationService;
import threeq.caticket.services.SeatService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private SeatService seatService;
	
	public ReservationController() {
		super();
	}
	/*
	@ModelAttribute("reservations")
	public List<Reservation> populateReservations() {
		return this.reservationService.findAll();
	}
	*/
	@ModelAttribute("lines")
	public List<Line> populateSeats() {
		return this.seatService.findAll();
	}

	@RequestMapping("/reservations")
	public String showAllReservations(Model model) {
		model.addAttribute("movieName", "The Huntsman");
		model.addAttribute("cinema", "Guangzhou central cinema");
		model.addAttribute("sessionTime", new Date());
		model.addAttribute("sessionLang", "English 3D");
		model.addAttribute("sessionRoom", 1);
		model.addAttribute("sessionPrice", 35.5);
		return "reservation";
	}
}
