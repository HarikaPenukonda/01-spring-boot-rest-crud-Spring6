package com.luv2code.demo.rest;

public class StudentErrorResponse {

    private int status;

    private int message;

    private int timeStamp;

    public StudentErrorResponse() {

    }

    public StudentErrorResponse(int status, int message, int timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }
}
