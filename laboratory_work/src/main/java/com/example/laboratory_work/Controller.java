package com.example.laboratory_work;

import com.example.laboratory_work.counter.RequestCounterThread;
import com.example.laboratory_work.exception.DataRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    private CalculationService states;
    private RequestCounterThread counterThread;

    @Autowired
    public void setter(CalculationService newService){
        this.states = newService;
    }

    private static final String template = "The words \" %s \" have %d symbols \"%c\"";
    @GetMapping("/Data")
    public String get(@RequestParam(value = "words") String words,
                      @RequestParam(value = "symbol") char symbols)throws DataRequestException{
           counterThread = new RequestCounterThread();
           DataClass gr = new DataClass(words,symbols);
           return String.format(template,gr.getWords(),states.calc(gr),gr.getSymbol());
    }


}
