package com.dan.controller;

import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.model.SysDuty;
import com.dan.service.SysDutyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 职务管理Api
 *
 * @author dan
 */
@Api("SysDutyController")
@RestController
@RequestMapping("/duty")
public class SysDutyController {

    @Autowired
    private SysDutyService dutyService;

    @ApiOperation("新建职务")
    @PostMapping("/create")
    public ApiResult createDuty(@Validated @RequestBody SysDuty duty) {
        ApiResult apiResult;
        int result = dutyService.createDuty(duty);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("修改职务")
    @PostMapping("/update/{id}")
    public ApiResult updateDuty(@PathVariable("id") Long id, @RequestBody SysDuty duty) {
        ApiResult apiResult;
        int result = dutyService.updateDutyById(id, duty);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除职务")
    @GetMapping("/delete/{id}")
    public ApiResult deleteDuty(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = dutyService.deleteDuty(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("批量删除职务")
    @GetMapping("/batch/delete")
    public ApiResult batchDeleteDuty(@RequestParam("ids") List<Long> ids) {
        ApiResult apiResult;
        int result = dutyService.batchDeleteDuty(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("分页展示数据")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysDuty>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SysDuty> dutyList = dutyService.list(pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(dutyList));
    }
}
