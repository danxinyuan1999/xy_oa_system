package com.dan.service.impl;

import com.dan.mapper.SysAdminRoleRelationMapper;
import com.dan.model.SysAdminRoleRelation;
import com.dan.service.SysAdminRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SysAdminRoleRelationService实现类
 *
 * @author dan
 */
@Service
public class SysAdminRoleRelationServiceImpl implements SysAdminRoleRelationService {

    @Autowired
    private SysAdminRoleRelationMapper adminRoleRelationMapper;

    @Override
    public int createAdminRoleRelation(SysAdminRoleRelation adminRoleRelation) {
        return adminRoleRelationMapper.insert(adminRoleRelation);
    }

    @Override
    public int deleteAdminRoleRelation(Long id) {
        return adminRoleRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAdminRoleRelation(Long id, SysAdminRoleRelation adminRoleRelation) {
        adminRoleRelation.setId(id);
        return adminRoleRelationMapper.updateByPrimaryKey(adminRoleRelation);
    }
}
