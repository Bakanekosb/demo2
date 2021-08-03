/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

/**
 *
 * @author Dell
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TaskDaily {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 5);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date dateSchedule = calendar.getTime();
        long period = 24 * 60 * 60 * 1000;

        Timer timer = new Timer();
        timer.schedule(myTask, dateSchedule, period);
    }
}



