package com.showscores.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: graduation_project
 * @description: Result
 * @author: Mr.qi
 * @create: 2022-02-19 19:58
 **/
@Data
public class Result<T> implements Serializable {
    private int code;
    private Object data;
    private String msg;

    public static <T> Result<T> res(int code, String msg, T data){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> succ(T data){
        return res(200, "操作成功", data);
    }
    public static <T> Result<T> succ(int code,String msg, T data){
        return res(code, msg, data);
    }

    public static <T> Result<T> fail(int code,String msg, T data){
        return res(code, msg, data);
    }
    public static <T> Result<T> fail(String msg, T data){return res(400, msg, data);}
    public static <T> Result<T> fail(int code,String msg){return res(code, msg, null);}
    public static <T> Result<T> fail(String msg){return res(400, msg, null);}
    public static <T> Result<T> fail(){return res(400, "操作失败", null);}
}
