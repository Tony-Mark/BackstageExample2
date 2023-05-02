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
@WebServlet(name = "myDelete2",value = "/myDelete2")
public class MyDelete2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		String tableName = request.getParameter("tableName");
		String key0 = request.getParameter("key0");
		String value0 = request.getParameter("value0");
		String key1 = request.getParameter("key1");
		String value1 = request.getParameter("value1");
		String sql = "delete from "+tableName+" where "+key0+" = ? and "+key1+" = ?";
		System.out.println(tableName+","+key0+":"+value1+","+key1+":"+value1);
		JSONArray jsonArray = new JSONArray();
		try {
			JDBCUtils.deleteForSingleFactor(sql, jsonArray, value0, value1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
