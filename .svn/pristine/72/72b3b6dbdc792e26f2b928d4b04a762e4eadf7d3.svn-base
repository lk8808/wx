package com.tr.wx.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.JsonObject;
import com.tr.wx.api.WXMenu_itf;
import com.tr.wx.bean.WXMenu;
import com.tr.wx.constant.WXConsts;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {

	@Test
	public void test1() {
		WXMenu menu = new WXMenu();
		//一级菜单 1
		Map<String, String> node1 = new HashMap<String, String>();
		node1.put("name", "业务办理");
		JsonObject obj1 = menu.addMenuLevel1(node1);
		//一级菜单 2
		Map<String, String> node2 = new HashMap<String, String>();
		node2.put("name", "金融动态");
		JsonObject obj2 = menu.addMenuLevel1(node2);
		//一级菜单 3
		Map<String, String> node3 = new HashMap<String, String>();
		node3.put("name", "微服务");
		JsonObject obj3 = menu.addMenuLevel1(node3);
		
		//二级菜单 1 - 1
		Map<String, String> node11 = new HashMap<String, String>();
		node11.put("type", "view");
		node11.put("name", "积分宝");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WXConsts.appID 
				+ "&redirect_uri=http://a2x6yd.natappfree.cc/base/index"
				+ "&response_type=code"
				+ "&scope=snsapi_base&state=0#wechat_redirect";
		node11.put("url", url);
		menu.addMenuLevel2(obj1, node11);
		
		//二级菜单 2 - 1
		Map<String, String> node21 = new HashMap<String, String>();
		node21.put("type", "view");
		node21.put("name", "业务介绍");
		node21.put("url", "http://www.soso.com/");
		menu.addMenuLevel2(obj2, node21);
		//二级菜单 2 - 2
		Map<String, String> node22 = new HashMap<String, String>();
		node22.put("type", "view");
		node22.put("name", "网点查询");
		node22.put("url", "http://www.soso.com/");
		menu.addMenuLevel2(obj2, node22);
		//二级菜单 2 - 3
		Map<String, String> node23 = new HashMap<String, String>();
		node23.put("type", "view");
		node23.put("name", "行内动态");
		node23.put("url", "http://www.soso.com/");
		menu.addMenuLevel2(obj2, node23);
		
		//二级菜单 3 - 1
		Map<String, String> node31 = new HashMap<String, String>();
		node31.put("type", "view");
		node31.put("name", "去智e购");
		node31.put("url", "http://www.soso.com/");
		menu.addMenuLevel2(obj3, node31);

		WXMenu_itf.delMenu();
		WXMenu_itf.createMenu(menu.getMenuStr());
	}
	
}
