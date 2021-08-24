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
public class SysRole {
    private Integer id;
    private String role;
    private String description;
    private String available = "FALSE";
}
