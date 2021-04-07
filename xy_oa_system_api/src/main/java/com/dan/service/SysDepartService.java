package com.dan.service;

import com.dan.dto.SysDepartNode;
import com.dan.model.SysDepart;

import java.util.List;

/**
 * 部门管理接口
 *
 * @author dan
 */
public interface SysDepartService {

    /**
     * 创建部门
     *
     * @param depart 部门详情
     * @return 0 1
     */
    int createDepart(SysDepart depart);

    /**
     * 删除指定部门
     *
     * @param id 主键
     * @return 0 1
     */
    int deleteDepartById(Long id);

    /**
     * 批量删除部门
     *
     * @param ids 主键
     * @return 0 1
     */
    int deleteDepartByIds(List<Long> ids);

    /**
     * 更新部门信息
     *
     * @param id     主键
     * @param depart 部门详情
     * @return 0 1
     */
    int updateDepartById(Long id, SysDepart depart);

    /**
     * 分页展示数据
     *
     * @param keyword  部门名称
     * @param pageNum  当前页
     * @param pageSize 分页大小
     * @return 部门数据详情
     */
    List<SysDepart> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取所有部门信息
     *
     * @return 部门数据详情
     */
    List<SysDepart> list();

    /**
     * 树状部门数据信息
     *
     * @return 树形部门组件
     */
    List<SysDepartNode> treeList();
}
