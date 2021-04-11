package com.dan.controller;

import com.dan.api.ApiResult;
import com.dan.model.SysAdminRoleRelation;
import com.dan.service.SysAdminRoleRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户角色关联APi
 *
 * @author dan
 */
@Api("SysAdminRoleRelationController")
@RestController
@RequestMapping("/admin/role/relate")
public class SysAdminRoleRelationController {

    @Autowired
    private SysAdminRoleRelationService adminRoleRelationService;

    @ApiOperation("创建员工角色关联")
    @PostMapping("/create")
    public ApiResult createAdminRoleRelation(@RequestBody SysAdminRoleRelation adminRoleRelation) {
        ApiResult apiResult;
        int result = adminRoleRelationService.createAdminRoleRelation(adminRoleRelation);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除关联关系")
    @GetMapping("/delete/{id}")
    public ApiResult deleteAdminRoleRelation(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = adminRoleRelationService.deleteAdminRoleRelation(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("更新指定关联关系")
    @GetMapping("/update/{id}")
    public ApiResult updateAdminRoleRelation(@PathVariable("id") Long id, SysAdminRoleRelation adminRoleRelation) {
        ApiResult apiResult;
        int result = adminRoleRelationService.updateAdminRoleRelation(id, adminRoleRelation);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }


}
