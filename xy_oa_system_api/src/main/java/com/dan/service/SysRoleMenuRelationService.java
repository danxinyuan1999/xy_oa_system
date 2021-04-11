package com.dan.service;

import com.dan.model.SysRoleMenuRelation;

/**
 * 角色菜单关联管理服务
 *
 * @author dan
 */
public interface SysRoleMenuRelationService {

    int createRoleMenuRelation(SysRoleMenuRelation roleMenuRelation);

    int updateRoleMenuRelation(Long id, SysRoleMenuRelation roleMenuRelation);

    int deleteRoleMenuRelation(Long id);



}
