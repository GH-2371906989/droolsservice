package com.gu.drools.fosunhealth.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PublicStaticFunctions {
    //证件号码合法性校验
    public static Boolean idNoValidity(String idType , String idNo){
        //身份证校验
        String IDCARD = "\\d{6}(19|20)*[0-99]{2}(0[1-9]{1}|10|11|12)(0[1-9]{1}"
                + "|1[0-9]|2[0-9]|30|31)(\\w*)";
        //护照校验
        String PASSPORT1 = "/^[a-zA-Z]{5,17}$/";
        String PASSPORT2 = "^[a-zA-Z0-9]{5,17}$";
        /** 港澳通行证验证   */
        String HKMAKAO = "/^[HMhm]{1}([0-9]{10}|[0-9]{8})$/";
        /** 台湾通行证验证   */
        String TAIWAN1 = " /^[0-9]{8}$/";
        String TAIWAN2 = "/^[0-9]{10}$/";

        Pattern pattern1 = Pattern.compile(IDCARD);
        Matcher match1 = pattern1.matcher(idNo);
        boolean isMatch1 = match1.matches();
        if(idType=="0"&&isMatch1){
            return true;
        }

        Pattern pattern2 = Pattern.compile(PASSPORT1);
        Matcher match2 = pattern2.matcher(idNo);
        boolean isMatch2 = match2.matches();
        if(idType=="1"&&isMatch2){
            return true;
        }

        Pattern pattern3 = Pattern.compile(PASSPORT2);
        Matcher match3 = pattern3.matcher(idNo);
        boolean isMatch3 = match3.matches();
        System.out.println("PASSPORT2");

        if(idType=="1"&&isMatch3){
            return true;
        }

        Pattern pattern4 = Pattern.compile(HKMAKAO);
        Matcher match4 = pattern4.matcher(idNo);
        boolean isMatch4 = match4.matches();
        if(idType=="7"&&isMatch4){
            return true;
        }

        Pattern pattern5 = Pattern.compile(TAIWAN1);
        Matcher match5 = pattern5.matcher(idNo);
        boolean isMatch5 = match5.matches();
        if(idType=="8"&&isMatch5){
            return true;
        }
        Pattern pattern6 = Pattern.compile(TAIWAN2);
        Matcher match6 = pattern6.matcher(idNo);
        boolean isMatch6 = match6.matches();
        if(idType=="8"&&isMatch6){
            return true;
        }
        return false;
    }

    /**
     * 功能：判断字符串是否为整数
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    //15位到18位的身份证号
    public static boolean checkIdCard(String idCard) {
        String regex = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
        return Pattern.matches(regex, idCard);
    }
    /**
     * 获取出生日期  yyyy年MM月dd日
     */
    public static Date getBirthday(String IDCard) {
        String birthday = "";
        String year = "";
        String month = "";
        String day = "";
        //15位身份证号
        if (checkIdCard(IDCard)) {
            if (IDCard.length() == 15) {
                // 身份证上的年份(15位身份证为1980年前的)
                year = "19" + IDCard.substring(6, 8);
                //身份证上的月份
                month = IDCard.substring(8, 10);
                //身份证上的日期
                day = IDCard.substring(10, 12);
                //18位身份证号
            } else if (IDCard.length() == 18) {
                // 身份证上的年份
                year = IDCard.substring(6).substring(0, 4);
                // 身份证上的月份
                month = IDCard.substring(10).substring(0, 2);
                //身份证上的日期
                day = IDCard.substring(12).substring(0, 2);
            }
            birthday = year + "-" + month + "-" + day;
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date birthDate = sf.parse(birthday);
                return birthDate;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
            return null;
    }
    /** 计算年龄 */
    @SuppressWarnings("deprecation")
    public static String calAge(Date startDate, Date endDate) {

        int age = startDate.getYear() - endDate.getYear();

        if ((startDate.getMonth() - endDate.getMonth()) < 0) {
            age--;
        } else if ((startDate.getMonth() - endDate.getMonth()) == 0 && (startDate.getDate() - endDate.getDate()) < 0) {
            age--;
        }

        return String.valueOf(age);
    }
    /** 计算一个日期加一个数字 */
    public static Date addDay(Date date,long day) {
        long time = date.getTime();
        day = day*24*60*60*1000;
        time+=day;
        return new Date(time);
    }
    //获取当前系统时间
    public static Date nowDate(){
        Date nowDate  = new Date();
        return nowDate;
    }

    /**
     * 除数小于等于0时，返回false
     */
    public static boolean divideExactly(BigDecimal dividend, BigDecimal divisor) {
        try {
            if (divisor.compareTo(BigDecimal.ZERO) == 0)
                return false;
            else if (dividend.compareTo(BigDecimal.ZERO) == 0)
                return true;
            else if (dividend.remainder(divisor).compareTo(BigDecimal.ZERO) == 0)
                return true;
            return false;
        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }
    }
    /** 判断一个数不是一个数的整数倍 */
    public static boolean divideNotExactly(Double dividend, Double divisor) {

        return !divideExactly(dividend, divisor);
    }

    /** 判断一个数是一个数的整数倍 */
    public static boolean divideExactly(Double dividend, Double divisor) {
        try {
            if (String.valueOf(divisor) == null || String.valueOf(divisor).equals("")) {
                return false;
            }
            return divideExactly(new BigDecimal(String.valueOf(dividend)), new BigDecimal(String.valueOf(divisor)));
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    /** 计算一个日期减去一个日期的天数 */
    @SuppressWarnings("deprecation")
    public static Long calIntervalInDay(Date startDate, Date endDate) {
        Long reDays = null;
        Date sDate = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDate());
        Date eDate = new Date(endDate.getYear(), endDate.getMonth(), endDate.getDate());
        try {
            reDays = (Long) ((sDate.getTime() - eDate.getTime()) / ((1000 * 60 * 60 * 24L)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reDays + 1;
    }
    /* 日期转时间戳 */
    public static Long cusGetTime(Date date){
        return date.getTime();
    }

    /** 计算一个日期减去一个日期的年数 */
    @SuppressWarnings("deprecation")
    public static Double calIntervalInYear(Date startDate, Date endDate) {
        Double reDays = 0.00;
        Date sDate = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDate());
        Date eDate = new Date(endDate.getYear(), endDate.getMonth(), endDate.getDate());
        try {
            reDays = ((sDate.getTime() - eDate.getTime()) * 1.0 / ((1000 * 60 * 60 * 24 * 365L)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reDays;
    }

    /** 计算一个日期减去一个日期的月数 */
    @SuppressWarnings("deprecation")
    public static Long calIntervalInMonth(Date startDate, Date endDate) {
        Long reDays = null;
        Date sDate = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDate());
        Date eDate = new Date(endDate.getYear(), endDate.getMonth(), endDate.getDate());
        try {
            reDays = (Long) ((sDate.getTime() - eDate.getTime()) / ((1000 * 60 * 60 * 24 * 30L)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reDays;

    }
    //取字符串长度
    public static int strLength(String str){
        if(str!=null){
            return str.length();
        }else{
            return 0;
        }
    }
//    public static void main(String[] args) {
//        String d1="2001-01-02";
//        String d2="2000-01-02";
//        SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date sd = df.parse(d1);
//            Date ed = df.parse(d2);
//            System.out.println(calIntervalInDay(sd,ed));
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
