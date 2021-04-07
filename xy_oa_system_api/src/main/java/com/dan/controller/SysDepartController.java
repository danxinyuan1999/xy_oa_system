package com.dan.controller;

import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.dto.SysDepartNode;
import com.dan.model.SysDepart;
import com.dan.service.SysDepartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理 api
 *
 * @author dan
 */
@Api(tags = "SysDepartController")
@RestController
@RequestMapping("/depart")
public class SysDepartController {

    @Autowired
    private SysDepartService departService;
    private ApiResult apiResult;

    @ApiOperation("创建部门")
    @PostMapping("/create")
    public ApiResult createDepart(@Validated @RequestBody SysDepart depart) {
        int result = departService.createDepart(depart);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed("创建部门失败");
        }
        return apiResult;
    }

    @ApiOperation("删除指定部门")
    @GetMapping("/delete/{id}")
    public ApiResult deleteDepart(@PathVariable("id") Long id) {
        int result = departService.deleteDepartById(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除指定部门")
    @GetMapping("/batchDelete/{id}")
    public ApiResult batchDeleteDepart(@RequestParam("ids") List<Long> ids) {
        int result = departService.deleteDepartByIds(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除指定部门")
    @GetMapping("/update/{id}")
    public ApiResult updateDepart(@PathVariable("id") Long id, @RequestBody SysDepart depart) {
        int result = departService.updateDepartById(id, depart);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("分页展示数据")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysDepart>> list(String keyword, Integer pageNum, Integer pageSize) {
        List<SysDepart> departList = departService.list(keyword, pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(departList));
    }

    @ApiOperation("展示所有数据")
    @GetMapping("/listAll")
    public ApiResult<List<SysDepart>> listAll() {
        List<SysDepart> departList = departService.list();
        return ApiResult.success(departList);
    }

    @ApiOperation("部门树形数据")
    @GetMapping("/treeList")
    public ApiResult<List<SysDepartNode>> treeDate() {
        List<SysDepartNode> treeList = departService.treeList();
        return ApiResult.success(treeList);
    }
}
