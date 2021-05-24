package com.dan.mapper;

import com.dan.model.ResourceCategory;
import com.dan.model.ResourceCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceCategoryMapper {
    long countByExample(ResourceCategoryExample example);

    int deleteByExample(ResourceCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ResourceCategory record);

    int insertSelective(ResourceCategory record);

    List<ResourceCategory> selectByExample(ResourceCategoryExample example);

    ResourceCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ResourceCategory record, @Param("example") ResourceCategoryExample example);

    int updateByExample(@Param("record") ResourceCategory record, @Param("example") ResourceCategoryExample example);

    int updateByPrimaryKeySelective(ResourceCategory record);

    int updateByPrimaryKey(ResourceCategory record);
}