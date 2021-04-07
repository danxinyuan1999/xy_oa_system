package com.dan.service.impl;

import com.dan.dto.SysDepartNode;
import com.dan.mapper.SysDepartMapper;
import com.dan.model.SysDepart;
import com.dan.model.SysDepartExample;
import com.dan.service.SysDepartService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SysDepartService实现类
 *
 * @author dan
 */
@Service
public class SysDepartServiceImpl implements SysDepartService {

    @Autowired
    private SysDepartMapper departMapper;

    @Override
    public int createDepart(SysDepart depart) {
        return departMapper.insert(depart);
    }

    @Override
    public int deleteDepartById(Long id) {
        return departMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteDepartByIds(List<Long> ids) {
        SysDepartExample sysDepartExample = new SysDepartExample();
        SysDepartExample.Criteria criteria = sysDepartExample.createCriteria();
        criteria.andIdIn(ids);
        return departMapper.deleteByExample(sysDepartExample);
    }

    @Override
    public int updateDepartById(Long id, SysDepart depart) {
        depart.setId(id);
        return departMapper.updateByPrimaryKey(depart);
    }

    @Override
    public List<SysDepart> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysDepartExample sysDepartExample = new SysDepartExample();
        sysDepartExample.setOrderByClause("sort desc");
        SysDepartExample.Criteria criteria = sysDepartExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNameLike("%" + keyword + "%");
        }
        return departMapper.selectByExample(sysDepartExample);
    }

    @Override
    public List<SysDepart> list() {
        return departMapper.selectByExample(new SysDepartExample());
    }

    @Override
    public List<SysDepartNode> treeList() {
        List<SysDepart> departList = list();
        List<SysDepartNode> result = departList.stream()
                .filter(depart -> depart.getParentId().equals(0L))
                .map(depart -> coverDepartNode(depart, departList)).collect(Collectors.toList());
        return result;
    }

    private SysDepartNode coverDepartNode(SysDepart depart, List<SysDepart> departList) {
        SysDepartNode node = new SysDepartNode();
        BeanUtils.copyProperties(depart, node);
        List<SysDepartNode> children = departList.stream()
                .filter(subDepart -> subDepart.getParentId().equals(depart.getId()))
                .map(subDepart -> coverDepartNode(subDepart, departList))
                .collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }


}
