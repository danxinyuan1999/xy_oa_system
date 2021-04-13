package com.dan.controller;

import com.dan.api.ApiResult;
import com.dan.model.SysDutyEmployeeRelation;
import com.dan.service.SysDutyEmployeeRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工职务管理Api
 *
 * @author dan
 */
@Api("SysDutyEmployeeController")
@RestController
@RequestMapping("/duty/employee")
public class SysDutyEmployeeRelationController {

    @Autowired
    private SysDutyEmployeeRelationService dutyEmployeeRelationService;

    @ApiOperation("创建职务关联关系")
    @PostMapping("/create")
    public ApiResult create(@RequestBody SysDutyEmployeeRelation dutyEmployeeRelation) {
        ApiResult apiResult;
        int result = dutyEmployeeRelationService.create(dutyEmployeeRelation);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除职务关联关系")
    @GetMapping("/delete/{id}")
    public ApiResult delete(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = dutyEmployeeRelationService.delete(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("批量删除")
    @GetMapping("/batch/delete")
    public ApiResult batchDelete(@RequestBody List<Long> ids) {
        ApiResult apiResult;
        int result = dutyEmployeeRelationService.batchDelete(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }
}
