package com.example.laboratory_work.counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class RestCounterThread extends Thread{
    Logger logger = LoggerFactory.getLogger(RestCounterThread.class);
    RequestCounter counter = new RequestCounter();
    public RestCounterThread(){
        super();
        start();
    }
    public void run(){
        logger.info(Thread.currentThread().getName() + " work");
        counter.increment();
    }
}
