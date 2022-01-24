package com.gu.drools.fosunhealth.entity;

import java.util.ArrayList;
import java.util.Date;

public class Lcinsured {
        /*
        * 被保人
        * */
        //客户号
    private String insuredNo;
    //姓名
    private String name;
    //性别
    private String sex;
    //单位名称
    private String grpname;
    //公司电话
    private String companyPhone;
    //家庭电话
    private String homePhone;
    //手机号
    private String mobile;
    //通讯电话
    private String phone;
    //手机号2
    private String mobile2;
    //出生日期
    private Date birthday;
    //证件类型
    private String idType;
    //证件号码
    private String idNo;
    //职业类别
    private String occupationType;
    //职业代码
    private String occupationCode;
    //国籍
    private String nation;
    //重疾险基本保额
    private Double sumSeriousIllnessAmnt;
    //投保年龄
    private Integer age;
    //与主被保人关系
    private String relationtomaininsured;
    //BMI指数
    private Double BMI;
    //与投保人关系
    private String relationToAppnt;
    //家庭住址
    private String homeAddress;
    //通讯住址
    private String postalAddress;
    //县/区
    private String county;
    //县/区(家庭地址)
    private String homeCounty;
    //累计疾病身故保额
    private Double sumSicknessDeathAmnt;
    //累计重疾保额
    private Double sumDiseaseAmnt;
    //累计意外保额
    private Double sumAccifentAmnt;
    //税前年收入（万元）
    private Double pretaxget;
    //在职标志
    private String workState;
    //有非标准体核保记录标志
    private String uwflag;
    //政要类黑名单标志
    private String dignitariesBlackFlag;
    //重点关注客户标志
    private String focusOnCustomFlag;
    //有处理中的理赔案件标志
    private String hasClaimCaseFlag;
    //既往有理赔记录
    private String hasClaimFlag;
    //身高
    private Double stature;
    //体重
    private Double avoirdupois;
    //累计身故保额（航空意外险除外）
    private Double accumulatedDeathAmnt;
    //主被保人标志
    private String mainInsuredFlag;
    //是否已怀孕
    //怀孕周数
    //出生体重
    //险种列表
    private ArrayList<Lcpol> lcPolList = new ArrayList<Lcpol>();
    //受益人列表
    private ArrayList<Lcbnf> lcbnfList = new ArrayList<Lcbnf>();
    //既往保单列表
    private ArrayList<HistoryLccont> historyLccontList = new ArrayList<HistoryLccont>();
    //理赔案件列表
    private ArrayList<Llcase> llcaseList = new ArrayList<Llcase>();
    //告知列表
    private ArrayList<LcCustomerImpart> lcCustomerImpartList = new ArrayList<LcCustomerImpart>();

    public String getInsuredNo() {
        return insuredNo;
    }

    public void setInsuredNo(String insuredNo) {
        this.insuredNo = insuredNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrpname() {
        return grpname;
    }

    public void setGrpname(String grpname) {
        this.grpname = grpname;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Double getSumSeriousIllnessAmnt() {
        return sumSeriousIllnessAmnt;
    }

    public void setSumSeriousIllnessAmnt(Double sumSeriousIllnessAmnt) {
        this.sumSeriousIllnessAmnt = sumSeriousIllnessAmnt;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRelationtomaininsured() {
        return relationtomaininsured;
    }

    public void setRelationtomaininsured(String relationtomaininsured) {
        this.relationtomaininsured = relationtomaininsured;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public String getRelationToAppnt() {
        return relationToAppnt;
    }

    public void setRelationToAppnt(String relationToAppnt) {
        this.relationToAppnt = relationToAppnt;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = homeCounty;
    }

    public Double getSumSicknessDeathAmnt() {
        return sumSicknessDeathAmnt;
    }

    public void setSumSicknessDeathAmnt(Double sumSicknessDeathAmnt) {
        this.sumSicknessDeathAmnt = sumSicknessDeathAmnt;
    }

    public Double getSumDiseaseAmnt() {
        return sumDiseaseAmnt;
    }

    public void setSumDiseaseAmnt(Double sumDiseaseAmnt) {
        this.sumDiseaseAmnt = sumDiseaseAmnt;
    }

    public Double getSumAccifentAmnt() {
        return sumAccifentAmnt;
    }

    public void setSumAccifentAmnt(Double sumAccifentAmnt) {
        this.sumAccifentAmnt = sumAccifentAmnt;
    }

    public Double getPretaxget() {
        return pretaxget;
    }

    public void setPretaxget(Double pretaxget) {
        this.pretaxget = pretaxget;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getUwflag() {
        return uwflag;
    }

    public void setUwflag(String uwflag) {
        this.uwflag = uwflag;
    }

    public String getDignitariesBlackFlag() {
        return dignitariesBlackFlag;
    }

    public void setDignitariesBlackFlag(String dignitariesBlackFlag) {
        this.dignitariesBlackFlag = dignitariesBlackFlag;
    }

    public String getFocusOnCustomFlag() {
        return focusOnCustomFlag;
    }

    public void setFocusOnCustomFlag(String focusOnCustomFlag) {
        this.focusOnCustomFlag = focusOnCustomFlag;
    }

    public String getHasClaimCaseFlag() {
        return hasClaimCaseFlag;
    }

    public void setHasClaimCaseFlag(String hasClaimCaseFlag) {
        this.hasClaimCaseFlag = hasClaimCaseFlag;
    }

    public String getHasClaimFlag() {
        return hasClaimFlag;
    }

    public void setHasClaimFlag(String hasClaimFlag) {
        this.hasClaimFlag = hasClaimFlag;
    }

    public Double getStature() {
        return stature;
    }

    public void setStature(Double stature) {
        this.stature = stature;
    }

    public Double getAvoirdupois() {
        return avoirdupois;
    }

    public void setAvoirdupois(Double avoirdupois) {
        this.avoirdupois = avoirdupois;
    }

    public ArrayList<Lcpol> getLcPolList() {
        return lcPolList;
    }

    public void setLcPolList(ArrayList<Lcpol> lcPolList) {
        this.lcPolList = lcPolList;
    }

    public ArrayList<Lcbnf> getLcbnfList() {
        return lcbnfList;
    }

    public void setLcbnfList(ArrayList<Lcbnf> lcbnfList) {
        this.lcbnfList = lcbnfList;
    }

    public ArrayList<HistoryLccont> getHistoryLccontList() {
        return historyLccontList;
    }

    public void setHistoryLccontList(ArrayList<HistoryLccont> historyLccontList) {
        this.historyLccontList = historyLccontList;
    }

    public ArrayList<Llcase> getLlcaseList() {
        return llcaseList;
    }

    public void setLlcaseList(ArrayList<Llcase> llcaseList) {
        this.llcaseList = llcaseList;
    }

    public ArrayList<LcCustomerImpart> getLcCustomerImpartList() {
        return lcCustomerImpartList;
    }

    public void setLcCustomerImpartList(ArrayList<LcCustomerImpart> lcCustomerImpartList) {
        this.lcCustomerImpartList = lcCustomerImpartList;
    }

    public Double getAccumulatedDeathAmnt() {
        return accumulatedDeathAmnt;
    }

    public void setAccumulatedDeathAmnt(Double accumulatedDeathAmnt) {
        this.accumulatedDeathAmnt = accumulatedDeathAmnt;
    }

    public String getMainInsuredFlag() {
        return mainInsuredFlag;
    }

    public void setMainInsuredFlag(String mainInsuredFlag) {
        this.mainInsuredFlag = mainInsuredFlag;
    }
}
