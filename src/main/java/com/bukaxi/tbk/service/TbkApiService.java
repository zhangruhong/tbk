package com.bukaxi.tbk.service;

import com.bukaxi.tbk.domain.CouponInfo;
import com.bukaxi.tbk.domain.IndexInfo;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkItemGetResponse;

public interface TbkApiService {
	
	TbkItemGetResponse getTbkItems(IndexInfo index);
	
	//好券清单
	TbkDgItemCouponGetResponse geTbkDgItemCoupons(CouponInfo coupon);
	
	//聚划算
	JuItemsSearchResponse getJuItemsSearchRes();

}
