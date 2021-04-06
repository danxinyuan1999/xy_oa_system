package com.dan.service;

import com.dan.model.SysUser;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author dan
 */
public interface SysUserService {

    /**
     * 添加用户
     *
     * @param user 用户详情
     * @return 0 1
     */
    int createUser(SysUser user);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 0 1
     */
    int deleteUserById(Long id);

    /**
     * 修改用户信息
     *
     * @param id   用户主键
     * @param user 用户详情
     * @return 0 1
     */
    int updateUserById(Long id, SysUser user);

    /**
     * 用户信息分页展示
     *
     * @param keyWord  用户姓名
     * @param pageNum  当前页
     * @param pageSize 页面大小
     * @return 用户信息
     */
    List<SysUser> list(String keyWord, Integer pageNum, Integer pageSize);

    /**
     * 全部用户信息
     *
     * @return 用户信息
     */
    List<SysUser> list();

    /**
     * 批量用户修改账号状态
     *
     * @param ids    用户主键
     * @param status 用户账号状态 0 激活 1 禁用
     * @return 0 1
     */
    int updateUserStatusByIds(List<Long> ids, Integer status);

    /**
     * 获取用户指定用户信息
     *
     * @param id 用户主键
     * @return 用户详情
     */
    SysUser getUserById(Long id);
}
