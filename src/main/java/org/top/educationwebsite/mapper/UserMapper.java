package org.top.educationwebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.top.educationwebsite.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
