package com.dan.service;

import com.dan.model.SysDutyEmployeeRelation;

import java.util.List;

/**
 * 员工职务关联管理接口
 *
 * @author dan
 */
public interface SysDutyEmployeeRelationService {

    int create(SysDutyEmployeeRelation dutyEmployeeRelation);

    int update(Long id, SysDutyEmployeeRelation dutyEmployeeRelation);

    int delete(Long id);

    int batchDelete(List<Long> ids);

}
