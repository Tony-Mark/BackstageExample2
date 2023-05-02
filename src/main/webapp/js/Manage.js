$(function(){
	/*首页*/
	$("#firstPage").bind("click",function (){
		$("#container").empty();
	})
	/*添加课程界面*/
	$("#add-course").bind("click",function (){
		$.get("course.html",function (data){
			$("#container").html(data);
		})
	})
	/*添加成绩界面*/
	$("#add-grade").bind("click",function (){
		$.get("grade.html",function (data){
			$("#container").html(data)
		})
	})
	/*学生查询界面*/
	$("#select-student").bind("click",function (){
		$.get("select.html",function (data){
			$("#container").html(data);
		})
	})
	/*学生删除界面*/
	$("#delete-student").bind("click",function (){
		$.get("deleteStudent.html",function (data){
			$("#container").html(data);
		})
	})
	$("#select-course").bind("click",function (){
		$.get("deleteCourse.html",function (data){
			$("#container").html(data);
		})
	})
	$("#select-grade").bind("click",function (){
		$.get("deleteGrade.html",function (data){
			$("#container").html(data);
		})
	})
	$("#close").bind("click",function(){
		window.close();
	})
})