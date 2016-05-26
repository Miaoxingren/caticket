package threeq.caticket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import threeq.caticket.entities.User;
import threeq.caticket.services.UserService;

@Controller
public class SUserController {
	@Autowired
    private UserService userService;

	public SUserController() {
		super();
	}
	
	@RequestMapping({"/user"})
	public String showUser(HttpServletRequest req) {
		if (req.getRemoteUser() != null) {
			return "redirect:/setting";
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login", method={RequestMethod.GET})
	public String showLogin(HttpServletRequest req) {
		if (req.getRemoteUser() != null) {
			return "redirect:/movies";
		}
		return "suser";
	}
	
	@RequestMapping({"/logout"})
	public String showLogout() {
		return "shello";
	}
	
	@RequestMapping(value="/register", method={RequestMethod.GET, RequestMethod.POST})
    public String register(@ModelAttribute("user") @Validated User user, Model model, HttpServletRequest req, HttpServletResponse res) {
		if (req.getRemoteUser() != null) {
			return "redirect:/movies";
		}
		if (req.getMethod().equals("GET")) {
			return "sregister";
		}
		String username = user.getUsername(), password = user.getPassword();
    	User temp = userService.findByName(username);
    	if (temp != null) {
            model.addAttribute("error", "User exists.");
            return "sregister";
        }
    	int id = userService.insert(username, password);
    	if (id < 0) {
            model.addAttribute("error", "Register failed. Please try again.");
            return "sregister";
        }
    	return "redirect:/login";
    }
	
	
	@RequestMapping(value="/setting", method={RequestMethod.GET})
    public String showSetting(@ModelAttribute("user") @Validated User user, Model model, HttpServletRequest req) {
		if (req.getRemoteUser() == null) {
			return "redirect:/login";
		}
		if (req.getParameter("username") != null) {
			model.addAttribute("change", "username");
		} else if (req.getParameter("password") != null) {
			model.addAttribute("change", "password");
		}
		return "user";
    }
	
	
	@RequestMapping(value="/setting", method={RequestMethod.POST})
    public String settingEdit(@ModelAttribute("user") @Validated User user, Model model, HttpServletRequest req) {
		if (req.getRemoteUser() == null) {
			return "redirect:/login";
		}
    	User temp = userService.findByName(req.getRemoteUser());
    	if (temp == null) {
    		return "redirect:/login";
    	}
    	if (user.getUsername() != null) {
    		boolean success = userService.updateName(temp.getId(), user.getUsername());
            model.addAttribute("success", success);
            model.addAttribute("fail", !success);
            return "user";
        }
    	if (user.getPassword() != null) {
    		boolean success = userService.updatePassword(temp.getId(), user.getPassword());
    		model.addAttribute("success", success);
            model.addAttribute("fail", !success);
            return "user";
        }
    	return "redirect:/setting";
    }
	
}
