package com.sunny.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunny.lms.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
