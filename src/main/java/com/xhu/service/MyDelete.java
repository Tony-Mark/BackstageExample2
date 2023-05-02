package com.xhu.service;

import com.alibaba.fastjson.JSONArray;
import com.xhu.jdbc.utils.JDBCUtils;
import com.xhu.jdbc.utils.RegisterSqlUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @BelongsProject: BackstageExample2
 * @Author: XJ
 * @CreateTime: 2023-04-27 20:07
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet(name = "myDelete",value = "/myDelete")
public class MyDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		String tableName = request.getParameter("tableName");
		String key0 = request.getParameter("key0");
		String value0 = request.getParameter("value0");
		String sql = "delete from "+tableName+" where "+key0+" = ?";
		JSONArray jsonArray = new JSONArray();
		try {
			JDBCUtils.deleteForSingleFactor(sql, jsonArray, value0);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		System.out.println(jsonArray);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
