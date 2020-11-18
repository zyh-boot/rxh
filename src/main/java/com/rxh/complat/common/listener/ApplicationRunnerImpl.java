package com.rxh.complat.common.listener;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 *
 * @Description: springboot启动监听
 * @Author Zhang YuHui 
 * @Date 2020/9/30 14:07
 *
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner, ApplicationListener<WebServerInitializedEvent> {

    private final String logo= "(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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

    @Override
    public void run(ApplicationArguments arguments) {

    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {

        WebServer webServer = event.getWebServer();
        WebServerApplicationContext context = event.getApplicationContext();
        Environment environment = context.getEnvironment();
        InetAddress localHost = InetAddress.getLocalHost();
        String IP = localHost.getHostAddress();
        int port = webServer.getPort();
        String contextPath = environment.getProperty("server.servlet.context-path");
        if (contextPath == null) {
            contextPath = "";
        }
        System.out.println(logo);
        Logger logger = LoggerFactory.getLogger(ApplicationRunnerImpl.class);
        logger.info("访问链接: http://" + IP + ":" + port  + contextPath);
    }
}
