package com.example.db03_ship_20221201.result;

import java.io.Serializable;

public class ResultInfo implements Serializable {

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    private String STATUS;
    private Object data;
    private String MESSAGE = "";

    private ResultInfo() {
        this.STATUS = "SUCCESS";
    }

    private ResultInfo(String status, String message) {
        this.STATUS = status;
        this.MESSAGE = message;
    }

    private ResultInfo(String status) {
        this.STATUS = status;
    }
    private ResultInfo(String status, Object data) {
        this.STATUS = status;
        this.data = data;
    }

    public static ResultInfo success() {
        return new ResultInfo();
    }

    public static ResultInfo success(Object data) {
        return new ResultInfo("SUCCESS", data);
    }

    public static ResultInfo fail(String message) {
        return new ResultInfo("FAIL", message);
    }

    public static ResultInfo loginFail() {
        return new ResultInfo("LOGIN_FAIL", "");
    }

    public static ResultInfo error(String message) {
        return new ResultInfo("ERROR", "");
    }
}
