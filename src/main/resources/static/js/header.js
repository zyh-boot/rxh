$(function () {
   //thymeleaf 获取参数格式
    var user = '[[${data}]]'
    var length = '[[${length}]]'
    var href = "userInfo"

    $.get("/isLogin",function (data) {
       console.log(data)
        if(data.code == 200){
            user = data.data
            href = href
        }else{
            user = "未登录"
            href = 'login'
        }
        $("#name span").html(user)
        $("#name").attr("href", href)
    })
    // if (user == "" || user == '[[${data}]]') {
    //     user = "未登录"
    //     href = 'login'
    // }

    $("#logout").on("click", function () {
        window.location.href = "logout"
    })
    $("#search").on("input propertychange", function () {
        sendSearch($(this).val())
    })

})




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