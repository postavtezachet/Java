package com.example.laboratory_work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculationService {
    private Logger logger = LoggerFactory.getLogger(CalculationService.class);
    //@Autowired
    private CalculationCache hashMap = new CalculationCache();
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
}
