package com.dan.api;


/**
 * 错误码接口
 *
 * @author dan
 */
public interface IErrorCode {
    /**
     * 获取操作码
     *
     * @return 操作码
     */
    long getCode();

    /**
     * 获取信息
     *
     * @return 信息
     */
    String getMessage();
}
