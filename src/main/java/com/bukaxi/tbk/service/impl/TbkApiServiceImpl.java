package com.bukaxi.tbk.service.impl;

import org.springframework.stereotype.Service;

import com.bukaxi.tbk.constant.Constants;
import com.bukaxi.tbk.domain.CouponInfo;
import com.bukaxi.tbk.domain.HotInfo;
import com.bukaxi.tbk.domain.IndexInfo;
import com.bukaxi.tbk.service.TbkApiService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkUatmFavoritesItemGetRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkUatmFavoritesItemGetResponse;

@Service
public class TbkApiServiceImpl implements TbkApiService {

	@Override
	public TbkItemGetResponse getTbkItems(IndexInfo index) {
		TaobaoClient client = new DefaultTaobaoClient(" http://gw.api.taobao.com/router/rest", Constants.APP_KEY,
				Constants.SECRET);
		TbkItemGetRequest req = new TbkItemGetRequest();
		req.setFields(
				"num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		if (index.getSearchMsg() == null || "".equals(index.getSearchMsg())) {
			index.setSearchMsg("零食");
		}
		req.setQ(index.getSearchMsg());
		req.setPageSize(Long.valueOf(index.getPageSize()));
		// req.setPageSize(20L);
		// req.setPageNo(13l);
		req.setPageNo(Long.valueOf(index.getPageNum()));
		TbkItemGetResponse response = null;
		try {
			response = client.execute(req);
			System.out.println(response.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public TbkDgItemCouponGetResponse geTbkDgItemCoupons(CouponInfo coupon) {
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", Constants.APP_KEY,
				Constants.SECRET);
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		if (coupon.getSearchMsg() == null || "".equals(coupon.getSearchMsg())) {
			coupon.setSearchMsg("女装");
		}
		req.setAdzoneId(121044559L);
		req.setPlatform(1L);
		// req.setCat("16,18");
		req.setPageSize(Long.valueOf(coupon.getPageSize()));
		req.setQ(coupon.getSearchMsg());
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
	public JuItemsSearchResponse getJuItemsSearchRes(HotInfo hot) {
		TaobaoClient client = new DefaultTaobaoClient(Constants.URL, Constants.APP_KEY, Constants.SECRET);
		JuItemsSearchRequest req = new JuItemsSearchRequest();
		TopItemQuery obj1 = new TopItemQuery();
		obj1.setCurrentPage(Long.valueOf(hot.getPageNum()));
		obj1.setPageSize(Long.valueOf(hot.getPageSize()));
		obj1.setPid(Constants.PID);
		obj1.setPostage(true);
		obj1.setStatus(2L);
		obj1.setWord(hot.getSearchMsg());
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

	@Override
	public TbkUatmFavoritesItemGetResponse getFavorites() {
		TaobaoClient client = new DefaultTaobaoClient(Constants.URL, Constants.APP_KEY, Constants.SECRET);
		TbkUatmFavoritesItemGetRequest req = new TbkUatmFavoritesItemGetRequest();
		req.setPlatform(1L);
		req.setPageSize(20L);
		req.setAdzoneId(Long.valueOf(Constants.ADZONID));
		req.setUnid("3456");
		req.setFavoritesId(10010L);
		req.setPageNo(2L);
		req.setFields(
				"num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,status,type");
		TbkUatmFavoritesItemGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());

		return rsp;
	}

}
