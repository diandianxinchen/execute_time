package com.example.demo;

import lombok.Data;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */
@Data
public class NameAndTime {
    private String name;
    private Long time;

    public NameAndTime(String name, Long time) {
        this.name = name;
        this.time = time;
    }
}
