$(function (){
    window.onload = function (){
        SelectAll("selectCourse", "course", "select_context",
            "courseCode as '课程号',courseName as ‘课程名’,credit as '学分',time as '开课时间',note as '批注'");
    }
    $("input:radio").bind("click",function (){
        let factor = $("input:radio:checked").val();
        $("#studentMessage").removeAttr("disabled");
        $("#select").removeAttr("disabled");
        if (factor == "all"){
            $("#studentMessage").empty();
            $("#studentMessage").attr("disabled","disabled");
            $("#select").attr("disabled", "disabled");
            SelectAll("selectCourse", "course", "select_context",
                "courseCode as '课程号',courseName as ‘课程名’,credit as '学分',time as '开课时间',note as '批注'");
        }else{
            InitialList("initialize", "course", factor, "studentMessage", 1);
        }
    })
    $("#select").bind("click",function (){
        $("#select_context").empty();
        let factor = $("input:radio:checked").val();
        SelectForSingleFactor1("preDeleteCourse", "course", factor, "studentMessage",
            "select_context","courseCode as '课程号',courseName as ‘课程名’,credit as '学分',time as '开课时间',note as '批注'");
    })
})