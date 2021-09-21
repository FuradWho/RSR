package com.rsr.furad.service;

import com.rsr.furad.pojo.UserInfo;

import java.util.List;

/**
 * @author 13375
 */
public interface UserInfoService {

    UserInfo findByUsername(String username);

    boolean registerData(String name,String password);

    UserInfo findByName(String name);
}
