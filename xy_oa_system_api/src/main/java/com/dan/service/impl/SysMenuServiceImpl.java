package com.dan.service.impl;

import com.dan.dto.SysMenuNode;
import com.dan.mapper.SysMenuMapper;
import com.dan.model.SysMenu;
import com.dan.model.SysMenuExample;
import com.dan.service.SysMenuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SysMenuService 实现类
 *
 * @author dan
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    @Override
    public int createMenu(SysMenu menu) {
        menu.setCreateTime(new Date());
        return menuMapper.insert(menu);
    }

    @Override
    public int deleteMenu(Long id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateMenu(Long id, SysMenu menu) {
        menu.setId(id);
        return menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        SysMenuExample sysMenuExample = new SysMenuExample();
        SysMenuExample.Criteria criteria = sysMenuExample.createCriteria();
        criteria.andIdIn(ids);
        return menuMapper.deleteByExample(sysMenuExample);
    }

    @Override
    public List<SysMenu> list() {
        return menuMapper.selectByExample(new SysMenuExample());
    }

    @Override
    public List<SysMenuNode> treeList() {
        List<SysMenu> menuList = list();
        List<SysMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> coverMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<SysMenu> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return list();
    }

    private SysMenuNode coverMenuNode(SysMenu menu, List<SysMenu> menuList) {
        SysMenuNode node = new SysMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<SysMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> coverMenuNode(subMenu, menuList))
                .collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    @Override
    public SysMenu getMenuById(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }
}
