package com.bukaxi.tbk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bukaxi.tbk.domain.CouponInfo;
import com.bukaxi.tbk.domain.HotInfo;
import com.bukaxi.tbk.domain.IndexInfo;
import com.bukaxi.tbk.service.TbkApiService;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.JuItemsSearchResponse.Items;
import com.taobao.api.response.JuItemsSearchResponse.PaginationResult;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.taobao.api.response.TbkItemGetResponse;

@Controller
public class TbkApiController {

	@Autowired
	private TbkApiService tbkApiService;

	@RequestMapping("/index")
	public String index(ModelMap map, IndexInfo index) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		TbkItemGetResponse response = tbkApiService.getTbkItems( index);
		List<NTbkItem> list = response.getResults();

		String pageInfos = response.getTotalResults() + "," + index.getPageNum();
		map.put("searchMsg", index.getSearchMsg());
		map.put("pageInfos", pageInfos);
		map.put("itmes", list);
		map.put("h_url", "index");
		
		return "index";
	}

//	@RequestMapping("/index")
//	public String item(@PathVariable("type") String type, ModelMap map, IndexInfo index) {
//		// 加入一个属性，用来在模板中读取
//		// map.addAttribute("host", "http://blog.didispace.com");
//		// return模板文件的名称，对应src/main/resources/templates/index.html
//		TbkItemGetResponse response = tbkApiService.getTbkItems(type, index);
//		List<NTbkItem> list = response.getResults();
//		// map.addAllAttributes(list);
//		String pageInfos = list.size() + "," + index.getPageNum();
//		map.put("searchMsg", index.getSearchMsg());
//		map.put("pageInfos", pageInfos);
//		map.put("itmes", list);
//		map.put("h_url", "item");
//		return "index";
//	}
	
	@RequestMapping("/")
	public String home(ModelMap map, CouponInfo coupon) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		TbkDgItemCouponGetResponse response = tbkApiService.geTbkDgItemCoupons(coupon);
		List<TbkCoupon> list = response.getResults();
		map.addAllAttributes(list);
		map.put("coupons", list);
		String pageInfos = response.getTotalResults() + "," + coupon.getPageNum();
		map.put("searchMsg", coupon.getSearchMsg());
		map.put("pageInfos", pageInfos);
		map.put("h_url", "coupon");
		
		
		//test map
				Map<String, Long> map2 = new HashMap<>();
				map2.put("大", 1000l);
				map2.put("大要", 1230l);
				map2.put("大要", 1230l);
				map2.put("sd要", 232l);
				map.put("map", map2);
				
				
		return "coupon";
	}

	@RequestMapping("/coupon")
	public String coupon(ModelMap map, CouponInfo coupon) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		TbkDgItemCouponGetResponse response = tbkApiService.geTbkDgItemCoupons(coupon);
		List<TbkCoupon> list = response.getResults();
		map.addAllAttributes(list);
		map.put("coupons", list);
		String pageInfos = response.getTotalResults() + "," + coupon.getPageNum();
		map.put("searchMsg", coupon.getSearchMsg());
		map.put("pageInfos", pageInfos);
		map.put("h_url", "coupon");
		return "coupon";
	}

	@RequestMapping("/hot")
	public String hot(ModelMap map, HotInfo hot) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		JuItemsSearchResponse response = tbkApiService.getJuItemsSearchRes(hot);
		PaginationResult list = response.getResult();
		List<Items> modelList = list.getModelList();
		map.put("hots", modelList);
		String pageInfos = response.getResult().getTotalPage() + "," + hot.getPageNum();
		map.put("searchMsg", hot.getSearchMsg());
		map.put("pageInfos", pageInfos);
		map.put("h_url", "hot");
		return "hot";
	}

}
