package com.fundraising.admin.controller.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fundraising.service.project.FundProjectService;
import com.fundraising.util.FundraisingProjectDTO;
import com.fundraising.util.UserDTO;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;
import com.fundraising.util.common.ImageConstant;
import com.fundraising.util.common.ImageUtil;
import com.fundraising.util.enumeration.AdminPages;
import com.fundraising.util.enumeration.ProjectStatus;

@Controller
public class ProjectController {

	@Autowired
	private FundProjectService fundProjectService;

	@ModelAttribute
	private void imagePath(Model model, HttpServletRequest request) {
		model.addAttribute("imagePath", ImageUtil.getBasePath(request) + ImageConstant.FUND_PROJECT_DIRECTORY);
	}

	@GetMapping(value = "/projectManage")
	private String projectSetup(Model model) {
		model.addAttribute("projectDTO", new FundraisingProjectDTO());
		model.addAttribute("porjectStatusList", ProjectStatus.values());
		commonModel(model, AdminPages.FUND_PROJECT_MANAGE.getDesc(), AdminPages.FUND_PROJECT_MANAGE.getCode(),
				AdminPages.FUND_PROJECT_MANAGE.getDesc(), 0);
		return "project-manage";
	}

	@PostMapping(value = "/projectManage")
	private String projectManage(@ModelAttribute("projectDTO") FundraisingProjectDTO projectDTO, HttpServletRequest request,
			Model model) {
		UserDTO loggedInUser = (UserDTO) request.getSession().getAttribute(CommonConstant.LOGIN_USER_SESSION_KEY);
		FundraisingProjectDTO dto = new FundraisingProjectDTO();
		if (CommonUtil.isValidLong(projectDTO.getId())) {
			Long projectId = fundProjectService.manageProject(projectDTO, loggedInUser);
			if (CommonUtil.isValidLong(projectId)) {
				dto = fundProjectService.getProjectById(projectId);
				model.addAttribute("message", "Update Fund Project Success.");
			} else {
				model.addAttribute("errorMsg", "Update Fund Project Fail.");
			}
		} else {
			Long projectId = fundProjectService.manageProject(projectDTO, loggedInUser);
			if (CommonUtil.isValidLong(projectId)) {
				dto = fundProjectService.getProjectById(projectId);
				model.addAttribute("message", "Create Fund Project Success.");
			} else {
				model.addAttribute("errorMsg", "Create Fund Project Fail.");
			}
		}
		model.addAttribute("projectDTO", dto);
		model.addAttribute("porjectStatusList", ProjectStatus.values());
		commonModel(model, AdminPages.FUND_PROJECT_MANAGE.getDesc(), AdminPages.FUND_PROJECT_MANAGE.getCode(),
				AdminPages.FUND_PROJECT_MANAGE.getDesc(), 0);
		return "project-manage";
	}

	public void commonModel(Model model, String pageTitle, String subMenu, String subMenuDesc, Integer totalRecord) {
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute(CommonConstant.ACTIVE_MENU, pageTitle);
		model.addAttribute(CommonConstant.ACTIVE_MENU_DESC, AdminPages.FUND_PROJECT.getDesc());
		model.addAttribute(CommonConstant.ACTIVE_SUB_MENU, subMenu);
		model.addAttribute(CommonConstant.ACTIVE_SUB_MENU_DESC, subMenuDesc);
		model.addAttribute("activeMenu", AdminPages.FUND_PROJECT.getCode());
		if (totalRecord > 1) {
			model.addAttribute("totalReocrd", "Total " + totalRecord + " records.");
		} else {
			model.addAttribute("totalReocrd", "Total " + totalRecord + " record.");
		}
	}

}
