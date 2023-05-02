$(function (){
    window.onload = function (){
        InitialList("initialize", "student", "studentId", "studentMessage", 1);
    }
    $("input:radio").bind("click",function (){
        let factor = $("input:radio:checked").val();
        InitialList("initialize", "student", factor, "studentMessage", 1);
    })
    $("#select").bind("click",function (){
        $("#select_context").empty();
        let factor = $("input:radio:checked").val();
        SelectForSingleFactor0("select", "student", factor, "studentMessage", "select_context");
    })
})