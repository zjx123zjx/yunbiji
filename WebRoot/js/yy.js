
$(function () {


$(".top span").click(function(){
    var text=$(this).html();
    if(text=="笔记"){
        $(".first").css("display","block");
        $(".second").css("display","none");

    }
    else{
        $(".first").css("display","none");
        $(".second").css("display","block");
    }
})
   $(".first div").click(function(){
    var index=$(this).index();
    $(".right div").eq(index).css("display","block").siblings().css("display","none");
})
    $(".second div").click(function(){
        var index=$(this).index();
        $(".right div").eq(index+2).css("display","block").siblings().css("display","none");
    })
})



