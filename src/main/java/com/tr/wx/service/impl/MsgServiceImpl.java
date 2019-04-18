package com.tr.wx.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tr.wx.aes.AesException;
import com.tr.wx.aes.SHA1;
import com.tr.wx.aes.WXBizMsgCrypt;
import com.tr.wx.bean.TextMessage;
import com.tr.wx.constant.WXConsts;
import com.tr.wx.service.IMsgService;
import com.tr.wx.utils.WXPropsUtil;
import com.tr.wx.utils.XmlParser;

@Service
public class MsgServiceImpl implements IMsgService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 消息处理
	 */
	public String handlerMsg(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("------------微信消息开始处理-------------");
		String respXml = "";
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String msg_signature = request.getParameter("msg_signature");
		
		try {
			String postData = XmlParser.getXml(request);
			logger.info(postData);
			//解密
			//WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(WXConsts.token, WXConsts.EncodingAESKey, WXConsts.appID);
			//postData = wxcpt.decryptMsg(msg_signature, timestamp, nonce, postData);
			Map<String, String> reqMap = XmlParser.parseXml(postData);
			respXml = handlerMsg(reqMap);
			//加密
			//respXml = wxcpt.encryptMsg(respXml, timestamp, nonce);
			logger.info(respXml);
			logger.info("------------微信消息处理完成-------------");
			
		} catch (Exception e) {
			logger.error("------------微信消息处理失败-------------");
			e.printStackTrace();
			return null;
		}
		
		return respXml;
	}
	
	private String handlerMsg(Map<String, String> reqMap) {
		String respXml = "";
		String fromUserName = reqMap.get("FromUserName");
		String toUserName = reqMap.get("ToUserName");
		String msgType = reqMap.get("MsgType");
		
		// 默认回复文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WXConsts.MSG_TYPE_TEXT);
		
		switch (msgType) {
			case WXConsts.MSG_TYPE_TEXT:
				textMessage.setContent("文本消息");	
				break;
			case WXConsts.MSG_TYPE_IMAGE:
				textMessage.setContent("图片消息");	
				break;
			case WXConsts.MSG_TYPE_EVENT:
				textMessage.setContent("事件消息");
				break;
			default:
				break;
		}
		respXml = XmlParser.textMessageToXml(textMessage);
		
		return respXml;
	}

	/**
	 * URL验证
	 */
	public String test(HttpServletRequest request, HttpServletResponse response) {

		String sEchoStr = "";
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		WXPropsUtil.setProperty("signature", signature);
		WXPropsUtil.setProperty("timestamp", timestamp);
		WXPropsUtil.setProperty("nonce", nonce);
		WXPropsUtil.setProperty("echostr", echostr);
		
		try {
			sEchoStr = SHA1.getSHA1(WXConsts.token, timestamp, nonce);
			if (sEchoStr != null && sEchoStr.equals(signature)) {
				return echostr;
			}
		} catch (AesException e) {
			e.printStackTrace();
		}

		return "";
	}

}
