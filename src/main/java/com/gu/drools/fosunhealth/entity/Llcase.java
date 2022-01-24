package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;
import java.util.Date;

public class Llcase {
    /*
    * 理赔案件
    * */
    //案件状态
    private String rgtstate;
    //结案日期
    private Date endCaseDate;
    //受理状态
    private String missionState;
    //赔付明细列表
    private ArrayList<Llclaimdetail> llclaimdetailList = new ArrayList<Llclaimdetail>();

    public String getRgtstate() {
        return rgtstate;
    }

    public void setRgtstate(String rgtstate) {
        this.rgtstate = rgtstate;
    }

    public Date getEndCaseDate() {
        return endCaseDate;
    }

    public void setEndCaseDate(Date endCaseDate) {
        this.endCaseDate = endCaseDate;
    }

    public String getMissionState() {
        return missionState;
    }

    public void setMissionState(String missionState) {
        this.missionState = missionState;
    }

    public ArrayList<Llclaimdetail> getLlclaimdetailList() {
        return llclaimdetailList;
    }

    public void setLlclaimdetailList(ArrayList<Llclaimdetail> llclaimdetailList) {
        this.llclaimdetailList = llclaimdetailList;
    }
}
