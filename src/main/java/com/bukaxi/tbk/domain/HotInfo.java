package com.bukaxi.tbk.domain;

public class HotInfo extends PageInfo<HotInfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 654838287353507956L;
	private String pageInfos;
	// 查询条件
	private String searchMsg;

	public String getPageInfos() {
		return pageInfos;
	}

	public void setPageInfos(String pageInfos) {
		this.pageInfos = pageInfos;
	}

	public String getSearchMsg() {
		return searchMsg;
	}

	public void setSearchMsg(String searchMsg) {
		this.searchMsg = searchMsg;
	}

}
