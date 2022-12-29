package com.showscores.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Record;
import com.showscores.vo.AllScoreVO;
import com.showscores.vo.RecordVO;

import java.util.List;

public interface GradeRecordService extends IService<GradeRecord> {

    boolean addScoresList(RecordVO recordVO);

    public RecordVO getScoresListDefault();
    public  List<Record> getScoresListByGradeClazz(RecordVO recordVO);

    public RecordVO getScoreListByRecordId(Long recordId);

    public AllScoreVO getAllScore(Long studentId);
}
