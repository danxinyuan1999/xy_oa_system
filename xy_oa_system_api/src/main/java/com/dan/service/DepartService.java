package com.dan.service;

import com.dan.dto.SysDepartNode;

import java.util.List;

/**
 * 部门管理接口
 *
 * @author dan
 */
public interface SysDepartService {

    /**
     * 部门树形数据查询
     *
     * @return 部门树形数据
     */
    List<SysDepartNode> treeList();

}
