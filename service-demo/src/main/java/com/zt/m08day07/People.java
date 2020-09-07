package com.zt.m08day07;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @author: ZT
 * @date: 2020/8/21 13:17
 */
@Data
@Accessors(chain = true)
public class People {
    private boolean vaild;
    private Long day;
}
