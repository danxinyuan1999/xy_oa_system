package com.dan.controller;

import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.model.SysResource;
import com.dan.service.SysResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源服务api
 *
 * @author dan
 */
@Api("SysResourceController")
@RestController
@RequestMapping("/resource")
public class SysResourceController {

    @Autowired
    private SysResourceService resourceService;

    @ApiOperation("创建后台资源")
    @PostMapping("/create")
    public ApiResult createResource(@Validated @RequestBody SysResource resource) {
        ApiResult apiResult;
        int result = resourceService.createResource(resource);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除资源")
    @GetMapping("/delete/{id}")
    public ApiResult deleteResource(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = resourceService.deleteResource(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("更新资源详情")
    @GetMapping("/update/{id}")
    public ApiResult updateResource(@PathVariable("id") Long id, @RequestBody SysResource resource) {
        ApiResult apiResult;
        int result = resourceService.updateResourceById(id, resource);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("批量删除资源信息")
    @GetMapping("/batch/delete")
    public ApiResult batchDelete(@RequestParam("ids") List<Long> ids) {
        ApiResult apiResult;
        int result = resourceService.batchDeleteResource(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("分页展示资源详情")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysResource>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SysResource> resourceList = resourceService.list(keyword, pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(resourceList));
    }

    @ApiOperation("展示所有数据")
    @GetMapping("/list/all")
    public ApiResult<List<SysResource>> listAll() {
        List<SysResource> resourceList = resourceService.list();
        return ApiResult.success(resourceList);
    }
}
