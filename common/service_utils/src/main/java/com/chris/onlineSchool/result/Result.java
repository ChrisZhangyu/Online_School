package com.chris.onlineSchool.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author chris
 * @date 2022/11/9
 * 统一返回结果
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    private int code;

    private String message;

    private T data;

    Result(@NotNull T data){
        this.data = data;
    }

    @SafeVarargs
    public static<T> Result<T> success(T... data){
        Result<T> okResult = new Result<>();
        if (data.length != 0){
            // 后续应该修改成List类型的数据, 先默认为第一个数据
            okResult.data = data[0];
        }
        okResult.message = "成功";
        okResult.code = 20000;
        return okResult;
    }


    public static<T> Result<T> fail(T... data){
        Result<T> failResult = new Result<>();
        if (data.length != 0){
            //  后续应该修改成List类型的数据, 先默认为第一个数据
            failResult.data = data[0];
        }
        failResult.message = "失败";
        failResult.code = 20001;
        return failResult;
    }


    public  Result<T> message(String message){
        this.message = message;
        return this;
    }

    public  Result<T> code(int code){
        this.code = code;
        return this;
    }


}
