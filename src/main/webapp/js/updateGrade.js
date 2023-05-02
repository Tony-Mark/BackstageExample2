$(function (){
    window.onload = function (){
        init();
    }
    $("#update").bind("click",function (){
        if (getFormAllData("updateGrade", "scoreForm")){
            alert("修改成功");
        }else{
            alert("修改失败");
        }
    })
})
function init(){
    let tableName = getQueryString("tableName");
    let filedName1 = getQueryString("key0");
    let value1 = getQueryString("value0");
    let filedName2 = getQueryString("key1");
    let value2 = getQueryString("value1");
    let re = myUpdate1("preUpdate", tableName, filedName1, filedName2, value1, value2);
    console.log(re);
    $("#studentId").val(re[0]["studentId"]);
    $("#courseCode").val(re[0]["courseCode"]);
    $("#score").val(re[0]["score"]);
}