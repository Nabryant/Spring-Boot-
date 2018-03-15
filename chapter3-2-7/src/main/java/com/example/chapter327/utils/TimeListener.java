package com.example.chapter327.utils;

import com.example.chapter327.Service.Dom4jBuildXmlDemo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Calendar;
import java.util.Timer;

/**
 * Author  : Nabryant
 * E-mail  :
 * Time    : 2018/3/15
 * Function:
 */


@WebListener
public class TimeListener implements ServletContextListener {

    //设置启动时间
    private static final int hour = 23;
    private static final int minutes = 0;
    private static final int seconds = 0;

    private Timer timer = new Timer();

    @Override
    public void contextDestroyed (ServletContextEvent event) {
        timer.cancel();
        event.getServletContext().log("定时器销毁");
        System.out.println("timer destroyed");
    }

    @Override
    public void contextInitialized (ServletContextEvent event) {

        event.getServletContext().log("定时器启动");
        System.out.println("timer start to work!");

        new TimerManager();

    }

}