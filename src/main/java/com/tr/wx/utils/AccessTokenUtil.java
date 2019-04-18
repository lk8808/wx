package com.tr.wx.utils;

import java.util.Date;

import com.tr.wx.api.AccessToken_itf;

public class AccessTokenUtil {

	private static String access_token = "";
	
	private static Date lastime = null;
	
	public static String getAccessToken() {
		loadAccessToken();
		return access_token;
	}
	
	private static void loadAccessToken() {
		if ("".equals(access_token) || isExpired()) {
			//获取access_token
			String str = AccessToken_itf.getAccessToken();
			//更新access_token并更新最后更新时间
			if ( str != null && !"".equals(str) ) {
				access_token = str;
				WXPropsUtil.setProperty("access_token", str);
				lastime = new Date();
			}
		}
	}
	
	/**
	 * 判断access_token是否过期，access_token有效时间为7200秒
	 * @return
	 */
	private static boolean isExpired() {
		if (lastime == null) {
			return true;
		}
		
		long t1 = lastime.getTime();
		long t2 = new Date().getTime();
		//比较当前的时间和最后一次获取access_token的时间
		if ( (int)((t2-t1)/1000) >= 7200 ) {
			return true;
		}
		
		return false;
	}
	
}
