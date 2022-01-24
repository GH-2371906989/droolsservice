package com.gu.drools.globals;

import java.text.SimpleDateFormat;

public class OutputDisplay {
    public OutputDisplay() {
    }

    public void showText(String someText) {
        long time = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = dateFormat.format(time);
        System.out.println("(time=" + s + "\n" + someText+")");
    }

}
