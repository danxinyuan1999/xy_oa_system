package com.dan.service;

import com.dan.model.SysResourceCategory;

import java.util.List;

/**
 * 资源类别管理服务
 *
 * @author dan
 */
public interface SysResourceCategoryService {

    /**
     * 创建资源种类
     *
     * @param resourceCategory 资源种类
     * @return 0 1
     */
    int create(SysResourceCategory resourceCategory);

    /**
     * 删除单条记录
     *
     * @param id 待删除主键
     * @return 0 1
     */
    int delete(Long id);

    /**
     * 批量删除
     *
     * @param ids 待删除主键
     * @return 0 1
     */
    int batchDelete(List<Long> ids);

    /**
     * 更新资源信息
     *
     * @param id               主键
     * @param resourceCategory 资源类别信息
     * @return 0 1
     */
    int update(Long id, SysResourceCategory resourceCategory);

    /**
     * 获取指定资源类别信息
     *
     * @param id 主键
     * @return 资源类别信息
     */
    SysResourceCategory getItemById(Long id);

    /**
     * @param pageNum  当前页
     * @param pageSize 页大小
     * @return
     */
    List<SysResourceCategory> list(Integer pageNum, Integer pageSize);
}
