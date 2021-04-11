package com.dan.controller;

import com.dan.api.ApiResult;
import com.dan.model.SysRoleResourceRelation;
import com.dan.service.SysRoleResourceRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色资源关联管理Api
 *
 * @author dan
 */
@Api("SysRoleResourceRelationController")
@RestController
@RequestMapping("/role/resource")
public class SysRoleResourceRelationController {

    @Autowired
    private SysRoleResourceRelationService roleResourceRelationService;

    @ApiOperation("创建关联关系")
    @PostMapping("/create")
    public ApiResult create(@RequestBody SysRoleResourceRelation roleResourceRelation) {
        ApiResult apiResult;
        int result = roleResourceRelationService.createRelation(roleResourceRelation);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除关联关系")
    @GetMapping("/delete/{id}")
    public ApiResult delete(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = roleResourceRelationService.deleteRelation(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("更新关联关系")
    @PostMapping("/update/{id}")
    public ApiResult update(@PathVariable("id") Long id, @RequestBody SysRoleResourceRelation roleResourceRelation) {
        ApiResult apiResult;
        int result = roleResourceRelationService.updateRelation(id, roleResourceRelation);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }
}
