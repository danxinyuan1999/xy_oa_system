package com.dan.service;

import com.dan.model.SysRole;

import java.util.List;

/**
 * 角色管理
 *
 * @author dan
 */
public interface SysRoleService {

    /**
     * 创建角色
     *
     * @param role 角色详情
     * @return 0 1
     */
    int createRole(SysRole role);

    /**
     * 删除角色
     *
     * @param id 角色主键
     * @return 0 1
     */
    int deleteRoleById(Long id);

    /**
     * 批量删除角色
     *
     * @param ids 主键
     * @return 0 1
     */
    int batchDeleteRole(List<Long> ids);

    /**
     * 更新角色信息
     *
     * @param id   主键
     * @param role 角色详情
     * @return 0 1
     */
    int updateRoleById(Long id, SysRole role);

    /**
     * 分页查询角色信息
     *
     * @param keyword  角色名字
     * @param pageNum  当前页
     * @param pageSize 分页大小
     * @return 分页查询信息
     */
    List<SysRole> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取全部角色信息
     *
     * @return 全部角色信息
     */
    List<SysRole> list();

}
