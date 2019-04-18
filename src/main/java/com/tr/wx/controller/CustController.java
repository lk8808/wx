package com.tr.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tr.wx.entity.RespData;
import com.tr.wx.service.ICustService;

@RestController
@RequestMapping("/cust")
public class CustController {
	
	@Autowired
	private ICustService custService;
	
	@RequestMapping("/getSession")
	public RespData getSession() {
		return custService.getSession();
	}

	@RequestMapping("/index")
	public RespData index(@RequestParam String code) {
		
		return custService.login(code);
	}
}
