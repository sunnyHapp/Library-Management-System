package com.sunny.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunny.lms.entity.BookWithUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookWithUserMapper extends BaseMapper<BookWithUser> {

}
