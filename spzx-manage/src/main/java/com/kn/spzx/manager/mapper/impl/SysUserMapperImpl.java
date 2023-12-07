package com.kn.spzx.manager.mapper.impl;

import com.kn.spzx.manager.mapper.SysUserMapper;
import com.kn.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserMapperImpl implements SysUserMapper {
    @Override
    public SysUser selectUserInfoUserName(String userName) {
        return null;
    }
}
