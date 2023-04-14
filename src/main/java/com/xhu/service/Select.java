package com.xhu.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xhu.entity.Student;
import com.xhu.jdbc.utils.JDBCUtils;
import com.xhu.jdbc.utils.RegisterSqlUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author TonyJUN
 */
@WebServlet(name = "select", value = "/select")
public class Select extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		PrintWriter out0 = response.getWriter();
		Connection connection = JDBCUtils.getConnection();
		ResultSet rs = null;
		JSONArray jsonArray = new JSONArray();
		JDBCUtils.selectForSingleFactor(request, jsonArray);
		out0.println(jsonArray);
		JDBCUtils.close(rs, connection);
		out0.flush();
		out0.close();
	}
}
