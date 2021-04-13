package com.dan.controller;

import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.model.SysResourceCategory;
import com.dan.service.SysResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源类别管理Api
 *
 * @author dan
 */
@Api("SysResourceCategoryController")
@RestController
@RequestMapping("/resource/category")
public class SysResourceCategoryController {

    @Autowired
    private SysResourceCategoryService resourceCategoryService;

    @ApiOperation("新建资源类别")
    @PostMapping("/create")
    public ApiResult create(@RequestBody SysResourceCategory resourceCategory) {
        ApiResult apiResult;
        int result = resourceCategoryService.create(resourceCategory);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除资源类别")
    @GetMapping("/delete/{id}")
    public ApiResult delete(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = resourceCategoryService.delete(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("批量删除资源类别")
    @GetMapping("/batch/delete")
    public ApiResult batchDelete(@RequestBody List<Long> ids) {
        ApiResult apiResult;
        int result = resourceCategoryService.batchDelete(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;

    }


    @ApiOperation("更新资源类别信息")
    @PostMapping("/update/{id}")
    public ApiResult update(@PathVariable("id") Long id, @RequestBody SysResourceCategory resourceCategory) {
        ApiResult apiResult;
        int result = resourceCategoryService.update(id, resourceCategory);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("获取指定资源类别信息")
    @GetMapping("/item/{id}")
    public ApiResult<SysResourceCategory> itemDetail(@PathVariable("id") Long id) {
        SysResourceCategory item = resourceCategoryService.getItemById(id);
        return ApiResult.success(item);
    }

    @ApiOperation("分页展示资源类别信息")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysResourceCategory>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SysResourceCategory> dataList = resourceCategoryService.list(pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(dataList));
    }
}
