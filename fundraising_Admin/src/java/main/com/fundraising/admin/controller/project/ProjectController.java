package com.fundraising.admin.controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fundraising.admin.controller.commonn.BaseController;
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
public class ProjectController extends BaseController {

	@Autowired
	private FundProjectService fundProjectService;

	@ModelAttribute
	private void imagePath(Model model, HttpServletRequest request) {
		model.addAttribute("imagePath", ImageUtil.getBasePath(request) + ImageConstant.FUND_PROJECT_DIRECTORY);
	}

	@GetMapping(value = "/projectManage")
	private String projectSetup(Model model, @RequestParam(name = "id", required = false) Long id) {
		FundraisingProjectDTO dto = new FundraisingProjectDTO();
		if (CommonUtil.isValidLong(id)) {
			dto = fundProjectService.getProjectById(id);
		}
		model.addAttribute("projectDTO", dto);
		commonLoad(model);
		commonModel(model, AdminPages.FUND_PROJECT.getCode(), AdminPages.FUND_PROJECT.getDesc(),
				AdminPages.FUND_PROJECT_MANAGE.getCode(), AdminPages.FUND_PROJECT_MANAGE.getDesc(), 0);
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
		commonLoad(model);
		commonModel(model, AdminPages.FUND_PROJECT.getCode(), AdminPages.FUND_PROJECT.getDesc(),
				AdminPages.FUND_PROJECT_MANAGE.getCode(), AdminPages.FUND_PROJECT_MANAGE.getDesc(), 0);
		return "project-manage";
	}

	@GetMapping(value = "/projectSearch")
	private String getProjectSearch(Model model, HttpServletRequest request) {

		FundraisingProjectDTO criteria = new FundraisingProjectDTO();
		criteria.setPageNo(1);
		List<FundraisingProjectDTO> dtoList = fundProjectService.searchProjectByCriteria(criteria);

		// for pagination
		Integer allRowCount = fundProjectService.getAllRowCount(criteria);
		int pageCount = (int) Math.ceil((allRowCount * 1.0) / CommonConstant.ROW_PER_PAGE);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", 1);
		model.addAttribute("rowPerPage", CommonConstant.ROW_PER_PAGE);

		model.addAttribute("projectList", dtoList);
		model.addAttribute("projectDTO", new FundraisingProjectDTO());
		commonLoad(model);
		commonModel(model, AdminPages.FUND_PROJECT.getCode(), AdminPages.FUND_PROJECT.getDesc(),
				AdminPages.FUND_PROJECT_SEARCH.getCode(), AdminPages.FUND_PROJECT_SEARCH.getDesc(), allRowCount);
		return "project-search";
	}

	@PostMapping(value = "/projectSearch")
	private String postProjectSearch(Model model, HttpServletRequest request,
			@ModelAttribute("projectDTO") FundraisingProjectDTO projectDTO) {

		List<FundraisingProjectDTO> dtoList = fundProjectService.searchProjectByCriteria(projectDTO);

		// for pagination
		Integer allRowCount = fundProjectService.getAllRowCount(projectDTO);
		int pageCount = (int) Math.ceil((allRowCount * 1.0) / CommonConstant.ROW_PER_PAGE);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", projectDTO.getPageNo());
		model.addAttribute("rowPerPage", CommonConstant.ROW_PER_PAGE);

		model.addAttribute("projectList", dtoList);
		model.addAttribute("projectDTO", projectDTO);
		commonLoad(model);
		commonModel(model, AdminPages.FUND_PROJECT.getCode(), AdminPages.FUND_PROJECT.getDesc(),
				AdminPages.FUND_PROJECT_SEARCH.getCode(), AdminPages.FUND_PROJECT_SEARCH.getDesc(), allRowCount);
		return "project-search";
	}

	public void commonLoad(Model model) {
		model.addAttribute("porjectStatusList", ProjectStatus.values());
	}

}
