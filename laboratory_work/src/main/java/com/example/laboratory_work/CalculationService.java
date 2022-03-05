package com.example.laboratory_work;

import org.springframework.stereotype.Component;

@Component
public class CalculationService {
    public int calc(DataClass gr) {
        int count = 0;
        char [] a = gr.getWords().toCharArray();
        for(int i=0;i<gr.getWords().length();i++){
            if(a[i] == gr.getSymbol()){
                count++;
            }
        }
        return count;
    }
}
