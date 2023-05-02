package com.xhu.service;

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
@WebServlet(name = "update",value = "/update")
public class UpdateStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterSqlUtil.setCode(request, response);
		PrintWriter out0 = response.getWriter();
		Student student = new Student();
		RegisterSqlUtil.requestToModel(student, request);
		String sql = "update student set studentId = ?, studentName = ?, password = ?," +
				"phone = ?, sex = ?, hobbies = ?, address = ?, date = ?, note = ?, file = ? where studentId = ?";
		System.out.println(student);
		try {
			System.out.println(JDBCUtils.preparedSqlForUpdate(sql, student, student.getStudentId()));
			out0.println(1);
		} catch (SQLException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		out0.flush();
		out0.close();
	}
}
