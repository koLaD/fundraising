package com.fundraising.util.enumeration;

public enum AdminPages {
	FUND_PROJECT("FUND_PROJECT", "Fund Project"), FUND_PROJECT_MANAGE("FUND_PROJECT_MANAGE",
			"Fund Project Manage"), FUND_PROJECT_SEARCH("FUND_PROJECT_SEARCH", "Fund Project Search"), FUND_RAISER("FUND_RAISER",
					"Fundraiser"), FUND_RAISER_MANAGE("FUND_RAISER_MANAGE",
							"Fundraiser Manage"), FUND_RAISER_SEARCH("FUND_RAISER_SEARCH", "Fundraiser Search");

	private String code;
	private String desc;

	AdminPages(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static String getDescByCode(String code) {
		for (AdminPages dt : AdminPages.values()) {
			if (dt.getCode().equals(code)) {
				return dt.getDesc();
			}
		}
		return "";
	}

}
