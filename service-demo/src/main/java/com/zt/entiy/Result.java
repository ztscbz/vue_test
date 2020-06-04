package com.zt.entiy;

/**
 * @ClassName: MyExcetionVo
 * @Description:
 * @author: ZT
 * @date: 2020/4/16 13:36
 */

public class Result<T> {

    private String msg = "success";

    private T data;

    public static final String SUCCESS = "200";// 成功

    private String status = SUCCESS;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void resultException(Exception exception) {
        this.status = "-200";
        this.msg = exception.getMessage();
    }
    public Result( String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public Result(T body) {
        data = body;
    }

    public Boolean isSuccess() {
        return SUCCESS.equals(status);
    }
}
