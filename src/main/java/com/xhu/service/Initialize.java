package com.xhu.service;

import com.alibaba.fastjson.JSONArray;
import com.xhu.jdbc.utils.JDBCUtils;
import com.xhu.jdbc.utils.RegisterSqlUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author TonyJUN
 */
@WebServlet(name = "initialize", value = "/initialize")
public class Initialize extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		JSONArray jsonArray = new JSONArray();
		JDBCUtils.selectInitialize(request, jsonArray);
		System.out.println(jsonArray);
		PrintWriter writer = response.getWriter();
		writer.println(jsonArray);
		writer.flush();
		writer.close();
	}
}
