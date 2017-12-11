package com.vueoschina.cn.openapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vueoschina.cn.bean.mock.MineCustomBean;
import com.vueoschina.cn.bean.mock.MockBaseBean;

public class MockServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper;

	public MockServelet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		objectMapper = new ObjectMapper();
	}

	@Override
	public void destroy() {
		super.destroy();
		objectMapper = null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		String method = request.getParameter("method");
		if ("minecustoms".equals(method)) {
			MockBaseBean<List<MineCustomBean>> mockBaseBean = new MockBaseBean<List<MineCustomBean>>();
			List<MineCustomBean> customBeans = new ArrayList<MineCustomBean>();
			for (int i = 0; i < 5; i++) {
				MineCustomBean mineCustomBean = new MineCustomBean();
				mineCustomBean.setContactsPhoneNum("125987453" + i);
				mineCustomBean.setCustomAddress("徐汇区234" + i);
				mineCustomBean.setCustomName("姓名" + i);
				mineCustomBean.setLatitude(256.12);
				mineCustomBean.setLongitude(125.26);
				customBeans.add(mineCustomBean);
			}
			mockBaseBean.setMsg("");
			mockBaseBean.setRet(200);
			mockBaseBean.setData(customBeans);
			String result = objectMapper.writeValueAsString(mockBaseBean);
			System.out.println("minecustoms result=" + result);
			PrintWriter out = response.getWriter();
			out.append(result);
		} else if ("customsdetail".equals(method)) {
			MockBaseBean<CustomDetailBean> mockBaseBean = new MockBaseBean<CustomDetailBean>();
			CustomDetailBean customDetailBean = new CustomDetailBean();
			customDetailBean.setContactsName("王丽");
			customDetailBean.setContactsPhoneNum("1875548985");
			customDetailBean.setCountsVisit30("20");
			customDetailBean.setCustomId("4552258894110");
			customDetailBean.setCustomName("沃尔玛");
			customDetailBean.setDetailAddress("宜山路342号");
			customDetailBean.setDistribuite("上海市徐汇区");
			customDetailBean.setPreVisitTime("2017年5月31号");
			List<StorePicBean> storePics = new ArrayList<StorePicBean>();
			for (int i = 0; i < 2; i++) {
				StorePicBean storePic = new StorePicBean();
				storePics.add(storePic);
			}
			customDetailBean.setStorePics(storePics);
			mockBaseBean.setMsg("");
			mockBaseBean.setRet(200);
			mockBaseBean.setData(customDetailBean);
			String result = objectMapper.writeValueAsString(mockBaseBean);
			System.out.println("customsdetail result=" + result);
			PrintWriter out = response.getWriter();
			out.append(result);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
