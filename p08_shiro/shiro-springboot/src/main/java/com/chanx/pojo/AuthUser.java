package com.chanx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {

    private Integer id;
    private String name;
    private String pwd;
    private String perms;
}
