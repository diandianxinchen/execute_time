package com.example.demo.entity;

import com.example.demo.NameAndTime;
import lombok.Data;

import java.util.List;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */

@Data
public class ExecuteTime {
    private String name;
    private long totalTime;
    private long ioTime;
    private List<NameAndTime> ioList;
    private String ioDetail;
}
