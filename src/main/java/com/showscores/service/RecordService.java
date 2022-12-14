package com.showscores.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import com.showscores.vo.PageVO;
import com.showscores.vo.RecordVO;

import java.util.List;

public interface RecordService extends IService<Record> {
    public Page<Record> getPage(PageVO pageVO);

    Boolean del(Long id);

    Page<Record> getPageOrderByTime(PageVO pageVO);
}
