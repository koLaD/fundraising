package com.fundraising.admin.controller.commonn;

import org.springframework.ui.Model;

import com.fundraising.util.common.CommonConstant;

public class BaseController {

	public static void commonModel(Model model, String menuCode, String menuDesc, String subMenuCode, String subMenuDesc,
			Integer totalRecord) {
		model.addAttribute(CommonConstant.ACTIVE_MENU_CODE, menuCode);
		model.addAttribute(CommonConstant.ACTIVE_MENU_DESC, menuDesc);
		model.addAttribute(CommonConstant.ACTIVE_SUB_MENU_CODE, subMenuCode);
		model.addAttribute(CommonConstant.ACTIVE_SUB_MENU_DESC, subMenuDesc);
		model.addAttribute(CommonConstant.PAGE_TITLE, subMenuDesc);
		if (totalRecord > 1) {
			model.addAttribute(CommonConstant.TOTAL_RECORD, "Total " + totalRecord + " records.");
		} else {
			model.addAttribute(CommonConstant.TOTAL_RECORD, "Total " + totalRecord + " record.");
		}
	}

}
