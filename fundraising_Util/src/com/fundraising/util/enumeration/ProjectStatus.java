package com.fundraising.util.enumeration;

public enum ProjectStatus {

	OPEN("OPEN", "Open"), CLOSE("CLOSE", "Close");

	private String code;
	private String description;

	ProjectStatus(String code, String desc) {
		this.code = code;
		this.description = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static String getDescByCode(String code) {

		for (ProjectStatus cs : values()) {
			if (cs.getCode().equals(code)) {
				return cs.getDescription();
			}
		}
		return "";
	}

}
