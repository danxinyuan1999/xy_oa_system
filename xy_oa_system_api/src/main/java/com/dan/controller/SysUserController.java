package com.dan.controller;


import com.dan.api.ApiPage;
import com.dan.api.ApiResult;
import com.dan.model.SysUser;
import com.dan.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author dan
 */
@Api(tags = "SysUserController")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @ApiOperation("新增用户信息")
    @PostMapping("/create")
    public ApiResult create(@Validated @RequestBody SysUser user) {
        ApiResult apiResult;
        int result = userService.createUser(user);
        if (result == 1) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("删除用户")
    @GetMapping("/delete/{id}")
    public ApiResult delete(@PathVariable("id") Long id) {
        ApiResult apiResult;
        int result = userService.deleteUserById(id);
        if (result == 1) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("修改用户")
    @PostMapping("/update/{id}")
    public ApiResult update(@PathVariable("id") Long id, @Validated @RequestBody SysUser user) {
        ApiResult apiResult;
        int result = userService.updateUserById(id, user);
        if (result == 1) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }

    @ApiOperation("用户信息分页展示")
    @GetMapping("/list")
    public ApiResult<ApiPage<SysUser>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<SysUser> userList = userService.list(keyword, pageNum, pageSize);
        return ApiResult.success(ApiPage.restPage(userList));
    }

    @ApiOperation("展示所有用户信息")
    @GetMapping("/listALl")
    public ApiResult<List<SysUser>> listALl() {
        List<SysUser> userALllist = userService.list();
        return ApiResult.success(userALllist);
    }

    @ApiOperation("获取用户指定用户信息")
    @GetMapping("/getUserDetail/{id}")
    public ApiResult<SysUser> getUserDetail(@PathVariable("id") Long id) {
        SysUser user = userService.getUserById(id);
        return ApiResult.success(user);
    }

    @ApiOperation("批量用户修改账号状态")
    @PostMapping("/update/status")
    public ApiResult updateStaus(@RequestParam("ids") List<Long> ids, @RequestParam("status") Integer status) {
        ApiResult apiResult;
        int result = userService.updateUserStatusByIds(ids, status);
        if (result == 1) {
            apiResult = ApiResult.success(result);
        } else {
            apiResult = ApiResult.failed();
        }
        return apiResult;
    }
}
