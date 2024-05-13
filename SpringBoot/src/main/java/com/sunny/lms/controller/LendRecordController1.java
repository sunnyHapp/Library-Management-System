package com.sunny.lms.controller;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sunny.lms.commom.Result;
import com.sunny.lms.entity.LendRecord;
import com.sunny.lms.mapper.LendRecordMapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
/***
 *
 * @author SUNNY
 * @description
 * date  2023-03-09 11:07:16
 */
@RestController
@RequestMapping("/LendRecord1")
public class LendRecordController1 {
    // 注入LendRecordMapper
    @Resource
    LendRecordMapper LendRecordMapper;
    // 更新LendRecord表中的isbn、reader_id、borrownum字段
    @PutMapping
    public  Result<?> update2( @RequestBody LendRecord lendRecord){
        // 创建UpdateWrapper对象
        UpdateWrapper<LendRecord> updateWrapper = new UpdateWrapper<>();
        // 设置更新条件
        updateWrapper.eq("isbn",lendRecord.getIsbn()).eq("reader_id",lendRecord.getReaderId()).eq("borrownum",lendRecord.getBorrownum());
        // 创建LendRecord对象
        LendRecord lendrecord = new LendRecord();
        // 设置更新字段
        lendrecord.setReturnTime(lendRecord.getReturnTime());
        lendrecord.setStatus(lendRecord.getStatus());
        // 更新LendRecord表中的isbn、reader_id、borrownum字段
        LendRecordMapper.update(lendrecord, updateWrapper);
        // 返回成功信息
        return Result.success();
    }



}