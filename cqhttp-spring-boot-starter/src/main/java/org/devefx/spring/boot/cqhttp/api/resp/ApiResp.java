package org.devefx.spring.boot.cqhttp.api.resp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.util.Arrays;

/**
 * Api 响应结果
 * 
 * <p>状态码说明：</p>
 * <p>0	同时 status 为 ok，表示操作成功</p>
 * <p>1	同时 status 为 async，表示操作已进入异步执行，具体结果未知</p>
 * <p>100	参数缺失或参数无效，通常是因为没有传入必要参数，某些接口中也可能因为参数明显无效（比如传入的 QQ 号小于等于 0，
 * 此时无需调用 酷Q 函数即可确定失败），此项和以下的 status 均为 failed</p>
 * <p>102	酷Q 函数返回的数据无效，一般是因为传入参数有效但没有权限，比如试图获取没有加入的群组的成员列表</p>
 * <p>103	操作失败，一般是因为用户权限不足，或文件系统异常、不符合预期</p>
 * <p>104	由于 酷Q 提供的凭证（Cookie 和 CSRF Token）失效导致请求 QQ 相关接口失败，可尝试清除 酷Q 缓存来解决</p>
 * <p>201	工作线程池未正确初始化（无法执行异步任务）</p>
 * @param <T>
 */
@Data
public class ApiResp<T> {
    /**
     * 状态
     */
    private Status status;
    /**
     * 状态码
     */
    @JsonProperty("retcode")
    private int code;
    /**
     * 接口响应的数据内容
     */
    private T data;

    public enum Status {
        /**
         * 表示操作成功，同时 {@link #code} （返回码）会等于 0，即 酷Q 函数返回了 0。
         */
        OK,
        /**
         * 表示请求已提交异步处理，此时 {@link #code} 为 1，具体成功或失败将无法获知。
         */
        ASYNC,
        /**
         * 表示操作失败，此时 {@link #code} 有两种情况：当大于 0 时，表示是 HTTP API 插件判断出的失败；小于 0 时，为调用 酷Q 函数的返回码
         */
        FAILED;

        @JsonCreator
        public static Status from(String name) {
            return Arrays.stream(values()).filter(it -> it.getValue().equals(name)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("invalid value: " + name));
        }

        @JsonValue
        public String getValue() {
            return name().toLowerCase();
        }
    }
}
