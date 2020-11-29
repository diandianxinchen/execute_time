package com.example.demo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author ALazyBoy
 * Date: 2020/11/29
 */

@Data
public class TimeModel {
    private String name;
    private long total;
    private List<NameAndTime> ioList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====================\n");
        sb.append("交易一共耗时" + total + " ms \n");
        sb.append("===数据库IO==========\n");
        for (NameAndTime nameAndTime : ioList) {
            sb.append(String.format("%-20s : %-10d ms \n", nameAndTime.getName(), nameAndTime.getTime()));
        }
        return sb.toString();
    }
}
