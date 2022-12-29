package com.showscores.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import com.showscores.vo.PageVO;

public interface RecordService extends IService<Record> {
    public Page<Record> getPage(PageVO pageVO);
}
