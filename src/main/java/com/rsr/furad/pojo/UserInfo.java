package com.rsr.furad.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 13375
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("user_info")
public class UserInfo implements Serializable {

    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;
    private String name;
    private String username;
    private String password;
    private String salt;
    private Integer state;
}
