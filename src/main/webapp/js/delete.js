$(function(){
    $("#get-student").bind('click',function(){
        SelectForSingleFactor1("select2", "student", "sex", "sex", "show-div", "studentId,studentName,phone,sex,hobbies,address,date,note,file");
    })
})