package com.gu.drools.Vo;

import com.gu.drools.fosunhealth.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResEntity implements Serializable {
    private Insured insured;
    private RiskAmntRela riskAmntRela;
    private Lcinsured lcinsured ; //被保人
    private Lcbnf lcbnf ; //受益人
    private Lcappnt lcappnt; //投保人
    private Lccont lccont;//个人保单
    private HistoryLccont historyLccont;//既往保单
    private Lcpol lcpol;//险种
    private Lcduty lcduty;//责任险种
    private HistoryLcpol historyLcpol;//既往险种
    private LcCustomerImpart lcCustomerImpart;//告知
    private Llcase llcase;//理赔案件
    private Llclaimdetail llclaimdetail;//理赔明细
    private Laagent laagent;//代理人
    private ResultDto resultDto =new ResultDto();
    private UWDto uwDto =new UWDto();
}
