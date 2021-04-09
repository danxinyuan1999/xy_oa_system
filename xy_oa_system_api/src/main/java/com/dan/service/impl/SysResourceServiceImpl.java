package com.dan.service.impl;

import com.dan.mapper.SysResourceMapper;
import com.dan.model.SysResource;
import com.dan.model.SysResourceExample;
import com.dan.service.SysResourceService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 资源管理服务实现类
 *
 * @author dan
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper resourceMapper;


    @Override
    public int createResource(SysResource resource) {
        resource.setCreateTime(new Date());
        return resourceMapper.insert(resource);
    }

    @Override
    public int deleteResource(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateResourceById(Long id, SysResource resource) {
        resource.setId(id);
        return resourceMapper.updateByPrimaryKey(resource);
    }

    @Override
    public int batchDeleteResource(List<Long> ids) {
        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria criteria = sysResourceExample.createCriteria();
        criteria.andIdIn(ids);
        return resourceMapper.deleteByExample(sysResourceExample);
    }

    @Override
    public List<SysResource> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria criteria = sysResourceExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return resourceMapper.selectByExample(sysResourceExample);
    }

    @Override
    public List<SysResource> list() {
        return resourceMapper.selectByExample(new SysResourceExample());
    }
}
