$(function (){
    window.onload = function (){
        setup();
        init();
    }
    $("#update").bind("click",function (){
        if (getFormAllData("update", "form1")){
            alert("修改成功");
        }else{
            alert("修改失败");
        }
    })
})

function init(){
    let tableName = getQueryString("tableName");
    let filedName = getQueryString("key0");
    let value = getQueryString("value0");
    console.log(tableName+","+filedName+","+value);
    let re = myUpdate("select", tableName, filedName, value);
    console.log(re);
    $("#studentId").val(re[0]["studentId"]);
    $("#studentName").val(re[0]["studentName"]);
    $("#password").val(re[0]["password"]);
    $("#phone").val(re[0]["phone"]);
    /*性别*/
    let sex = document.getElementsByName("sex");
    for (let i = 0; i<sex.length;i++){
        if (sex[i].value == re[0]["sex"]){
            sex[i].checked = true;
        }
    }
    /*爱好*/
    let hobbies = re[0]["hobbies"].split("-");
    console.log(hobbies);
    let ah = document.getElementsByName("hobbies");
    /*遍历多name控件*/
    for (let i = 0;i<ah.length;i++){
        /*遍历数据*/
        for (let j = 0;j<hobbies.length;j++){
            if (ah[i].value == hobbies[j]){
                console.log(ah[i].value);
                ah[i].checked = true;
            }
        }
    }
    /*地址*/
    let address = re[0]["address"].split("-");
    console.log(address);
    let city = document.getElementsByName("address");
    for (let i = 0;i<city.length;i++){
        city[i].value = address[i];
    }
    /*生日*/
    let date = re[0]["date"].split("-");
    console.log(date);
    let year = document.getElementsByName("date");
    for (let i = 0;i<year.length;i++){
        year[i].value = date[i];
    }
    $("#note").val(re[0]["note"]);
    $("#file").val(re[0]["file"]);
}