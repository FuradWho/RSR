package com.rsr.furad.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {

    private Integer id;
    private String name;
    private String url;
    private String permission;
}
