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
import com.showscores.vo.AllScoreVO;
import com.showscores.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        recordVO.getRecords().forEach(r->{
            GradeRecord gradeRecord = r.VOtoEntity();
            Student student = recordVO.getStudent(gradeRecord.getName());

            Student existStudent = studentService.existStudent(student);
            if (existStudent==null){
                studentService.save(student);
                gradeRecord.setStudentId(student.getId());
            }else
                gradeRecord.setStudentId(existStudent.getId());
            gradeRecord.setRecordId(record.getId());
            gradeRecordMapper.insert(gradeRecord);
        });

//        System.out.println(recordVO);

        return true;
    }

    @Override
    public RecordVO getScoresListDefault(){
        Record record = recordMapper.selectOne(new QueryWrapper<Record>().orderByDesc("created_time").last("limit 1"));
        List<GradeRecord> gradeRecords = getGradeRecordListByRecordId(record.getId());

        return new RecordVO().buildRecordVO(record,gradeRecords);
    }

    @Override
    public  List<Record> getScoresListByGradeClazz(RecordVO recordVO) {
        return recordMapper.selectList(new QueryWrapper<Record>()
                .eq("grade", recordVO.getGrade())
                .eq("clazz", recordVO.getClazz()));
    }

    @Override
    public RecordVO getScoreListByRecordId(Long recordId){
        Record record = recordMapper.selectById(recordId);
        List<GradeRecord> gradeRecords = getGradeRecordListByRecordId(record.getId());

        return new RecordVO().buildRecordVO(record,gradeRecords);
    }

    @Override
    public AllScoreVO getAllScore(Long studentId) {
        Student student = studentMapper.selectById(studentId);
        Map<String, Object> map = getMap(new QueryWrapper<GradeRecord>()
                .select("GROUP_CONCAT(record_id) as recordIds",

                        "GROUP_CONCAT(total_score) as totalScore",
                        "GROUP_CONCAT(languages) as languages",
                        "GROUP_CONCAT(maths) as maths",
                        "GROUP_CONCAT(englishes) as englishes",
                        "GROUP_CONCAT(addition) as addition",
                        "GROUP_CONCAT(physicals) as physicals",
                        "GROUP_CONCAT(history) as history",
                        "GROUP_CONCAT(geography) as geography",
                        "GROUP_CONCAT(geography_real) as geographyReal",
                        "GROUP_CONCAT(politics) as politics",
                        "GROUP_CONCAT(politics_real) as politicsReal",
                        "GROUP_CONCAT(chemicals) as chemicals",
                        "GROUP_CONCAT(chemicals_real) as chemicalsReal",
                        "GROUP_CONCAT(biological) as biological",
                        "GROUP_CONCAT(biological_real) as biologicalReal",
                        "GROUP_CONCAT(class_rank) as classRank",
                        "GROUP_CONCAT(grade_rank) as gradeRank",
                        "GROUP_CONCAT(created_time) as createdTimes",
                        "GROUP_CONCAT(updated_time) as updatedTimes"
                )
                .eq("student_id", studentId)
        );
        map.put("student",student);
        String[] ids = map.get("recordIds").toString().split(",");
        ArrayList<Record> records = new ArrayList<Record>();
        for (String id : ids) {
            Record record = recordMapper.selectById(id);
            records.add(record);
        }
        map.put("records",records);
        System.out.println(map.toString());
        return null;
    }

    public List<GradeRecord> getGradeRecordListByRecordId(Long recordId){
        return gradeRecordMapper.selectList(new QueryWrapper<GradeRecord>().eq("record_id", recordId));
    }


}
