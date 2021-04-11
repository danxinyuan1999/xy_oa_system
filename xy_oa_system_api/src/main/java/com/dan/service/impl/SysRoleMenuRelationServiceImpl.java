package com.dan.service.impl;

import com.dan.mapper.SysRoleMenuRelationMapper;
import com.dan.model.SysRoleMenuRelation;
import com.dan.service.SysRoleMenuRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SysRoleMenuRelationService 实现类
 *
 * @author dan
 */
@Service
public class SysRoleMenuRelationServiceImpl implements SysRoleMenuRelationService {

    @Autowired
    private SysRoleMenuRelationMapper roleMenuRelationMapper;

    @Override
    public int createRoleMenuRelation(SysRoleMenuRelation roleMenuRelation) {
        return roleMenuRelationMapper.insert(roleMenuRelation);
    }

    @Override
    public int updateRoleMenuRelation(Long id, SysRoleMenuRelation roleMenuRelation) {
        roleMenuRelation.setId(id);
        return roleMenuRelationMapper.updateByPrimaryKey(roleMenuRelation);
    }

    @Override
    public int deleteRoleMenuRelation(Long id) {
        return roleMenuRelationMapper.deleteByPrimaryKey(id);
    }

}
