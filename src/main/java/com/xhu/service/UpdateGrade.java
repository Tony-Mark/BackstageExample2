package com.xhu.service;

import com.xhu.entity.Grade;
import com.xhu.entity.Student;
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
 * @CreateTime: 2023-04-29 22:17
 * @Description: TODO
 * @Version: 1.0
 */
@WebServlet(name = "updateGrade",value = "/updateGrade")
public class UpdateGrade extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		PrintWriter out0 = response.getWriter();
		Grade grade = new Grade();
		RegisterSqlUtil.requestToModel(grade, request);
		String sql = "update grade set studentId = ?, courseCode = ?, score = ? where studentId = ? and courseCode = ?";
		System.out.println(grade);
		try {
			System.out.println(JDBCUtils.preparedSqlForUpdate(sql, grade, grade.getStudentId(), grade.getCourseCode()));
			out0.println(1);
		} catch (SQLException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		out0.flush();
		out0.close();
	}
}
