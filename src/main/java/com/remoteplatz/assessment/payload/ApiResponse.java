package com.remoteplatz.assessment.payload;

public class ApiResponse {
    private int eCode;
    private String eDesc;

    public ApiResponse() {
    }

    public ApiResponse(int eCode, String eDesc) {
        this.eCode = eCode;
        this.eDesc = eDesc;
    }

    public int geteCode() {
        return eCode;
    }

    public void seteCode(int eCode) {
        this.eCode = eCode;
    }

    public String geteDesc() {
        return eDesc;
    }

    public void seteDesc(String eDesc) {
        this.eDesc = eDesc;
    }
}
