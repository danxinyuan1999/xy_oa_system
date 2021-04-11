package com.dan.controller;

import com.dan.api.ApiResult;
import com.dan.model.SysRoleMenuRelation;
import com.dan.service.SysRoleMenuRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色菜单关联Api
 *
 * @author dan
 */
@Api("SysRoleMenuRelationController")
@RestController
@RequestMapping("/role/menu")
public class SysRoleMenuRelationController {

    @Autowired
    private SysRoleMenuRelationService roleMenuRelationService;

    @ApiOperation("创建关联关系")
    @PostMapping("/create")
    public ApiResult create(@RequestBody SysRoleMenuRelation roleMenuRelation) {
        ApiResult apiResult;
        int result = roleMenuRelationService.createRoleMenuRelation(roleMenuRelation);
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
        int result = roleMenuRelationService.deleteRoleMenuRelation(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("更新关联关系")
    @PostMapping("/update/{id}")
    public ApiResult update(@PathVariable("id") Long id, SysRoleMenuRelation roleMenuRelation) {
        ApiResult apiResult;
        int result = roleMenuRelationService.updateRoleMenuRelation(id, roleMenuRelation);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }


}
