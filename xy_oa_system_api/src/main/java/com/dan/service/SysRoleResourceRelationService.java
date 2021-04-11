package com.dan.service;

import com.dan.model.SysRoleResourceRelation;

/**
 * 角色资源管理服务
 *
 * @author dan
 */
public interface SysRoleResourceRelationService {

    /**
     * 创建角色资源关联关系
     * @param roleResourceRelation 关联关系详情
     * @return 0 1
     */
    int createRelation(SysRoleResourceRelation roleResourceRelation);

    /**
     * 删除角色资源关联关系
     *
     * @param id 主键
     * @return 0 1
     */
    int deleteRelation(Long id);

    /**
     * 更新角色资源关联关系
     *
     * @param id                   主键
     * @param roleResourceRelation 关联关系详情
     * @return 0 1
     */
    int updateRelation(Long id, SysRoleResourceRelation roleResourceRelation);

}
