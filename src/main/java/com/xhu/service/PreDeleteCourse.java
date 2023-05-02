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
 * @CreateTime: 2023-04-27 19:42
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet(name = "preDeleteCourse",value = "/preDeleteCourse")
public class PreDeleteCourse extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		JSONArray jsonArray = new JSONArray();
		PrintWriter out0 = response.getWriter();
		String args = request.getParameter("args");
		String[] arg = args.split(":");
		String sql = "select "+ arg[3] +" from "+arg[0]+" where "+arg[1]+" = ?";
		try {
			JDBCUtils.selectForSingleFactor2(sql, jsonArray, 1, 1, arg[2]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		out0.println(jsonArray);
		out0.flush();
		out0.close();
	}
}
