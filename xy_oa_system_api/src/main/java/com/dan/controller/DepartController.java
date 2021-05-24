package com.dan.controller;

import com.dan.api.ApiResult;
import com.dan.dto.DepartNode;
import com.dan.service.DepartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门服务Api
 *
 * @author dan
 */
@Api("SysDepartController")
@RestController
@RequestMapping("/depart")
public class SysDepartController {

    @Autowired
    private DepartService departService;

    @ApiOperation("树形数据")
    @GetMapping("/treeList")
    public ApiResult<List<DepartNode>> departmentTreeList() {
        List<DepartNode> treeList = departService.treeList();
        return ApiResult.success(treeList);
    }

}
