package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;

public class HistoryLccont {
    /*
    * 既往保单
     * */
    //理赔挂起标志
    private String claimflag;
    //挂起类型
    private String hanguptype;
    //既往险种
    private ArrayList<HistoryLcpol> historyLcpolList = new ArrayList<HistoryLcpol>();

    public String getClaimflag() {
        return claimflag;
    }

    public void setClaimflag(String claimflag) {
        this.claimflag = claimflag;
    }

    public String getHanguptype() {
        return hanguptype;
    }

    public void setHanguptype(String hanguptype) {
        this.hanguptype = hanguptype;
    }

    public ArrayList<HistoryLcpol> getHistoryLcpolList() {
        return historyLcpolList;
    }

    public void setHistoryLcpolList(ArrayList<HistoryLcpol> historyLcpolList) {
        this.historyLcpolList = historyLcpolList;
    }
}
