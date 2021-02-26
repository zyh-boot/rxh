package com.rxh.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 后台模板
 * @author Zhang YuHui
 * @date 2021/2/22 10:54
 */
@Controller
@RequestMapping("backstage")
public class BackstageViewController {
    @RequestMapping("index")
    public String index() {
        return "/pages/backstage/index-ifram";
    }

    @RequestMapping("component/table/static")
    public String tableStatic() {
        return "/pages/backstage/component/table/static";
    }

    @RequestMapping("component/code/index")
    public String codeIndex() {
        return "/pages/backstage/component/code/index";
    }


    @RequestMapping("app/content/tags")
    public String contentTags() {
        return "/pages/backstage/app/content/tags";
    }

    @RequestMapping("component/tree/index")
    public String treeIndex() {
        return "/pages/backstage/component/tree/index";
    }

    @RequestMapping("component/table/totalRow")
    public String tableTotalRow() {
        return "/pages/backstage/component/table/totalRow";
    }

    @RequestMapping("template/search")
    public String templateSearch() {
        return "/pages/backstage/template/search";
    }

    @RequestMapping("component/button/index")
    public String buttonIndex() {
        return "/pages/backstage/component/button/index";
    }

    @RequestMapping("component/grid/speed-dial")
    public String gridSpeeddial() {
        return "/pages/backstage/component/grid/speed-dial";
    }

    @RequestMapping("component/grid/mobile")
    public String gridMobile() {
        return "/pages/backstage/component/grid/mobile";
    }

    @RequestMapping("component/table/toolbar")
    public String tableToolbar() {
        return "/pages/backstage/component/table/toolbar";
    }

    @RequestMapping("app/workorder/list")
    public String workorderList() {
        return "/pages/backstage/app/workorder/list";
    }

    @RequestMapping("component/laydate/demo2")
    public String laydateDemo2() {
        return "/pages/backstage/component/laydate/demo2";
    }

    @RequestMapping("component/laydate/special-demo")
    public String laydateSpecialdemo() {
        return "/pages/backstage/component/laydate/special-demo";
    }

    @RequestMapping("component/laydate/theme")
    public String laydateTheme() {
        return "/pages/backstage/component/laydate/theme";
    }

    @RequestMapping("component/upload/demo2")
    public String uploadDemo2() {
        return "/pages/backstage/component/upload/demo2";
    }

    @RequestMapping("set/user/password")
    public String userPassword() {
        return "/pages/backstage/set/user/password";
    }

    @RequestMapping("component/progress/index")
    public String progressIndex() {
        return "/pages/backstage/component/progress/index";
    }

    @RequestMapping("component/form/group")
    public String formGroup() {
        return "/pages/backstage/component/form/group";
    }

    @RequestMapping("component/laydate/demo1")
    public String laydateDemo1() {
        return "/pages/backstage/component/laydate/demo1";
    }

    @RequestMapping("component/flow/index")
    public String flowIndex() {
        return "/pages/backstage/component/flow/index";
    }

    @RequestMapping("template/personalpage")
    public String templatePersonalpage() {
        return "/pages/backstage/template/personalpage";
    }

    @RequestMapping("component/slider/index")
    public String sliderIndex() {
        return "/pages/backstage/component/slider/index";
    }

    @RequestMapping("component/panel/index")
    public String panelIndex() {
        return "/pages/backstage/component/panel/index";
    }

    @RequestMapping("component/grid/list")
    public String gridList() {
        return "/pages/backstage/component/grid/list";
    }

    @RequestMapping("user/administrators/list")
    public String administratorsList() {
        return "/pages/backstage/user/administrators/list";
    }

    @RequestMapping("set/system/email")
    public String systemEmail() {
        return "/pages/backstage/set/system/email";
    }

    @RequestMapping("component/auxiliar/index")
    public String auxiliarIndex() {
        return "/pages/backstage/component/auxiliar/index";
    }

    @RequestMapping("component/table/operate")
    public String tableOperate() {
        return "/pages/backstage/component/table/operate";
    }

    @RequestMapping("component/util/index")
    public String utilIndex() {
        return "/pages/backstage/component/util/index";
    }

    @RequestMapping("component/badge/index")
    public String badgeIndex() {
        return "/pages/backstage/component/badge/index";
    }

    @RequestMapping("template/tips/404")
    public String tips404() {
        return "/pages/backstage/template/tips/404";
    }

    @RequestMapping("component/table/tostatic")
    public String tableTostatic() {
        return "/pages/backstage/component/table/tostatic";
    }

    @RequestMapping("template/caller")
    public String templateCaller() {
        return "/pages/backstage/template/caller";
    }


    @RequestMapping("home/console")
    public String homeConsole() {
        return "/pages/backstage/home/console";
    }

    @RequestMapping("component/table/page")
    public String tablePage() {
        return "/pages/backstage/component/table/page";
    }

    @RequestMapping("component/table/resetPage")
    public String tableResetPage() {
        return "/pages/backstage/component/table/resetPage";
    }

    @RequestMapping("component/timeline/index")
    public String timelineIndex() {
        return "/pages/backstage/component/timeline/index";
    }

    @RequestMapping("app/content/list")
    public String contentList() {
        return "/pages/backstage/app/content/list";
    }

    @RequestMapping("set/user/info")
    public String userInfo() {
        return "/pages/backstage/set/user/info";
    }

    @RequestMapping("component/layer/theme")
    public String layerTheme() {
        return "/pages/backstage/component/layer/theme";
    }

    @RequestMapping("component/table/data")
    public String tableData() {
        return "/pages/backstage/component/table/data";
    }

    @RequestMapping("component/table/height")
    public String tableHeight() {
        return "/pages/backstage/component/table/height";
    }

    @RequestMapping("component/grid/all")
    public String gridAll() {
        return "/pages/backstage/component/grid/all";
    }

    @RequestMapping("component/table/reload")
    public String tableReload() {
        return "/pages/backstage/component/table/reload";
    }

    @RequestMapping("component/laypage/demo1")
    public String laypageDemo1() {
        return "/pages/backstage/component/laypage/demo1";
    }

    @RequestMapping("component/upload/demo1")
    public String uploadDemo1() {
        return "/pages/backstage/component/upload/demo1";
    }

    @RequestMapping("set/system/website")
    public String systemWebsite() {
        return "/pages/backstage/set/system/website";
    }

    @RequestMapping("template/goodslist")
    public String templateGoodslist() {
        return "/pages/backstage/template/goodslist";
    }

    @RequestMapping("component/rate/index")
    public String rateIndex() {
        return "/pages/backstage/component/rate/index";
    }

    @RequestMapping("app/content/comment")
    public String contentComment() {
        return "/pages/backstage/app/content/comment";
    }

    @RequestMapping("component/grid/mobile-pc")
    public String gridMobilepc() {
        return "/pages/backstage/component/grid/mobile-pc";
    }

    @RequestMapping("component/transfer/index")
    public String transferIndex() {
        return "/pages/backstage/component/transfer/index";
    }

    @RequestMapping("component/table/thead")
    public String tableThead() {
        return "/pages/backstage/component/table/thead";
    }

    @RequestMapping("app/forum/replys")
    public String forumReplys() {
        return "/pages/backstage/app/forum/replys";
    }

    @RequestMapping("component/table/checkbox")
    public String tableCheckbox() {
        return "/pages/backstage/component/table/checkbox";
    }

    @RequestMapping("template/msgboard")
    public String templateMsgboard() {
        return "/pages/backstage/template/msgboard";
    }

    @RequestMapping("app/forum/list")
    public String forumList() {
        return "/pages/backstage/app/forum/list";
    }

    @RequestMapping("senior/echarts/bar")
    public String echartsBar() {
        return "/pages/backstage/senior/echarts/bar";
    }

    @RequestMapping("component/table/onrow")
    public String tableOnrow() {
        return "/pages/backstage/component/table/onrow";
    }

    @RequestMapping("home/homepage1")
    public String homeHomepage1() {
        return "/pages/backstage/home/homepage1";
    }

    @RequestMapping("component/tabs/index")
    public String tabsIndex() {
        return "/pages/backstage/component/tabs/index";
    }

    @RequestMapping("template/tips/error")
    public String tipsError() {
        return "/pages/backstage/template/tips/error";
    }

    @RequestMapping("senior/echarts/line")
    public String echartsLine() {
        return "/pages/backstage/senior/echarts/line";
    }

    @RequestMapping("component/form/element")
    public String formElement() {
        return "/pages/backstage/component/form/element";
    }

    @RequestMapping("component/laypage/demo2")
    public String laypageDemo2() {
        return "/pages/backstage/component/laypage/demo2";
    }

    @RequestMapping("senior/echarts/map")
    public String echartsMap() {
        return "/pages/backstage/senior/echarts/map";
    }

    @RequestMapping("component/table/cellEdit")
    public String tableCellEdit() {
        return "/pages/backstage/component/table/cellEdit";
    }

    @RequestMapping("component/table/fixed")
    public String tableFixed() {
        return "/pages/backstage/component/table/fixed";
    }

    @RequestMapping("component/table/auto")
    public String tableAuto() {
        return "/pages/backstage/component/table/auto";
    }

    @RequestMapping("user/user/list")
    public String userList() {
        return "/pages/backstage/user/user/list";
    }

    @RequestMapping("component/layer/list")
    public String layerList() {
        return "/pages/backstage/component/layer/list";
    }

    @RequestMapping("component/table/simple")
    public String tableSimple() {
        return "/pages/backstage/component/table/simple";
    }

    @RequestMapping("component/table/form")
    public String tableForm() {
        return "/pages/backstage/component/table/form";
    }

    @RequestMapping("component/table/parseData")
    public String tableParseData() {
        return "/pages/backstage/component/table/parseData";
    }

    @RequestMapping("component/table/cellEvent")
    public String tableCellEvent() {
        return "/pages/backstage/component/table/cellEvent";
    }





    @RequestMapping("component/nav/index")
    public String navIndex() {
        return "/pages/backstage/component/nav/index";
    }

    @RequestMapping("component/anim/index")
    public String animIndex() {
        return "/pages/backstage/component/anim/index";
    }

    @RequestMapping("component/table/initSort")
    public String tableInitSort() {
        return "/pages/backstage/component/table/initSort";
    }

    @RequestMapping("component/carousel/index")
    public String carouselIndex() {
        return "/pages/backstage/component/carousel/index";
    }

    @RequestMapping("home/homepage2")
    public String homeHomepage2() {
        return "/pages/backstage/home/homepage2";
    }

    @RequestMapping("app/message/index")
    public String messageIndex() {
        return "/pages/backstage/app/message/index";
    }

    @RequestMapping("component/layer/special-demo")
    public String layerSpecialdemo() {
        return "/pages/backstage/component/layer/special-demo";
    }

    @RequestMapping("user/administrators/role")
    public String administratorsRole() {
        return "/pages/backstage/user/administrators/role";
    }

    @RequestMapping("template/addresslist")
    public String templateAddresslist() {
        return "/pages/backstage/template/addresslist";
    }

    @RequestMapping("component/grid/stack")
    public String gridStack() {
        return "/pages/backstage/component/grid/stack";
    }

    @RequestMapping("component/table/style")
    public String tableStyle() {
        return "/pages/backstage/component/table/style";
    }

    @RequestMapping("component/colorpicker/index")
    public String colorpickerIndex() {
        return "/pages/backstage/component/colorpicker/index";
    }

    @RequestMapping("component/table/radio")
    public String tableRadio() {
        return "/pages/backstage/component/table/radio";
    }


}
