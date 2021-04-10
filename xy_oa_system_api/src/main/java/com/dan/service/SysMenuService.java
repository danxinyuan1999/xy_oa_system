package com.dan.service;

import com.dan.dto.SysMenuNode;
import com.dan.model.SysMenu;

import java.util.List;

/**
 * 后台菜单管理服务
 *
 * @author dan
 */
public interface SysMenuService {

    int createMenu(SysMenu menu);

    int deleteMenu(Long id);

    int updateMenu(Long id, SysMenu menu);

    int batchDelete(List<Long> ids);

    List<SysMenu> list();

    List<SysMenuNode> treeList();

    List<SysMenu> list(Integer pageNum, Integer pageSize);

    SysMenu getMenuById(Long id);
}
