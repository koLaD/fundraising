package com.fundraising.admin.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fundraising.service.menu.MenuService;
import com.fundraising.service.user.UserService;
import com.fundraising.util.UserDTO;
import com.fundraising.util.common.CommonConstant;

@Controller
public class LoginController {

	@Autowired
	private UserService userServiceImpl;

	@Autowired
	private MenuService menuService;

	@GetMapping(value = "/logIn")
	private String logInGet(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "logIn";
	}

	@PostMapping(value = "/logIn")
	private String logInPost(@ModelAttribute("userDTO") UserDTO userDTO, HttpServletRequest request, Model model) {
		UserDTO loggedInUser = userServiceImpl.checkAuthentication(userDTO.getPhoneNo(), userDTO.getPassword());
		if (loggedInUser != null) {
			loggedInUser.setPassword("");
			request.getSession().setAttribute(CommonConstant.LOGIN_USER_SESSION_KEY, loggedInUser);
			model.addAttribute("userDTO", loggedInUser);
			request.getSession().setAttribute("menuList", menuService.getAllMenu());
			return "redirect:/dashboard.html";
		} else {
			userDTO.setPassword("");
			model.addAttribute("userDTO", new UserDTO());
			model.addAttribute("errorMsg", "please check Phone No or Password");
			return "logIn";
		}
	}

	@GetMapping(value = "/logOut")
	private String logOut(HttpServletRequest request, Model model) {
		request.getSession().setAttribute(CommonConstant.LOGIN_USER_SESSION_KEY, null);
		request.getSession().setAttribute("menuList", null);
		model.addAttribute("userDTO", new UserDTO());
		return "logIn";
	}
}
