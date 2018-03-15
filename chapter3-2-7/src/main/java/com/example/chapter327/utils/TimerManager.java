package com.example.chapter327.utils;

import com.example.chapter327.Service.Dom4jBuildXmlDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/15
 * Function:
 */
public class TimerManager {

    private Timer timer = new Timer(true);

    //设置启动时间
    private static final int hour = 11;
    private static final int minutes = 8;
    private static final int seconds = 0;

//    @Autowired
//    private Dom4jBuildXmlDemo dom4jBuildXmlDemo;

//    @Bean
//    public Dom4jBuildXmlDemo dom4jBuildXmlDemo() {
//        return new Dom4jBuildXmlDemo();
//    }

    private Dom4jBuildXmlDemo dom4jBuildXmlDemo = new Dom4jBuildXmlDemo();

    public TimerManager () {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, seconds);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    dom4jBuildXmlDemo.buildXml();
                } catch (Exception ex) {
                    System.out.println("定时任务error");
                    ex.printStackTrace();
                }
            }
        };
        //一分钟
        //timer.schedule(task, calendar.getTime(), 60*1000);
        timer.schedule(task, new Date(), 60*1000);
    }


}
