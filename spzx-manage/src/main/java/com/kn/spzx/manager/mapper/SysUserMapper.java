package com.kn.spzx.manager.mapper;

import com.kn.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {
    //2.根据用户名 获取数据库表sys_user表
    SysUser selectUserInfoUserName(String userName);
}
