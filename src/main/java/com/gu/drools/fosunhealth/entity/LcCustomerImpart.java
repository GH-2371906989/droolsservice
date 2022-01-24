package com.gu.drools.fosunhealth.entity;

public class LcCustomerImpart {
    /*
    * 告知
    * */
    //告知模板
    private String infromcode;
    //告知编码
    private String impartcode;
    //告知参数
    private String impartparammodle;

    public String getInfromcode() {
        return infromcode;
    }

    public void setInfromcode(String infromcode) {
        this.infromcode = infromcode;
    }

    public String getImpartcode() {
        return impartcode;
    }

    public void setImpartcode(String impartcode) {
        this.impartcode = impartcode;
    }

    public String getImpartparammodle() {
        return impartparammodle;
    }

    public void setImpartparammodle(String impartparammodle) {
        this.impartparammodle = impartparammodle;
    }
}
