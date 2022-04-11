package com.example.laboratory_work;

import com.example.laboratory_work.counter.RequestCounter;
import com.example.laboratory_work.counter.RestCounterThread;
import com.example.laboratory_work.exception.DataRequestException;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    //autowired
    private CalculationService cl = new CalculationService();
    private static final String template = "The words \" %s \" have %d symbols \"%c\"";
    @GetMapping("/Data")
    public String get(@RequestParam(value = "words") String words,
                      @RequestParam(value = "symbol") char symbols)throws DataRequestException{
        RestCounterThread counterThread = new RestCounterThread();
           DataClass gr = new DataClass(words,symbols);
           return String.format(template,gr.getWords(),cl.calc(gr),gr.getSymbol());
    }


}
