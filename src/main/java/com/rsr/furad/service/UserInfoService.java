package com.rsr.furad.service;

import com.rsr.furad.pojo.UserInfo;

/**
 * @author 13375
 */
public interface UserInfoService {

    UserInfo findByUsername(String username);
}
