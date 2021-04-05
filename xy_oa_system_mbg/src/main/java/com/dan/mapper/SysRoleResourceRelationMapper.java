package com.dan.mapper;

import com.dan.model.SysRoleResourceRelation;
import com.dan.model.SysRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleResourceRelationMapper {
    long countByExample(SysRoleResourceRelationExample example);

    int deleteByExample(SysRoleResourceRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResourceRelation record);

    int insertSelective(SysRoleResourceRelation record);

    List<SysRoleResourceRelation> selectByExample(SysRoleResourceRelationExample example);

    SysRoleResourceRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleResourceRelation record, @Param("example") SysRoleResourceRelationExample example);

    int updateByExample(@Param("record") SysRoleResourceRelation record, @Param("example") SysRoleResourceRelationExample example);

    int updateByPrimaryKeySelective(SysRoleResourceRelation record);

    int updateByPrimaryKey(SysRoleResourceRelation record);
}