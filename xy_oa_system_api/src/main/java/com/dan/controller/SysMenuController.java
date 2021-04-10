package com.dan.controller;

import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.dto.SysMenuNode;
import com.dan.model.SysMenu;
import com.dan.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台菜单管理 APi
 *
 * @author dan
 */
@Api("SysMenuController")
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @ApiOperation("新建菜单")
    @PostMapping("/create")
    public ApiResult createMenu(@RequestBody SysMenu menu) {
        ApiResult apiResult;
        int result = menuService.createMenu(menu);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("修改菜单")
    @PostMapping("/update/{id}")
    public ApiResult updateMenu(@PathVariable("id") Long id, @RequestBody SysMenu menu) {
        ApiResult apiResult;
        int result = menuService.updateMenu(id, menu);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除菜单")
    @GetMapping("/delete/{id}")
    public ApiResult deleteMenu(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = menuService.deleteMenu(id);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("批量删除菜单")
    @GetMapping("/batch/delete")
    public ApiResult<Integer> batchDeleteMenu(@RequestParam("ids") List<Long> ids) {
        ApiResult apiResult;
        int result = menuService.batchDelete(ids);
        if (result > 0) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("树形数据")
    @GetMapping("/treeList")
    public ApiResult<List<SysMenuNode>> treeList() {
        List<SysMenuNode> treeList = menuService.treeList();
        return ApiResult.success(treeList);
    }

    @ApiOperation("菜单数据分页展示")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysMenu>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SysMenu> menuList = menuService.list(pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(menuList));
    }

    @ApiOperation("获取菜单详情")
    @GetMapping("/detail/{id}")
    public ApiResult<SysMenu> menuDetail(@PathVariable("id") Long id) {
        SysMenu menu = menuService.getMenuById(id);
        return ApiResult.success(menu);
    }
}
