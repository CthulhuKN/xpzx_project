package com.kn.spzx.manager.service;

import com.kn.spzx.model.dto.system.LoginDto;
import com.kn.spzx.model.vo.system.LoginVo;

public interface SysUserService {
    //用户登录
    LoginVo login(LoginDto loginDto);
}
