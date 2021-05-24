package com.dan.dao;

import com.dan.model.Resource;
import com.dan.model.Role;
import com.dan.model.UserRoleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UserRoleRelation> userRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<Role> getRoleList(@Param("userId") Long userId);

    /**
     * 获取用户所有可访问资源
     */
    List<Resource> getResourceList(@Param("userId") Long userId);

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getUserIdList(@Param("resourceId") Long resourceId);

}
