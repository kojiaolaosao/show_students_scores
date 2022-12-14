package com.showscores.vo;

import cn.hutool.core.util.ReflectUtil;
import com.showscores.entity.BaseEntity;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import lombok.Data;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Data
public class AllScoreVO {
    private Student student;

    private List<Record> records;

    private List<Long> studentId;
    private List<Long> recordId;
    private List<Long> studentCode;
    private List<String> name;

    private List<Integer> totalScore;
    private List<Integer> languages;
    private List<Integer> maths;
    private List<Integer> englishes;
    private List<Integer> addition;
    private List<Integer> physicals;
    private List<Integer> history;
    private List<Integer> geography;
    private List<Integer> geographyReal;
    private List<Integer> politics;
    private List<Integer> politicsReal;
    private List<Integer> chemicals;
    private List<Integer> chemicalsReal;
    private List<Integer> biological;
    private List<Integer> biologicalReal;
    private List<Integer> classRank;
    private List<Integer> gradeRank;

    private List<LocalDateTime> createdTime;
    private List<LocalDateTime> updatedTime;

    private HashMap<String,Boolean> scoreFields;
    private List<String> scoreFieldZH;

    private HashMap<String ,String> fieldEN2ZH;

    public void setAllScoreByList(List<GradeRecord> gradeRecords){
        for (Field field : this.getClass().getDeclaredFields()) {
            try {

                ArrayList<Object> list = new ArrayList<>();
                if (field.getType()==List.class)
                    field.set(this,list);

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        HashMap<String, Boolean> hashMap = new HashMap<>();
        for (Field field : ReflectUtil.getFields(GradeRecord.class)) {
            if (field.getType()==Integer.class)
                hashMap.put(field.getName(),false);
        }
        scoreFields=hashMap;

        gradeRecords.forEach(g->{
            for (Field field : ReflectUtil.getFields(g.getClass())) {
                if (field.getName().equals("id")||field.getName().equals("status")) continue;
                field.setAccessible(true);
                try {
                    Field scoreField = this.getClass().getDeclaredField(field.getName());
                    List list = (List) scoreField.get(this);

                    if (field.getType()==Integer.class){
                        if ((Integer) field.get(g)!=0)
                            scoreFields.put(field.getName(),true);
                    }

                    list.add(field.get(g));
                    scoreField.set(this,list);

                } catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.setZH();
    }

    public void setZH(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name"           ,"??????"   );
        map.put("totalScore"     ,"??????"   );
        map.put("languages"      ,"??????"   );
        map.put("maths"          ,"??????"   );
        map.put("englishes"      ,"??????"   );
        map.put("addition"       ,"??????"   );
        map.put("physicals"      ,"??????"   );
        map.put("history"        ,"??????"   );
        map.put("geography"      ,"??????"   );
        map.put("geographyReal"  ,"??????"   );
        map.put("politics"       ,"??????"   );
        map.put("politicsReal"   ,"??????"   );
        map.put("chemicals"      ,"??????"   );
        map.put("chemicalsReal"  ,"??????"   );
        map.put("biological"     ,"??????"   );
        map.put("biologicalReal" ,"??????"    );
        map.put("classRank"      ,"????????????" );
        map.put("gradeRank"      ,"????????????" );

        this.scoreFields.forEach((k,v)->{
            if (v) this.scoreFieldZH.add(map.get(k));
        });
        this.fieldEN2ZH=map;
    }

}
