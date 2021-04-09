package com.dan.service.impl;

import com.dan.mapper.SysDutyMapper;
import com.dan.model.SysDuty;
import com.dan.model.SysDutyExample;
import com.dan.service.SysDutyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职务管理服务类
 *
 * @author dan
 */
@Service
public class SysDutyServiceImpl implements SysDutyService {

    @Autowired
    private SysDutyMapper dutyMapper;

    @Override
    public int createDuty(SysDuty duty) {
        return dutyMapper.insert(duty);
    }

    @Override
    public int updateDutyById(Long id, SysDuty duty) {
        duty.setId(id);
        return dutyMapper.updateByPrimaryKey(duty);
    }

    @Override
    public int deleteDuty(Long id) {
        return dutyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDeleteDuty(List<Long> ids) {
        SysDutyExample sysDutyExample = new SysDutyExample();
        SysDutyExample.Criteria criteria = sysDutyExample.createCriteria();
        criteria.andIdIn(ids);
        return dutyMapper.deleteByExample(sysDutyExample);
    }

    @Override
    public List<SysDuty> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return dutyMapper.selectByExample(new SysDutyExample());
    }
}
