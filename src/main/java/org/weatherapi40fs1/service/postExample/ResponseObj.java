package org.weatherapi40fs1.service.postExample;

public class ResponseObj {
    private String responseField1;
    private String responseField2;

    public ResponseObj(String responseField1, String responseField2) {
        this.responseField1 = responseField1;
        this.responseField2 = responseField2;
    }

    public String getResponseField1() {
        return responseField1;
    }

    public void setResponseField1(String responseField1) {
        this.responseField1 = responseField1;
    }

    public String getResponseField2() {
        return responseField2;
    }

    public void setResponseField2(String responseField2) {
        this.responseField2 = responseField2;
    }
}
