package com.tr.wx.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http请求工具类
 */
public class HttpUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	private HttpUtil() {}
	
	/**
     * 发送http get请求
     * @param	url	请求地址
     * @param	reqData	请求数据
     * @param	charSet	请求字符集编码
     * 
     * 
     */
    public static String sendGet(String url, String charSet, Map<String, String> head) {
    	String respData = "";
        InputStream in = null; 
        
        try {
        	logger.info("发送GET请求");
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", charSet);
            //设置传入请求属性
            if (head != null) {
            	for (String key : head.keySet()) {
            		conn.setRequestProperty(key, head.get(key));
            	}
            }
            // 建立实际的连接
            conn.connect();
            //获取报文体内容
            in = conn.getInputStream();  
            //声明字节缓冲流
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();  
            //声明缓冲字节数组
            byte[] buffer = new byte[512];  
            int len = 0;
            while((len = in.read(buffer)) != -1){  
                bytesOut.write(buffer, 0, len); 
            }
            respData = bytesOut.toString();
            logger.info("接收响应报文：" + respData);
            
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return respData;
    }

    /**
     * 发送http post请求
     * @param	url	请求地址
     * @param	reqData	请求数据
     * @param	charSet	请求字符集编码
     * @throws Exception 
     * 
     */
    public static String sendPost(String url, String reqData, String charSet,  Map<String, String> head) { 
    	String respData = "";
        InputStream in = null; 
        OutputStream out = null;
        try {
            URL realUrl = new URL(url);
            logger.info("发送请求报文：" + reqData);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", charSet);
            //设置传入请求属性
            if (head != null) {
            	for (String key : head.keySet()) {
            		conn.setRequestProperty(key, head.get(key));
            	}
            }
            conn.setReadTimeout(1000000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            out.write(reqData.getBytes(charSet));
            //获取报文体内容
            in = conn.getInputStream();  
            //声明字节缓冲流
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();  
            //声明缓冲字节数组
            byte[] buffer = new byte[512];  
            int len = 0;
            while((len = in.read(buffer)) != -1){  
                bytesOut.write(buffer, 0, len); 
            }
            respData = bytesOut.toString(charSet); 
            logger.info("接收响应报文：" + respData);
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！");
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return respData;
    }     
    

}
