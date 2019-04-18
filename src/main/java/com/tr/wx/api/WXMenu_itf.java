package com.tr.wx.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tr.wx.utils.AccessTokenUtil;
import com.tr.wx.utils.HttpUtil;
import com.tr.wx.utils.JsonUtil;

public class WXMenu_itf {
	
	private static Logger logger = LoggerFactory.getLogger(WXMenu_itf.class);

	/**
	 * 创建菜单
	 * @return
	 */
	public static Map<String, Object> createMenu(String params) {
		Map<String, Object> retMap = null;
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + AccessTokenUtil.getAccessToken();
		try {
			String respData = HttpUtil.sendPost(url, params, "utf-8", null);
			retMap = JsonUtil.JsonToMap(respData);
		} catch (Exception e) {
			logger.error("菜单创建失败");
			e.printStackTrace();
		}
		return retMap;
	}
	
	/**
	 * 删除菜单
	 * @return
	 */
	public static Map<String, Object> delMenu() {
		Map<String, Object> retMap = null;
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + AccessTokenUtil.getAccessToken();
		try {
			String respData = HttpUtil.sendGet(url, "utf-8", null);
			retMap = JsonUtil.JsonToMap(respData);
		} catch (Exception e) {
			logger.error("菜单删除失败");
			e.printStackTrace();
		}
		return retMap;
	}
}
