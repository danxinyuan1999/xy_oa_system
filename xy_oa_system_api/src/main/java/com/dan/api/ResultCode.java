package com.dan.api;


/**
 * 操作结果码
 *
 * @author dan
 */
public enum ResultCode implements IErrorCode {
    /**
     * code 200 成功
     * 500 操作失败
     * 404 参数校验失败
     * 401 未登录
     * 403 没有相关权限
     * code 操作编码
     * message 返回信息
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private final long code;
    private final String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
