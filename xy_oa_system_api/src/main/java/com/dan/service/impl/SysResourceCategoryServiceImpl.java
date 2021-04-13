package com.dan.service.impl;

import com.dan.mapper.SysResourceCategoryMapper;
import com.dan.model.SysResourceCategory;
import com.dan.model.SysResourceCategoryExample;
import com.dan.service.SysResourceCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * SysResourceCategoryService 实现类
 *
 * @author dan
 */
@Service
public class SysResourceCategoryServiceImpl implements SysResourceCategoryService {

    @Autowired
    private SysResourceCategoryMapper resourceCategoryMapper;

    @Override
    public int create(SysResourceCategory resourceCategory) {
        resourceCategory.setCreateTime(new Date());
        return resourceCategoryMapper.insert(resourceCategory);
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, SysResourceCategory resourceCategory) {
        resourceCategory.setId(id);
        return resourceCategoryMapper.updateByPrimaryKey(resourceCategory);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        SysResourceCategoryExample example = new SysResourceCategoryExample();
        example.createCriteria().andIdIn(ids);
        return resourceCategoryMapper.deleteByExample(example);
    }

    @Override
    public SysResourceCategory getItemById(Long id) {
        return resourceCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysResourceCategory> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return resourceCategoryMapper.selectByExample(new SysResourceCategoryExample());
    }
}
