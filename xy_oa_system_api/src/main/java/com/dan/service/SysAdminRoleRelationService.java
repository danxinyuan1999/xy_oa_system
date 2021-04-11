package com.dan.service;

import com.dan.model.SysAdminRoleRelation;

/**
 * 用户角色关联服务类
 *
 * @author dan
 */
public interface SysAdminRoleRelationService {

    /**
     * 创建关联关系
     *
     * @param adminRoleRelation 关联详情信息
     * @return 0 1
     */
    int createAdminRoleRelation(SysAdminRoleRelation adminRoleRelation);

    /**
     * 删除关联关系
     *
     * @param id 主键
     * @return 0 1
     */
    int deleteAdminRoleRelation(Long id);

    /**
     * 更新关联关系
     *
     * @param id                主键
     * @param adminRoleRelation 关联关系详情
     * @return 0 1
     */
    int updateAdminRoleRelation(Long id, SysAdminRoleRelation adminRoleRelation);

    // 用户对应角色信息展示

}
