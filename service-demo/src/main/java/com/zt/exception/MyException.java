
package com.zt.exception;

import com.alibaba.fastjson.JSON;
import com.zt.entiy.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName: MyException
 * @Description:
 * @author: ZT
 * @date: 2020/4/16 13:35
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class MyException implements ResponseBodyAdvice {

    @ExceptionHandler(Exception.class)
    public Result<?> myException(Exception e){
        log.info("###全局捕获异常###,error:{}",e.getMessage());
        Result<Object> result = new Result<>(null);
        result.resultException(e);
        return result;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        String name = methodParameter.getMethod().getName();
        // 不过滤掉swagger
        if("uiConfiguration".equals(name)) return false;
        if("swaggerResources".equals(name)) return false;
        if("getDocumentation".equals(name)) return false;
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse response) {
        String clazz = methodParameter.getParameterType().getName();
        String url = serverHttpRequest.getURI().getPath();
        if (url.startsWith("/actuator")) {
            return body;
        } else if (clazz.contains("Result")) {
            return body;
        } else {
            Result result;
            if (clazz.contains("String")) {
                result = new Result();
                result.setData(body);
                return JSON.toJSONString(result);
            } else {
                result = new Result();
                result.setData(body);
                return result;
            }
        }
    }
}
