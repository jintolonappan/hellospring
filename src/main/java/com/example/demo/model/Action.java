package com.example.demo.model;

import java.util.Calendar;
import java.util.UUID;


public class Action {

    private String deviceId = "";
    private String sessionId = UUID.randomUUID().toString();
    private Calendar timestamp = Calendar.getInstance();
    private String actionDetected = "unkn";
    private boolean actionConfirmed = false;
    private boolean actionInserted = false;

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public Calendar getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }
    public String getActionDetected() {
        return actionDetected;
    }
    public void setActionDetected(String actionDetected) {
        this.actionDetected = actionDetected;
    }
    public boolean isActionConfirmed() {
        return actionConfirmed;
    }
    public void setActionConfirmed(boolean actionConfirmed) {
        this.actionConfirmed = actionConfirmed;
    }
    public boolean isActionInserted() {
        return actionInserted;
    }
    public void setActionInserted(boolean actionInserted) {
        this.actionInserted = actionInserted;
    }
}
