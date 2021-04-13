package com.dan.service.impl;

import com.dan.mapper.SysDutyEmployeeRelationMapper;
import com.dan.model.SysDutyEmployeeRelation;
import com.dan.model.SysDutyEmployeeRelationExample;
import com.dan.service.SysDutyEmployeeRelationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SysDutyEmployeeRelationService 实现类
 *
 * @author dan
 */
@Service
public class SysDutyEmployeeRelationServiceImpl implements SysDutyEmployeeRelationService {

    @Autowired
    private SysDutyEmployeeRelationMapper dutyEmployeeRelationMapper;

    @Override
    public int create(SysDutyEmployeeRelation dutyEmployeeRelation) {
        return dutyEmployeeRelationMapper.insert(dutyEmployeeRelation);
    }

    @Override
    public int update(Long id, SysDutyEmployeeRelation dutyEmployeeRelation) {
        dutyEmployeeRelation.setDutyId(id);
        return dutyEmployeeRelationMapper.updateByPrimaryKey(dutyEmployeeRelation);
    }

    @Override
    public int delete(Long id) {
        return dutyEmployeeRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        SysDutyEmployeeRelationExample example = new SysDutyEmployeeRelationExample();
        example.createCriteria().andIdIn(ids);
        return dutyEmployeeRelationMapper.deleteByExample(example);
    }

}
