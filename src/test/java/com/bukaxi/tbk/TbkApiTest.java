package com.bukaxi.tbk;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bukaxi.tbk.constant.Constants;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.taobao.api.response.TbkItemGetResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class TbkApiTest {

	@Test
	public void test() throws ApiException {
//		TaobaoClient client = new DefaultTaobaoClient(
//				"http://gw.api.tbsandbox.com/router/rest?sign=18EBA71FF31B1795901C2F59347D02CF&timestamp=2017-07-21+11%3A58%3A50&v=2.0&app_key=1012129701&method=taobao.tbk.item.get&partner_id=top-apitools&format=json&cat=16%2C18&q=%E5%A5%B3%E8%A3%85&force_sensitive_param_fuzzy=true&fields=num_iid%2Ctitle%2Cpict_url%2Csmall_images%2Creserve_price%2Czk_final_price%2Cuser_type%2Cprovcity%2Citem_url%2Cseller_id%2Cvolume%2Cnick",
//				"1012129701", "secret");
//		TbkItemGetRequest req = new TbkItemGetRequest();
//		req.setFields(
//				"num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
//		req.setQ("女裝");
//		req.setCat("16,18");
//		TbkItemGetResponse res = client.execute(req);
//		System.out.println(res.getBody());
		
		TaobaoClient client = new DefaultTaobaoClient(
                " http://gw.api.taobao.com/router/rest", "24552246",
                "5d2bfed3f18cd722142b8fd0a90d6e45");
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields(
                "num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("java");
        req.setPageSize(10L);
        TbkItemGetResponse response = client.execute(req);
        List<NTbkItem> list = response.getResults();
        list.forEach( l -> {
        	System.out.println(l.getClickUrl());
        });
        System.out.println(response.getBody());
        Long total = response.getTotalResults();
        System.out.println(total);
        
        
        
        

	}
	
	@Test
	public void test2() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", Constants.APP_KEY,
				Constants.SECRET);
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		req.setAdzoneId(Long.valueOf(Constants.ADZONID));
		req.setPlatform(1L);
//		req.setCat("16,18");
//		req.setPageSize(5L);
		req.setQ("女装");
		req.setPageNo(1L);
		TbkDgItemCouponGetResponse rsp = null;
		rsp = client.execute(req);
		List<TbkCoupon> l = rsp.getResults();
		for(int i=0;i<l.size();i++){
			System.out.println(i + "," + l.get(i).getNick());
		}
		System.out.println("test2:" + l.size() + ",total:" + rsp.getTotalResults());
		
	}

}
