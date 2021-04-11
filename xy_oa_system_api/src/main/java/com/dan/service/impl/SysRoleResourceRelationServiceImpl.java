package com.dan.service.impl;

import com.dan.mapper.SysRoleResourceRelationMapper;
import com.dan.model.SysRoleResourceRelation;
import com.dan.service.SysRoleResourceRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SysRoleResourceRelationService 服务实现类
 *
 * @author dan
 */
@Service
public class SysRoleResourceRelationServiceImpl implements SysRoleResourceRelationService {

    @Autowired
    private SysRoleResourceRelationMapper roleResourceRelationMapper;

    @Override
    public int createRelation(SysRoleResourceRelation roleResourceRelation) {
        return roleResourceRelationMapper.insert(roleResourceRelation);
    }

    @Override
    public int deleteRelation(Long id) {
        return roleResourceRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateRelation(Long id, SysRoleResourceRelation roleResourceRelation) {
        roleResourceRelation.setId(id);
        return roleResourceRelationMapper.updateByPrimaryKey(roleResourceRelation);
    }
}
