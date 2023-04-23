package com.xhu.service;

import com.alibaba.fastjson.JSONArray;
import com.xhu.jdbc.utils.JDBCUtils;
import com.xhu.jdbc.utils.RegisterSqlUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author TonyJUN
 */
@WebServlet(name = "delete", value = "/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RegisterSqlUtil.setCode(request, response);
      PrintWriter out0 = response.getWriter();
      JSONArray jsonArray = new JSONArray();
      try {
          JDBCUtils.deleteForSingleFactor(request, jsonArray);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      out0.println(jsonArray);
      out0.flush();
      out0.close();
  }
}
