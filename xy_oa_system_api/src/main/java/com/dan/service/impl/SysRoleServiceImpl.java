package com.dan.service.impl;

import com.dan.mapper.SysRoleMapper;
import com.dan.model.SysRole;
import com.dan.model.SysRoleExample;
import com.dan.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * SysRoleService实现类
 *
 * @author dan
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public int createRole(SysRole role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        return roleMapper.insert(role);
    }

    @Override
    public int deleteRoleById(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDeleteRole(List<Long> ids) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
        criteria.andIdIn(ids);
        return roleMapper.deleteByExample(sysRoleExample);
    }

    @Override
    public int updateRoleById(Long id, SysRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public List<SysRole> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return roleMapper.selectByExample(sysRoleExample);
    }

    @Override
    public List<SysRole> list() {
        return roleMapper.selectByExample(new SysRoleExample());
    }

}
