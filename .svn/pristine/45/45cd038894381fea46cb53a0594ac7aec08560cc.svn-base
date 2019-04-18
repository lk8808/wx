package com.tr.wx.bean;

import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class WXMenu {
	
	private JsonObject menu;
	
	public WXMenu() {
		menu = new JsonObject();
	}
	
	/**
	 * 添加一级菜单
	 * @param params
	 * @return
	 */
	public JsonObject addMenuLevel1(Map<String, String> params) {
		JsonObject node = new JsonObject();
		if (params != null) {
			for (Entry<String, String> entry : params.entrySet()) {
				node.addProperty(entry.getKey(), entry.getValue());
			}
			if (menu.has("button")) {
				menu.get("button").getAsJsonArray().add(node);
			} else {
				JsonArray button = new JsonArray();
				button.add(node);
				menu.add("button", button);
			}
			return node;
		}
		return null;
	}
	
	/**
	 * 给一级菜单添加二级菜单
	 * @param node1
	 * @param params
	 * @return
	 */
	public JsonObject addMenuLevel2(JsonObject parent, Map<String, String> params) {
		JsonObject node = new JsonObject();
		if (params != null) {
			for (Entry<String, String> entry : params.entrySet()) {
				node.addProperty(entry.getKey(), entry.getValue());
			}
			if (parent.has("sub_button")) {
				parent.get("sub_button").getAsJsonArray().add(node);
			} else {
				JsonArray sub_button = new JsonArray();
				sub_button.add(node);
				parent.add("sub_button", sub_button);
			}
			return node;
		}
		return null;
	}
	
	public String getMenuStr() {
		return menu.toString();
	}
}
