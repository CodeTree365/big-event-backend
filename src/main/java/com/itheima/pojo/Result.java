package com.itheima.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

//统一响应结果
@NoArgsConstructor
@Data
public class Result<T> {
    //业务状态码  0-成功  1-失败
    private Integer code;
    //提示信息
    private String message;
    //响应数据
    private T data;

    //带参数的构造函数
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //快速返回操作成功响应结果(带响应数据)
    @Contract("_ -> new")
    public static <E> @NotNull Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    //快速返回操作成功响应结果
    @Contract(" -> new")
    public static @NotNull Result<Void> success() {
        return new Result<>(0, "操作成功", null);
    }

    @Contract("_ -> new")
    public static @NotNull Result<Void> error(String message) {
        return new Result<>(1, message, null);
    }
}