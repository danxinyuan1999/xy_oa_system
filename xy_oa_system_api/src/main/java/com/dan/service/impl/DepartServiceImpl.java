package com.dan.service.impl;

import com.dan.dto.SysDepartNode;
import com.dan.service.SysDepartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SysDepartService 实现类
 *
 * @author dan
 */
@Service
public class SysDepartServiceImpl implements SysDepartService {

    @Autowired
    private SysDepartMapper departMapper;

    @Override
    public List<SysDepartNode> treeList() {
        List<SysDepart> departList = listAll();
        return departList.stream()
                .filter(depart -> depart.getParentId().equals(0L))
                .map(depart -> covertDepartNode(depart, departList))
                .collect(Collectors.toList());
    }

    private List<SysDepart> listAll() {
        return departMapper.selectByExample(new SysDepartExample());
    }

    private SysDepartNode covertDepartNode(SysDepart depart, List<SysDepart> departList) {
        SysDepartNode node = new SysDepartNode();
        BeanUtils.copyProperties(depart, node);
        List<SysDepartNode> children = departList.stream()
                .filter(subDepart -> subDepart.getParentId().equals(depart.getId()))
                .map(subDepart -> covertDepartNode(subDepart, departList))
                .collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

}
