package com.sunny.lms.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sunny.lms.LoginUser;
import com.sunny.lms.commom.Result;
import com.sunny.lms.entity.Book;
import com.sunny.lms.entity.LendRecord;
import com.sunny.lms.entity.User;
import com.sunny.lms.mapper.BookMapper;
import com.sunny.lms.mapper.LendRecordMapper;
import com.sunny.lms.mapper.UserMapper;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
/***
 *
 * @author SUNNY
 * @description
 * date  2023-03-09 11:07:16
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private LendRecordMapper lendRecordMapper;
    @Resource
    private BookMapper bookMapper;
    @GetMapping
    public  Result<?> dashboardrecords(){
        int visitCount = LoginUser.getVisitCount();
        QueryWrapper<User> queryWrapper1=new QueryWrapper<>();
        int userCount = Math.toIntExact(userMapper.selectCount(queryWrapper1));
        QueryWrapper<LendRecord> queryWrapper2=new QueryWrapper<LendRecord>();
        int lendRecordCount = Math.toIntExact(lendRecordMapper.selectCount(queryWrapper2));
        QueryWrapper<Book> queryWrapper3= new QueryWrapper<>();
        int bookCount = Math.toIntExact(bookMapper.selectCount(queryWrapper3));
        Map<String, Object> map = new HashMap<>();//键值对形式
        map.put("visitCount", visitCount);//放置visitCount到map中
        map.put("userCount", userCount);
        map.put("lendRecordCount", lendRecordCount);
        map.put("bookCount", bookCount);
        return Result.success(map);
    }



}
