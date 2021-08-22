package com.fundraising.admin.controller.user;
//package com.banbann.admin.controller.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import com.banbann.service.user.UserService;
//import com.banbann.util.UserDTO;
//import com.banbann.util.common.CommonImageConstant;
//
//@Controller
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//
//	@ModelAttribute("imagePath")
//	public String imagePath() {
//		return CommonImageConstant.IMAGE_PATH;
//	}
//
//	@GetMapping(value = "/userSetup")
//	public String userSetupGet(Model model) {
//		model.addAttribute("userDTO", new UserDTO());
//		return "userSetup";
//	}
//
//}
