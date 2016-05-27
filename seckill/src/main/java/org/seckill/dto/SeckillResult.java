package org.seckill.dto;

/**
 * User: jennie
 * Date: 2016/5/27
 * Time: 16:12
 */
//所有Ajax请求返回类型，封装json结果
public class SeckillResult<T> {

    private Boolean success;

    private T data;

    private String error;

    public SeckillResult(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResult(Boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
