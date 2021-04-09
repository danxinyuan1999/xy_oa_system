package com.dan.service;

import com.dan.model.SysResource;

import java.util.List;

/**
 * 资源管理服务接口
 *
 * @author dan
 */
public interface SysResourceService {

    /**
     * 新建资源
     *
     * @param resource 资源详情
     * @return 0 1
     */
    int createResource(SysResource resource);

    /**
     * 删除资源
     *
     * @param id 主键
     * @return 0 1
     */
    int deleteResource(Long id);

    /**
     * 更新资源信息
     *
     * @param id       主键
     * @param resource 资源详情
     * @return 0 1
     */
    int updateResourceById(Long id, SysResource resource);

    /**
     * 批量删除资源
     *
     * @param ids 主键
     * @return 0 1
     */
    int batchDeleteResource(List<Long> ids);

    /**
     * 分页展示页面详情
     *
     * @param keyword  资源名称
     * @param pageNum  当前页
     * @param pageSize 分页数据大小
     * @return 资源详情
     */
    List<SysResource> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取全部资源详情信息
     *
     * @return 资源详情
     */
    List<SysResource> list();
}
