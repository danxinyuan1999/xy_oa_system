package com.dan.service;

import com.dan.model.SysDuty;

import java.util.List;

/**
 * 职务管理类
 *
 * @author dan
 */
public interface SysDutyService {

    /**
     * 创建职务
     *
     * @param duty 职务详情
     * @return 0 1
     */
    int createDuty(SysDuty duty);

    /**
     * 更新职务信息
     *
     * @param id   主键
     * @param duty 职务详情
     * @return 0 1
     */
    int updateDutyById(Long id, SysDuty duty);

    /**
     * 删除职务信息
     *
     * @param id 主键
     * @return 0 1
     */
    int deleteDuty(Long id);

    /**
     * 批量删除职务
     *
     * @param ids 主键
     * @return 0 1
     */
    int batchDeleteDuty(List<Long> ids);

    /**
     * 分页职务数据
     *
     * @param pageNum
     * @param pageSize
     * @return 分页职务详情
     */
    List<SysDuty> list(Integer pageNum, Integer pageSize);

}
