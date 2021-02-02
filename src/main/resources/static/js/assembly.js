$(function () {
    sendImg()

    $(".slider").on("mousedown", function (e) {
        let clientX1 = e.clientX;
        document.onmousemove = function (e) {
            $(".sliderContainer").addClass("sliderContainer_active")
            $(".slider").css("left", e.clientX-clientX1)
            let pa = $(".slider").parent()[0];
            $(pa).css("width",e.clientX-clientX1);
            $("#ig2").css("margin-left", e.clientX-clientX1)
            if(e.clientX-clientX1 > (400-40)){
                $(".slider").css("left", 0)
                $(pa).css("width",0);
                $("#solideImg").css("margin-left", 0)
                $("#ig2").css("margin-left", 0)
            }
        }
        document.onmouseup = function (e) {
            document.onmousemove = null;
            console.log("鼠标滑动x>>>>>", e.clientX-clientX1)
            let clientX = e.clientX-clientX1;
            let val = $("#length").val();
            let num = val - clientX;
            if(num > -5 && num < 5 ){
                $(".sliderContainer").removeClass("sliderContainer_active")
                $(".sliderContainer").addClass("sliderContainer_success")
                // $(".slider").addClass("slider_success")
                // $(".slider").removeClass("slider")
                // document.onmousemove = null;
            }else{
                $(".sliderContainer").removeClass("sliderContainer_active")
                $(".sliderContainer").addClass(" sliderContainer_fail")

                setTimeout(function () {
                    sendImg()
                    $(".sliderContainer").removeClass("sliderContainer_fail")
                    $(".sliderContainer").removeClass("sliderContainer_success")
                    let pa = $(".slider").parent()[0];
                    $(".slider").css("left", 0)
                    $(pa).css("width",0);
                    $("#solideImg").css("margin-left", 0)
                    $("#ig2").css("margin-left", 0)
                },2000)
            }
            document.onmouseup = null
        }
    })

    $(".refreshIcon").on("click",function () {
        sendImg()
    })
})
function sendImg() {
    $(".slider").css("margin-left", "0px")
    $(".slider").css("left", "0px")
    $(".sliderMask").css("left", "0px")
    $(".sliderMask").css("width", "0px")
    $(".sliderContainer").removeClass("sliderContainer_success")
    $.get("../img", {}, function (date) {
        console.log(date)
        let data = date;
        $("#img").attr("src", data.backName)

        let parentElement = $("#img").parent()[0];
        $(parentElement).css("width", data.backLength)
        $(parentElement).height(data.backHeight)


        let jQueryElement = $("#solideImg").parent()[0];
        let backHength = data.backHeight;
        let ylocation = data.ylocation;
        $("#length").val(data.xlocation)
        let number = ylocation - backHength - 4;
        $(jQueryElement).css("margin-top", number + "px");

        $("#solideImg").attr("src", data.markName)


        $("#ig1").attr("src", data.backName);
        $("#ig2").attr("src", data.markName);
        $("#ig2").css("top", data.ylocation);
        $("#ig2").css("margin-left", 0);

    })
}