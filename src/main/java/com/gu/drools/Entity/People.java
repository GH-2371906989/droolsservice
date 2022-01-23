package com.gu.drools.Entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class People {
    private String name;
    private Integer age;
    private Date birthday ;
    private ResultVo resultVo = new ResultVo();

}
