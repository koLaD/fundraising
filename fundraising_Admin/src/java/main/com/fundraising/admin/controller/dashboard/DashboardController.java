package com.fundraising.admin.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	// private final Logger logger = LogManager.getLogger(this.getClass());

	@GetMapping(value = "/dashboard")
	public String getDashboard(Model model) {
		return "dashboard";
	}
	//
	// @RequestMapping(value = "/dashboard.html", method = RequestMethod.POST)
	// public String searchQuestionListFormPOST(@ModelAttribute("dashboard")
	// DashboardDTO dashboard, Model model) {
	//
	// dashboard.setNewCustomer(dashboardService.getTotalCustomerRegisterCount(dashboard));
	//
	// dashboard.setTotalCustomer(dashboardService.getAllCustomer());
	//
	// dashboard.setTotalOrder(dashboardService.getTotalOrderCount(dashboard));
	//
	// List<OrderDTO> topItemList = orderService.getTopItems(dashboard);
	//
	// List<OrderDTO> topSubCatList =
	// orderService.getTopSubCategories(dashboard);
	//
	// BigDecimal totalAmount = dashboardService.getTotalOrderAmount(dashboard);
	// if (totalAmount == null) {
	// totalAmount = new BigDecimal("0");
	// }
	// dashboard.setTotalAmountText(
	// CommonUtil.formatBigDecimalAsCurrency(totalAmount,
	// CommonConstant.CURRENCY_SIGN_KS));
	// model.addAttribute("topItemList", topItemList);
	// model.addAttribute("topSubCatList", topSubCatList);
	// model.addAttribute("dashboard", dashboard);
	// return "dashboard";
	// }
	//
	// @PostMapping("/getLineChartList")
	// public @ResponseBody String getLineChartList(@RequestParam("monthId")
	// String monthId) {
	// logger.info("getLineChartList start >> monthId >> "+monthId);
	// ObjectMapper mapper = new ObjectMapper();
	// String json = "";
	// Integer month = Integer.valueOf(monthId);
	// List<LineChartDTO> resultList = new ArrayList<>();
	// DashboardDTO dto = new DashboardDTO();
	// if (month != null && month.intValue() > 0) {
	// dto.setSelectedMonth(month.intValue());
	// }
	// resultList = orderService.getOrderCountForLineChart(dto);
	// logger.info("getLineChartList >> resultList >> "+resultList.size());
	//
	// try {
	// json = mapper.writeValueAsString(resultList);
	// } catch (JsonProcessingException e) {
	// logger.error("getLineChartList : Error :" + e.getMessage());
	// }
	// return json;
	//
	// }
}
