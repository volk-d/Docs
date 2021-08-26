package com.gettransport.docs.dao;

import java.util.TimerTask;

public class Cleaner extends Thread {
    String id;

    public Cleaner(String id) {
        this.id = id;
        this.setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(15*60*1000);
            Date.delete(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

