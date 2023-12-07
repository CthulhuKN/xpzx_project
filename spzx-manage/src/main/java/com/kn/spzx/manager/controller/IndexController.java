package com.kn.spzx.manager.controller;

import com.kn.spzx.manager.service.SysUserService;
import com.kn.spzx.model.dto.system.LoginDto;
import com.kn.spzx.model.vo.common.Result;
import com.kn.spzx.model.vo.common.ResultCodeEnum;
import com.kn.spzx.model.vo.system.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {
    @Autowired
    private SysUserService sysUserService;

    //用户登录
    @Operation(summary = "登录接口")
    @PostMapping("login")
    public Result login(@RequestBody LoginDto loginDto) {
        LoginVo loginVo = sysUserService.login(loginDto);
        return Result.build(loginVo, ResultCodeEnum.SUCCESS);
    }

}
