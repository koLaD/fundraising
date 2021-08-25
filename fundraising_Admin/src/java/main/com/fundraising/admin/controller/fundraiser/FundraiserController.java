package com.fundraising.admin.controller.fundraiser;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fundraising.admin.controller.commonn.BaseController;
import com.fundraising.service.fundraiser.FundraiserService;
import com.fundraising.service.project.FundProjectService;
import com.fundraising.util.FundraiserDTO;
import com.fundraising.util.UserDTO;
import com.fundraising.util.common.CommonConstant;
import com.fundraising.util.common.CommonUtil;
import com.fundraising.util.enumeration.AdminPages;

@Controller
public class FundraiserController extends BaseController {

	@Autowired
	private FundraiserService fundraiserService;

	@Autowired
	private FundProjectService projectService;

	@GetMapping(value = "/fundraiserManage")
	private String getFundraiserManage(Model model, @RequestParam(name = "id", required = false) Long id) {
		FundraiserDTO dto = new FundraiserDTO();
		if (CommonUtil.isValidLong(id)) {
			dto = fundraiserService.getFundraiserById(id);
		}
		model.addAttribute("fundraiserDTO", dto);
		commonLoadData(model);
		commonModel(model, AdminPages.FUND_RAISER.getCode(), AdminPages.FUND_RAISER.getDesc(),
				AdminPages.FUND_RAISER_MANAGE.getCode(), AdminPages.FUND_RAISER_MANAGE.getDesc(), 0);
		return "fundraiser-manage";
	}

	@PostMapping(value = "/fundraiserManage")
	private String postFundraiserManage(Model model, @ModelAttribute("fundraiserDTO") FundraiserDTO fundraiserDTO,
			HttpServletRequest request) {
		UserDTO loggedInUser = (UserDTO) request.getSession().getAttribute(CommonConstant.LOGIN_USER_SESSION_KEY);
		FundraiserDTO dto = new FundraiserDTO();
		if (CommonUtil.isValidLong(fundraiserDTO.getId())) {
			Long fundraisertId = fundraiserService.manageFundraiser(fundraiserDTO, loggedInUser);
			if (CommonUtil.isValidLong(fundraisertId)) {
				dto = fundraiserService.getFundraiserById(fundraisertId);
				model.addAttribute("message", "Update Fundraiser Success.");
			} else {
				model.addAttribute("errorMsg", "Update Fundraiser Fail.");
			}
		} else {
			Long fundraisertId = fundraiserService.manageFundraiser(fundraiserDTO, loggedInUser);
			if (CommonUtil.isValidLong(fundraisertId)) {
				dto = fundraiserService.getFundraiserById(fundraisertId);
				model.addAttribute("message", "Create Fundraiser Success.");
			} else {
				model.addAttribute("errorMsg", "Create Fundraiser Fail.");
			}
		}
		model.addAttribute("fundraiserDTO", dto);
		commonLoadData(model);
		commonModel(model, AdminPages.FUND_RAISER.getCode(), AdminPages.FUND_RAISER.getDesc(),
				AdminPages.FUND_RAISER_MANAGE.getCode(), AdminPages.FUND_RAISER_MANAGE.getDesc(), 0);
		return "fundraiser-manage";
	}

	private void commonLoadData(Model model) {
		model.addAttribute("projectList", projectService.getAllProject());
	}

}
