package com.example.cj_sever.messagealert;

/**
 * Created by cj-sever on 8/16/16.
 */
public class smsData {
    private String senderNo;
    private String smsBody;

    public smsData(String senderNo, String smsBody) {
        this.senderNo = senderNo;
        this.smsBody = smsBody;
    }

    public smsData() {

    }

    public String getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(String senderNo) {
        this.senderNo = senderNo;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }
}
