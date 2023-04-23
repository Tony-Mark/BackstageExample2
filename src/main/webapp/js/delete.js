$(function(){
    window.onload = function (){
        InitialList("initialize", "student", "studentName", "studentName", 1);
        InitialList("initialize", "student", "sex", "sex", 1);
    }
    $("#delete").bind("click",function(){
        myDelete2("delete", "student", "studentName", "sex", "studentName", "sex");
    })
})