package com.example.laboratory_work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CalculationService {
    private CalculationCache hashMap;
    private Logger logger = LoggerFactory.getLogger(CalculationService.class);
    @Autowired
    public void setHashMap(CalculationCache hashMap){
        this.hashMap = hashMap;
    }
    public int calc(DataClass gr) {
        int count = 0;
        if(hashMap.isContain(gr)){
            count = hashMap.getParam(gr);
            logger.info("Get hashMap");
        }
        else {
            char[] a = gr.getWords().toCharArray();
            for (int i = 0; i < gr.getWords().length(); i++) {
                if (a[i] == gr.getSymbol()) {
                    count++;
                }
            }
            hashMap.addToMap(gr,count);
            logger.info("Add to hashMap");
        }
        return count;
    }

    public long calcSize(List<Integer> resList){
        long size =0;
        if(!resList.isEmpty()){
            size = resList.stream().count();
        }
        return size;
    }
}
