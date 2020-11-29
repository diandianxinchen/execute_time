package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ALazyBoy
 * Date: 2020/11/28
 */
@Data
public class User {
    @NotBlank
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String realName;
}
