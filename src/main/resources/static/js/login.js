$(function () {
    var user = '[[${data}]]'
    var length = '[[${length}]]'
    var href = "userInfo"
    if (user == "" || user == '[[${data}]]') {
        user = "未登录"
        href = 'login'
    }
    $("#name").html(user)
    $("#name").attr("href", href)

    $("#logout").on("click", function () {
        window.location.href = "logout"
    })
    $("#search").on("input propertychange", function () {
        sendSearch($(this).val())
    })


    sendImg()
    $("#divSolid").on("mousedown", function () {
        document.onmousemove = function (e) {
            $("#solideImg").css("margin-left", e.clientX)

        }
        document.onmouseup = function (e) {
            document.onmousemove = null;
            console.log("鼠标滑动x>>>>>", e.clientX)
        }
    })


    $(".slider").on("mousedown", function () {
        document.onmousemove = function (e) {
            $(".sliderContainer").addClass("sliderContainer_active")
            $(".slider").css("left", e.clientX)
            let pa = $(".slider").parent()[0];
            $(pa).css("width",e.clientX);
            $("#solideImg").css("margin-left", e.clientX)
            $("#ig2").css("margin-left", e.clientX)
            if(e.clientX > (400-40)){
                $(".slider").css("left", 0)
                $(pa).css("width",0);
                $("#solideImg").css("margin-left", 0)
                $("#ig2").css("margin-left", 0)
            }
        }
        document.onmouseup = function (e) {
            document.onmousemove = null;
            console.log("鼠标滑动x>>>>>", e.clientX)
            let clientX = e.clientX;
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


})

function sendImg() {
    $("#solideImg").css("margin-left", "0px")
    $.get("img", {}, function (date) {
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

    })
}

function sendImg1() {
    let css = $("#img").css("height");
    console.log("img高>>>>>>>>", css)
    let parentElement = $("#solideImg").parent()[0];
    let css1 = $(parentElement).css("margin-top");
    console.log("div高>>>>>>>>", css1)
}

function sendSearch(text) {
    $.get("query", {
        index: "demodata",
        fild: "text",
        value: text,
        size: 10
    }, function (date) {
        console.log(date.data)
        let data = date.data;
        for (var a = 0; a < data.length; a++) {
            var s = "<span>" + JSON.stringify(data[a].text) + "</span>"
            $("#text").html(s)
        }

    })
}