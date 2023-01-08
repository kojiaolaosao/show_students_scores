package com.showscores.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import com.showscores.mapper.GradeRecordMapper;
import com.showscores.mapper.RecordMapper;
import com.showscores.mapper.StudentMapper;
import com.showscores.service.GradeRecordService;
import com.showscores.service.StudentService;
import com.showscores.utils.ObjectConversionUtil;
import com.showscores.vo.AllScoreVO;
import com.showscores.vo.GradeRecordVO;
import com.showscores.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class GradeRecordServiceImpl extends ServiceImpl<GradeRecordMapper, GradeRecord> implements GradeRecordService {
    @Autowired
    GradeRecordMapper gradeRecordMapper;

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentService studentService;

    @Override
    public boolean addScoresList(RecordVO recordVO) {
        Record record = recordVO.getRecord();
        recordMapper.insert(record);

        recordVO.getRecords().forEach(r -> {
            GradeRecord gradeRecord = r.VOtoEntity();
            Student student = recordVO.getStudent(gradeRecord.getName());

            Student existStudent = studentService.existStudent(student);
            if (existStudent == null) {
                studentService.save(student);
                gradeRecord.setStudentId(student.getId());
            } else
                gradeRecord.setStudentId(existStudent.getId());
            gradeRecord.setRecordId(record.getId());
            gradeRecordMapper.insert(gradeRecord);
        });

//        System.out.println(recordVO);

        return true;
    }

    @Override
    public RecordVO getScoresListDefault() {
        Record record = recordMapper.selectOne(new QueryWrapper<Record>().orderByDesc("created_time").last("limit 1"));
        List<GradeRecord> gradeRecords = getGradeRecordListByRecordId(record.getId());

        return new RecordVO().buildRecordVO(record, gradeRecords);
    }

    @Override
    public List<Record> getScoresListByGradeClazz(RecordVO recordVO) {
        return recordMapper.selectList(new QueryWrapper<Record>()
                .eq("grade", recordVO.getGrade())
                .eq("clazz", recordVO.getClazz()));
    }

    @Override
    public RecordVO getScoreListByRecordId(Long recordId) {
        Record record = recordMapper.selectById(recordId);
        if (record == null) return null;
        List<GradeRecord> gradeRecords = getGradeRecordListByRecordId(record.getId());
        return new RecordVO().buildRecordVO(record, gradeRecords);
    }

    @Override
    public AllScoreVO getAllScore(Long studentId) {
        AllScoreVO allScoreVO = new AllScoreVO();

        List<GradeRecord> gradeRecords = gradeRecordMapper.selectList(new QueryWrapper<GradeRecord>().eq("student_id", studentId));

        allScoreVO.setAllScoreByList(gradeRecords);

        Student student = studentMapper.selectById(studentId);
        ArrayList<Record> records = new ArrayList<>();
        for (Long recordId : allScoreVO.getRecordId()) {
            Record record = recordMapper.selectById(recordId);
            records.add(record);
        }

        allScoreVO.setStudent(student);
        allScoreVO.setRecords(records);

        return allScoreVO;
    }


    public List<GradeRecord> getGradeRecordListByRecordId(Long recordId) {
        return gradeRecordMapper.selectList(new QueryWrapper<GradeRecord>().eq("record_id", recordId));
    }


}
