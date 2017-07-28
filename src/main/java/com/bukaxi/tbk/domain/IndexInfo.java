package com.bukaxi.tbk.domain;

public class IndexInfo extends PageInfo<IndexInfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7848586053239962529L;
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
