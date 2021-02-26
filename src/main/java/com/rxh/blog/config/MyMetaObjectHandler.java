package com.rxh.blog.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description mybatis-plus 自动添加床架时间和修改时间
 *              在Mapper.xml文件中不要再添加这鞋默认字段,mybatis-plus会自动添加,xml如果有这些字段 可能会造成默认值不对
 * @author Zhang YuHui
 * @date 2021/1/26
 *
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //设置插入时的默认值
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject,"status",Integer.class,Integer.parseInt("1"));
    }

    //设置更新时的默认值
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
    }
}