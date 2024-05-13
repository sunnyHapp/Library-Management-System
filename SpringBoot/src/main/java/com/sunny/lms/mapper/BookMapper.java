package com.sunny.lms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunny.lms.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
