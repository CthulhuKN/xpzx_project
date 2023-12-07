package com.kn.spzx.manager.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson2.JSON;
import com.kn.spzx.manager.mapper.SysUserMapper;
import com.kn.spzx.manager.service.SysUserService;
import com.kn.spzx.model.dto.system.LoginDto;
import com.kn.spzx.model.entity.system.SysUser;
import com.kn.spzx.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    //用户登录
    @Override
    public LoginVo login(LoginDto loginDto) {
        //1.获取提交用户名，loginDto获取到
        String userName = loginDto.getUserName();
        //2.根据用户名 获取数据库表sys_user表
        SysUser sysUser = sysUserMapper.selectUserInfoUserName(userName);

        //3.如果根据用户名查询不到用户信息，用户名不存在，返回错误信息
        if (sysUser == null) {
            throw new RuntimeException("用户名不存在");
        }
        //4.查询到用户信息表示用户名存在，

        String database_password = sysUser.getPassword();
        //5.获取到输入密码。与数据库密码进行比较
        //将输入的密码进行加密再进行比较
        String input_password =
                DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        //6.密码比对不成功 返回错误信息
        if (!input_password.equals(database_password)) {
            throw new RuntimeException("密码不正确");
        }
        //7.密码正确 生成唯一标识
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        // 8.登陆成功用户信息放入到redis中去 设置过期时间
        //Object UserJson = JSON.toJSONString(sysUser);
        redisTemplate.opsForValue().
                set("user:login" + token, JSON.toJSONString(sysUser),
                        7,
                        TimeUnit.DAYS);
        //9.返回loginVo对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);


        return loginVo;
    }
}
