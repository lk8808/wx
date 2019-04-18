package com.tr.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tr.wx.service.IMsgService;

@RestController
@RequestMapping("/msg")
public class MsgController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IMsgService msgService;

	@PostMapping("/handler")
	public String handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		request.setCharacterEncoding("UTF-8"); 
		// 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		response.setCharacterEncoding("UTF-8");
	
		return msgService.handlerMsg(request, response);
	}
	
	/**
	 * 验证企业微信配置URL有效性
	 * @return
	 */
	@GetMapping("/handler")
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		request.setCharacterEncoding("UTF-8"); 
		// 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		response.setCharacterEncoding("UTF-8");
		
		return msgService.test(request, response);
	}
	
}
