package com.showscores.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import com.showscores.mapper.RecordMapper;
import com.showscores.mapper.StudentMapper;
import com.showscores.service.RecordService;
import com.showscores.service.StudentService;
import com.showscores.vo.PageVO;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Override
    public Page<Record> getPage(PageVO pageVO) {
        Page<Record> page = pageVO.getPage();
        return page(page);
    }
}
