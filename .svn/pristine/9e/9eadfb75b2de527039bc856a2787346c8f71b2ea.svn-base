package com.tr.wx.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tr.wx.constant.WXConsts;
import com.tr.wx.utils.HttpUtil;

public class AccessToken_itf {
	
	private static Logger logger = LoggerFactory.getLogger(AccessToken_itf.class);

	/**
	 * 获取access_token
	 * @return
	 */
	public static String getAccessToken() {
		String access_token;
		try {
			//获取access_token的地址
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + 
						  WXConsts.appID + "&secret=" + WXConsts.appsecret;
			String respData = HttpUtil.sendGet(url, "utf-8", null);
			JsonObject jsonObj = new JsonParser().parse(respData).getAsJsonObject();
			access_token = jsonObj.get("access_token").getAsString();
			return access_token;
		} catch (Exception e) {
			logger.error("access_token获取失败");
			e.printStackTrace();
		}
		return "";
	}
}
