package com.rxh.wechat.listener;

import com.rxh.wechat.WechatAppApplication;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @Description: springboot启动监听
 * @Author Zhang YuHui 
 * @Date 2020/9/30 14:07
 *
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments arguments){
        String logo= "(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "     ___           ___           ___\n" +
                "     /  /\\         /__/|         /__/\\\n" +
                "    /  /::\\       |  |:|         \\  \\:\\\n" +
                "   /  /:/\\:\\      |  |:|          \\__\\:\\\n" +
                "  /  /:/~/:/    __|__|:|      ___ /  /::\\\n" +
                " /__/:/ /:/___ /__/::::\\____ /__/\\  /:/\\:\\\n" +
                " \\  \\:\\/:::::/    ~\\~~\\::::/ \\  \\:\\/:/__\\/\n" +
                "  \\  \\::/~~~~      |~~|:|~~   \\  \\::/\n" +
                "   \\  \\:\\          |  |:|      \\  \\:\\\n" +
                "    \\  \\:\\         |  |:|       \\  \\:\\\n" +
                "     \\__\\/         |__|/         \\__\\/";

        Logger logger = LoggerFactory.getLogger(WechatAppApplication.class);
        System.out.println(logo);
        logger.info("application success....");
//        System.out.println("");
    }
}
