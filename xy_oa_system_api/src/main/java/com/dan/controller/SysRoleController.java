package com.dan.controller;

import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.model.SysRole;
import com.dan.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色服务 api
 *
 * @author dan
 */
@Api("SysRoleController")
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @ApiOperation("创建角色")
    @PostMapping("/create")
    public ApiResult createRole(@Validated @RequestBody SysRole role) {
        ApiResult apiResult;
        int result = roleService.createRole(role);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除角色")
    @GetMapping("/delete/{id}")
    public ApiResult delete(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = roleService.deleteRoleById(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("批量删除角色")
    @GetMapping("/delete/batch")
    public ApiResult delete(@RequestParam("ids") List<Long> ids) {
        ApiResult apiResult;
        int result = roleService.batchDeleteRole(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("更新角色信息")
    @GetMapping("/update/role/{id}")
    public ApiResult updateRole(@PathVariable("id") Long id, @RequestBody SysRole role) {
        ApiResult apiResult;
        int result = roleService.updateRoleById(id, role);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("分页展示角色信息")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysRole>> list(@RequestParam("keyword") String keyword,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SysRole> roleList = roleService.list(keyword, pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(roleList));
    }

    @ApiOperation("展示所有角色信息")
    @GetMapping("/list/all")
    public ApiResult<List<SysRole>> list() {
        List<SysRole> roleList = roleService.list();
        return ApiResult.success(roleList);
    }

}
