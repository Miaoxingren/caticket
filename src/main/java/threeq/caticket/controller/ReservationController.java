package threeq.caticket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import threeq.caticket.entities.Reservation;
import threeq.caticket.entities.SeatInfo;
import threeq.caticket.entities.Session;
import threeq.caticket.services.CinemaService;
import threeq.caticket.services.MovieService;
import threeq.caticket.services.ReservationService;
import threeq.caticket.services.SeatService;
import threeq.caticket.services.SessionService;
import threeq.caticket.services.UserService;

@Controller
public class ReservationController {
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
    private UserService userService;

	@ModelAttribute("userId")
	public void getUser(HttpServletRequest req, Model model) {
		String username = req.getRemoteUser();
		if (username == null) {
			model.addAttribute("userId", -1);
		} else {
			model.addAttribute("userId", userService.findByName(username).getId());
		}
	}
	
	@RequestMapping(value="/pay", params={"sessionId"})
	public String makeReservation(@ModelAttribute("userId") int userId,
			@ModelAttribute(value="seatInfo") SeatInfo seatInfo,
			@RequestParam("sessionId") int sessionId, Model model) {
		if (userId == -1) {
			return "redirect:/login";
		}
		Session session = this.sessionService.findById(sessionId);
		boolean chose = this.seatService.updateSeat(session.getSeatId(), seatInfo);
		if (chose) {
			Reservation temp = new Reservation();
			temp.setUserId(userId);
			temp.setSessionId(sessionId);
			temp.setSeatCnt(seatInfo.getSeatCnt());
			temp.setSeats(seatInfo.getSeats());
			temp.setPrice(Float.parseFloat(seatInfo.getPrice()));
			temp.setPaied(true);
			this.reservationService.addOne(temp);
		}
		return "redirect:/reservation";
	}
	
	@RequestMapping(value="/reservation")
	public String showReservation(
			@ModelAttribute("userId") int userId, Model model) {
		if (userId == -1) {
			return "redirect:/login";
		}
		model.addAttribute("reservations", this.reservationService.findByUserId(userId));
		model.addAttribute("cinemaService", cinemaService);
		model.addAttribute("movieService", movieService);
		model.addAttribute("sessionService", sessionService);
		model.addAttribute("reservationService", reservationService);
		return "reservation";
	}
}
