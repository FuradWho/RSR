package com.rsr.furad.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rsr.furad.mapper.UserInfoMapper;
import com.rsr.furad.pojo.UserInfo;
import com.rsr.furad.service.UserInfoService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

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
        queryWrapper.eq("username", username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        return userInfo;
    }


    @Override
    public UserInfo findByName(String name) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        UserInfo userInfos = userInfoMapper.selectOne(queryWrapper);
        return userInfos;
    }

    @Override
    public boolean registerData(String name, String password) {

        ByteSource salt = ByteSource.Util.bytes(name);

        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        String newPs = new SimpleHash("MD5", password, salt, 2).toHex();

        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setPassword(newPs);
        userInfo.setSalt(name);
        userInfo.setState(1);
        userInfo.setUsername("vip");

        UserInfo userInfos = findByName(name);

        if (null == userInfos) {
            userInfoMapper.insert(userInfo);
            return true;
        }
        return false;
    }
}
