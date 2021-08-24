package com.rsr.furad.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rsr.furad.mapper.UserInfoMapper;
import com.rsr.furad.pojo.UserInfo;
import com.rsr.furad.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

/**
 * @author 13375
 */

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByUsername(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        return userInfo;
    }
}
