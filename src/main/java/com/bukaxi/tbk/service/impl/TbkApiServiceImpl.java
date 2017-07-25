package com.bukaxi.tbk.service.impl;

import org.springframework.stereotype.Service;

import com.bukaxi.tbk.constant.Constants;
import com.bukaxi.tbk.domain.CouponInfo;
import com.bukaxi.tbk.service.TbkApiService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkItemGetResponse;

@Service
public class TbkApiServiceImpl implements TbkApiService {

	@Override
	public TbkItemGetResponse getTbkItems(String type) {
		TaobaoClient client = new DefaultTaobaoClient(" http://gw.api.taobao.com/router/rest", Constants.APP_KEY,
				Constants.SECRET);
		TbkItemGetRequest req = new TbkItemGetRequest();
		req.setFields(
				"num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setQ(type);
		req.setPageSize(20L);
		TbkItemGetResponse response = null;
		try {
			response = client.execute(req);
			System.out.println(response.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		// List<NTbkItem> list = response.getResults();
		// list.forEach( l -> {
		// System.out.println(l.getClickUrl());
		// });

		// Long total = response.getTotalResults();
		// System.out.println(total);

		return response;
	}

	@Override
	public TbkDgItemCouponGetResponse geTbkDgItemCoupons(CouponInfo coupon) {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", Constants.APP_KEY,
				Constants.SECRET);
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(121044559L);
		req.setPlatform(1L);
		req.setCat("16,18");
		req.setPageSize(Long.valueOf(coupon.getPageSize()));
		req.setQ("女装");
		req.setPageNo(Long.valueOf(coupon.getPageNum()));
		TbkDgItemCouponGetResponse rsp = null;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}

		return rsp;
	}

	@Override
	public JuItemsSearchResponse getJuItemsSearchRes() {
		TaobaoClient client = new DefaultTaobaoClient(Constants.URL, Constants.APP_KEY, Constants.SECRET);
		JuItemsSearchRequest req = new JuItemsSearchRequest();
		TopItemQuery obj1 = new TopItemQuery();
		obj1.setCurrentPage(1L);
		obj1.setPageSize(20L);
		obj1.setPid(Constants.PID);
		obj1.setPostage(true);
		obj1.setStatus(2L);
		// obj1.setTaobaoCategoryId(1000L);
		// obj1.setWord("test");
		req.setParamTopItemQuery(obj1);
		JuItemsSearchResponse rsp = null;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}

		return rsp;
	}

}
