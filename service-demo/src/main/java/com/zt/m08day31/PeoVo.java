package com.zt.m08day31;

import lombok.Data;

import java.util.Date;

/**
 * @author: ZT
 * @date: 2020/9/1 15:22
 */
@Data
public class PeoVo {

    private Long id;
    private Short type;
    private Short code;
    private Date date;

    public PeoVo(Long id, Short type, Short code) {
        this.id = id;
        this.type = type;
        this.code = code;
    }

    public PeoVo() {
    }
}
