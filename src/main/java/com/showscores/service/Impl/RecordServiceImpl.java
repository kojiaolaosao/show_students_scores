package com.showscores.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.showscores.entity.BaseEntity;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import com.showscores.mapper.GradeRecordMapper;
import com.showscores.mapper.RecordMapper;
import com.showscores.mapper.StudentMapper;
import com.showscores.service.GradeRecordService;
import com.showscores.service.RecordService;
import com.showscores.service.StudentService;
import com.showscores.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    GradeRecordMapper gradeRecordMapper;

    @Autowired
    RecordMapper recordMapper;

    @Override
    public Page<Record> getPage(PageVO pageVO) {
        Page<Record> page = pageVO.getPage();
        return page(page);
    }

    @Override
    public Boolean del(Long id) {
        Record record = recordMapper.selectById(id);
        if (record!=null){
            gradeRecordMapper.delete(new QueryWrapper<GradeRecord>().eq("record_id",record.getId()));
            recordMapper.deleteById(record.getId());
            return true;
        } else
            return false;
    }

    @Override
    public Page<Record> getPageOrderByTime(PageVO pageVO) {
        Page<Record> page = pageVO.getPage();
        QueryWrapper<Record> wrapper = new QueryWrapper<Record>().orderByDesc("created_time");
        return page(page,wrapper);
    }


}
