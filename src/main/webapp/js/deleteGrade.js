$(function (){
    window.onload = function (){
        SelectAll("selectGrade", "grade", "select_context", "studentId,courseCode,score");
    }
    $("input:radio").bind("click",function (){
        let factor = $("input:radio:checked").val();
        $("#studentMessage").removeAttr("disabled");
        $("#select").removeAttr("disabled");
        if (factor == "all"){
            $("#studentMessage").empty();
            $("#studentMessage").attr("disabled","disabled");
            $("#select").attr("disabled", "disabled");
            SelectAll("selectGrade", "grade", "select_context", "studentId,courseCode,score");
        }else{
            InitialList("initialize", "grade", factor, "studentMessage", 1);
        }
    })
    $("#select").bind("click",function (){
        $("#select_context").empty();
        let factor = $("input:radio:checked").val();
        SelectForSingleFactor1("select3", "grade", factor, "studentMessage", "select_context","studentId,courseCode,score");
    })
})