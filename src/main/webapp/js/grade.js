$(function (){
    window.onload = function (){
        init();
    }
    $("#reset").bind("click",function (){
        $("#studentId").val("");
        $("#courseCode").val("");
        $("#score").val("");
    })
    $("#submit").bind("click",function (){
        let url0 = $("#scoreForm").attr("action");
        if (getFormAllData(url0,"scoreForm")){
            alert("添加成功");
        }else{
            alert("添加失败");
        }
    }) 
})

function init(){
    InitialList("initialize","student","studentId","studentId",1);
    InitialList("initialize","course","courseCode","courseCode",1);
}