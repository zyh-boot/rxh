//通用js
//layui分页
var laypage = layui.laypage;

function showPage(ele, size, curPage, total,callBack) {
    console.log("size>>>>>>>>>>>>>>>>>>>>>>",size)
    console.log("curPage>>>>>>>>>>>>>>>>>>>>>>",curPage)
    console.log("total>>>>>>>>>>>>>>>>>>>>>>",total)
    curPage == null ? 1 : curPage;
    size == null ? 10 : size;
    var i = 0;
    laypage.render({
        elem: ele
        , count: total
        , limit: size
        // , limits: [3,5,8]
        , theme: '#1E9FFF'
        , curr: curPage  //当前页
        , prev: "<"
        , next: ">"
        , layout: ["prev", "page", "next", "count", "skip"] //分页的组件在页面放置的先后顺序
        , groups: 2
        , jump: function (obj, first) {
            if (!first) {
                if (i == 0) {
                    callBack(obj.limit, obj.curr)
                    // showCommon(obj.limit, obj.curr)
                }
                i += 1;
            }
        }
    });
}

function showLabel(id){
    window.location.href = "/blog/label/"+id
}



