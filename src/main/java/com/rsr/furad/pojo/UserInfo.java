package com.rsr.furad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 13375
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private Integer uid;
    private String name;
    private String username;
    private String password;
    private String salt;
    private Integer state;

    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}
