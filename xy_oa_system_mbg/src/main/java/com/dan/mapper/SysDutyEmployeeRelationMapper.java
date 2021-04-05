package com.dan.mapper;

import com.dan.model.SysDutyEmployeeRelation;
import com.dan.model.SysDutyEmployeeRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDutyEmployeeRelationMapper {
    long countByExample(SysDutyEmployeeRelationExample example);

    int deleteByExample(SysDutyEmployeeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDutyEmployeeRelation record);

    int insertSelective(SysDutyEmployeeRelation record);

    List<SysDutyEmployeeRelation> selectByExample(SysDutyEmployeeRelationExample example);

    SysDutyEmployeeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDutyEmployeeRelation record, @Param("example") SysDutyEmployeeRelationExample example);

    int updateByExample(@Param("record") SysDutyEmployeeRelation record, @Param("example") SysDutyEmployeeRelationExample example);

    int updateByPrimaryKeySelective(SysDutyEmployeeRelation record);

    int updateByPrimaryKey(SysDutyEmployeeRelation record);
}