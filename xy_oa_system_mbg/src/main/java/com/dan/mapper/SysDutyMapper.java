package com.dan.mapper;

import com.dan.model.SysDuty;
import com.dan.model.SysDutyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDutyMapper {
    long countByExample(SysDutyExample example);

    int deleteByExample(SysDutyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDuty record);

    int insertSelective(SysDuty record);

    List<SysDuty> selectByExample(SysDutyExample example);

    SysDuty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDuty record, @Param("example") SysDutyExample example);

    int updateByExample(@Param("record") SysDuty record, @Param("example") SysDutyExample example);

    int updateByPrimaryKeySelective(SysDuty record);

    int updateByPrimaryKey(SysDuty record);
}