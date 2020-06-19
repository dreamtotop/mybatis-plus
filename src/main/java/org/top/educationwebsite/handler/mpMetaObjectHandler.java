package org.top.educationwebsite.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class mpMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject,"createTime", LocalDateTime.now());
        this.fillStrategy(metaObject,"updateTime", LocalDateTime.now());
        this.fillStrategy(metaObject,"version",1);
        this.fillStrategy(metaObject,"deleted",0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject,"updateTime",LocalDateTime.now());
    }
}
