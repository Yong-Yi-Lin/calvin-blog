package com.example.pojo;


public class JsonResult {
    private boolean ok;//标识执行一个操作是否成功
    private Object data;//操作成功，且是一个查询操作，需要返回一些数据给前端

    @Override
    public String toString() {
        return "JsonResult{" +
                "ok=" + ok +
                ", data=" + data +
                '}';
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
