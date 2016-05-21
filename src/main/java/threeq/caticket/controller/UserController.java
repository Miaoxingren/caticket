package threeq.caticket.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import threeq.caticket.entities.User;
import threeq.caticket.services.UserService;

@Controller
public class UserController {
		
		@Autowired
		private UserService userService;
		
		public UserController() {
			super();
		}
		
		/*
		 * login
		 * */
		@RequestMapping({"/user", "/user/login"})
		public String loginPage(@ModelAttribute User user, HttpServletRequest req, HttpServletResponse res, Model model) {
			//not user-login
			if (req.getCookies() == null) {
				String name = user.getName(), password = user.getPassword();
				user.setName(null);
				user.setPassword(null);
				if ((name == "" && password == "") || (name == null && password == null)) {
					return "login";
				}
				
				if (name == "" || password == "") {
					model.addAttribute("errorInfoLogin", "用户名或者密码不能为空");
					return "login";
				}
				
				//user-login-test
				User temp = userService.findOne(name, password);
				
				//user-login-fail
				if (temp == null) {
					model.addAttribute("errorInfoLogin", "用户名或者密码错误");
					return "login";
				}
				
				//user-login-success
				setCookie(res, name, temp.getId());
				return "redirect:/movies";
			} else {
				return "redirect:/user/info";
			}
		}
		
		/*
		 * register
		 * */
		@RequestMapping(value="/user/register", method={RequestMethod.POST, RequestMethod.GET})
		public String register(@ModelAttribute("user") @Validated User user, Model model, HttpServletRequest req, HttpServletResponse res) {
			
			if (req.getCookies() == null) {
				String name = user.getName(), password = user.getPassword();
				user.setName(null);
				user.setPassword(null);
				
				if ((name == "" && password == "") || (name == null && password == null)) {
					return "register";
				}
				
				if (name == "" || password == "") {
					model.addAttribute("errorInfoRegister", "用户名或者密码不能为空");
					return "register";
				}
				
				//user-register-test
				User temp = userService.findByName(name);
				
				//user-register-name-repeated
				if (temp != null) {
					model.addAttribute("errorInfoRegister", "用户名已经被登录了");
					return "register";
				}
				
				//user-register
				int id = userService.insert(name, password);
				
				//user-register-fail
				if (id < 0) {
					model.addAttribute("errorInfoRegister", "操作失败");
					return "register";
				}
				
				//user-register-success
				setCookie(res, name, id);
				return "redirect:/movies";
			} else {
				return "redirect:/movies";
			}
		}
		
		
		/*
		 * logout
		 * */
		@RequestMapping({"/user/logout"})
		public String logout(HttpServletRequest req, HttpServletResponse res) {
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (int i = 0, l = cookies.length; i < l; i++) {
					Cookie cookie = new Cookie(cookies[i].getName(), cookies[i].getValue());
					cookie.setMaxAge(0);
					cookie.setPath("/");
					res.addCookie(cookie);
				}
			}
			return "redirect:/movies";
		}
		
		/*
		 *user-info
		 */
		@RequestMapping({"/user/info"})
		public String userInfo(Model model, HttpServletRequest req, HttpServletResponse res) {
			if (req.getCookies() != null) {
				Cookie cookies[] = req.getCookies();
				int id = 0;
				for (int i = 0, l = cookies.length; i < l; i++) {
					if (cookies[i].getName().equals("user_id")) {
						id = Integer.parseInt(cookies[i].getValue());
						break;
					}
				}
				
				if (id == 0) {
					return logout(req, res);
				}
				
				User user = userService.findById(id);
				if (user == null) {
					return logout(req, res);
				}
				
				model.addAttribute("user", user);
				return "user-info";
			} else {
				return "redirect:/movies";
			}
		}
		
		/*
		 * edit name
		 * */
		@RequestMapping(value="/user/editName", method=RequestMethod.POST)
		public @ResponseBody Map<String, String> editName(HttpServletRequest req, HttpServletResponse res) {
			Cookie cookies[] = req.getCookies();
			int id = 0;
			for (int i = 0, l = cookies.length; i < l; i++) {
				if (cookies[i].getName().equals("user_id")) {
					id = Integer.parseInt(cookies[i].getValue());
					break;
				}
			}
			String info = "用户名不能为空.", msg = "false";
			String name = req.getParameter("name");
			Map<String, String> temp = new HashMap<String, String>();
			
			if (name != null && name != "") {
				User user = userService.findByName(name);
				//用户名可用
				if (user == null) {
					if (userService.updateName(id, name)) {
						msg = "true";
						info = name;
						Cookie cookie = new Cookie("user_name", name);
						cookie.setMaxAge(3600);
						cookie.setPath("/");
						res.addCookie(cookie);
					} else {
						info = "用户名更新失败";
					}
				} else {
					info = "该用户名已被占用.";
				}
				
			}
			temp.put("info", info);
			temp.put("msg", msg);
			return temp;
		}
		
		/*
		 * edit name
		 * */
		@RequestMapping(value="/user/editPassword", method=RequestMethod.POST)
		public @ResponseBody Map<String, String> editPassword(HttpServletRequest req, HttpServletResponse res) {
			Cookie cookies[] = req.getCookies();
			int id = 0;
			for (int i = 0, l = cookies.length; i < l; i++) {
				if (cookies[i].getName().equals("user_id")) {
					id = Integer.parseInt(cookies[i].getValue());
					break;
				}
			}
			String info = "密码不能为空", msg = "false";
			String password = req.getParameter("password");
			Map<String, String> temp = new HashMap<String, String>();
			
			System.out.println(password);
			System.out.println(id);
			if (password != null && password != "" && id != 0) {
				System.out.println("ok");
				if(userService.updatePassword(id, password)) {
					msg = "true";
					info = "修改密码成功";
				} else {
					info = "修改密码失败";
				}
			}
			temp.put("info", info);
			temp.put("msg", msg);
			return temp;
		}
		
		private void setCookie(HttpServletResponse res, String name, int id) {
			int expiry = 3600;
			Cookie cookie = new Cookie("user_name", name);
			cookie.setMaxAge(expiry); //1h
			cookie.setPath("/");
			res.addCookie(cookie);
			cookie = new Cookie("user_id", String.valueOf(id));
			cookie.setMaxAge(expiry);
			cookie.setPath("/");
			res.addCookie(cookie);
		}
}
