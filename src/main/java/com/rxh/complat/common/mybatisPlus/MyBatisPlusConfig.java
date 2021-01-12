package com.rxh.complat.common.mybatisPlus;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import java.util.*;

/**
 *
 * @Description: Mybatis-plus代码自动生成配置
 * @Author Zhang YuHui 
 * @Date 2020/10/7 16:56
 *
 */
public class MyBatisPlusConfig {


    private static final String url;
    private static final String username;
    private static final String password;
    private static final String driver;

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String PROJECT_BASE_PATH = PROJECT_PATH + "/src/main/java/";
    private static final String PACKAGE_BASE_PATH = PROJECT_BASE_PATH + "/com/rxh/wechat/";


    private static final String SERVICE_TEMPLATE = "/templates/ftl/service.java.ftl";
    private static final String SERVICE_IMPL_TEMPLATE = "/templates/ftl/serviceImpl.java.ftl";
    private static final String CONTROLLER_TEMPLATE = "/templates/ftl/controller.java.ftl";
    private static final String MAPPER_TEMPLATE = "/templates/ftl/mapper.java.ftl";
    private static final String MAPPER_XMl_TEMPLATE = "/templates/ftl/mapper.xml.ftl";
    private static final String ENTITY_TEMPLATE = "/templates/ftl/entity.java.ftl";


    /**
     *
     * @Description 读取配置文件
     * @author Zhang YuHui
     * @date 2020/10/8 10:05
     *
     * @param null
     * @return
     */
    static {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource("application-shiro.yml"));
        factoryBean.afterPropertiesSet();
        Properties object = factoryBean.getObject();

        url = (String) object.get("spring.datasource.url");
        username = (String) object.get("spring.datasource.username");
        password = (String) object.get("spring.datasource.password");
        driver = (String) object.get("spring.datasource.driver-class-name");
    }

    public void codeGenerator(String modelName, String tableName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_BASE_PATH);
        gc.setAuthor("Zhang YuHui");
        gc.setOpen(false);
//        实体属性 Swagger2 注解
        gc.setSwagger2(true);

        //Mapper.xml 配置
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setSchemaName("public");
        dsc.setDriverName(driver);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);


        // 包配置
        PackageConfig pc = new PackageConfig();
        //当使用模块导出时打开
//        pc.setModuleName(modelName);

        String parentPath = "com.rxh.wechat";
        pc.setParent(parentPath);

        HashMap<String, String> map = new HashMap<>();
        map.put(ConstVal.CONTROLLER, PACKAGE_BASE_PATH + "/controller");
        map.put(ConstVal.SERVICE, PACKAGE_BASE_PATH + "/service");
        map.put(ConstVal.SERVICE_IMPL, PACKAGE_BASE_PATH + "/service/impl");
        map.put(ConstVal.ENTITY, PACKAGE_BASE_PATH + "/entity");
        map.put(ConstVal.MAPPER, PACKAGE_BASE_PATH + "/mapper");

        pc.setPathInfo(map);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = getfocList(pc);
//        List<FileOutConfig> focList = getfocList(modelName);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setController(CONTROLLER_TEMPLATE.replace(".ftl", ""));
//        templateConfig.setEntity(ENTITY_TEMPLATE.replace(".ftl", ""));
//        templateConfig.setService(SERVICE_TEMPLATE.replace(".ftl", ""));
//        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE.replace(".ftl", ""));
//        templateConfig.setMapper(MAPPER_TEMPLATE.replace(".ftl", ""));
//        templateConfig.setXml(MAPPER_XMl_TEMPLATE.replace(".ftl", ""));
//        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(tableName);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }

    private List getfocList(PackageConfig pc) {
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(MAPPER_XMl_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PROJECT_PATH + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig(MAPPER_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PACKAGE_BASE_PATH + "/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(ENTITY_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PACKAGE_BASE_PATH + "/entity/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(SERVICE_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PACKAGE_BASE_PATH + "/service/"
                        + "/I" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(SERVICE_IMPL_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PACKAGE_BASE_PATH + "/service"
                        + "/impl/" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(CONTROLLER_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return PACKAGE_BASE_PATH + "/controller/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });

        return focList;
    }
}
