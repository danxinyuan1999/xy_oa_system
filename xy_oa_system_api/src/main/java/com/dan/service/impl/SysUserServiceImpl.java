package com.dan.service.impl;

import com.dan.mapper.SysUserMapper;
import com.dan.model.SysUser;
import com.dan.model.SysUserExample;
import com.dan.service.RedisService;
import com.dan.service.SysUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * SysUserService实现类
 *
 * @author dan
 */
@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper userMapper;


    @Override
    public int createUser(SysUser user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int deleteUserById(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUserById(Long id, SysUser user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<SysUser> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.setOrderByClause("sort desc");
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            criteria.andNickNameLike("%" + keyword + "%");
        }
        return userMapper.selectByExample(sysUserExample);
    }

    @Override
    public List<SysUser> list() {
        return userMapper.selectByExample(new SysUserExample());
    }

    @Override
    public int updateUserStatusByIds(List<Long> ids, Integer status) {
        SysUser user = new SysUser();
        user.setStatus(status);
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdIn(ids);
        return userMapper.updateByExampleSelective(user, sysUserExample);
    }

    @Override
    public SysUser getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
