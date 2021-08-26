package com.gettransport.docs.dao;

import java.util.TimerTask;

public class Cleaner extends TimerTask {


    public void completeTask(){

    }

    @Override
    public void run() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        completeTask();
        }
    }

