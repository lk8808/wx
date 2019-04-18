package com.tr.wx.service.impl;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.wx.entity.RespData;
import com.tr.wx.entity.Rtsts;
import com.tr.wx.service.ICustService;

@Service
public class CustServiceImpl implements ICustService {
	
Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired  
	private HttpSession session; 

	@Override
	public RespData getSession() {
		RespData respData = new RespData(new Rtsts("000000", ""));
		Enumeration<?> enumeration = session.getAttributeNames();
		respData.setRtdata("sessionId", session.getId());
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement().toString();
			Object val = session.getAttribute(key);
			respData.setRtdata(key, val);
		}
		return respData;
	}

	@Override
	public RespData login(String code) {
		
		return null;
	}

}
