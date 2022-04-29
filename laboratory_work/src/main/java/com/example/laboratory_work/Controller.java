package com.example.laboratory_work;

import com.example.laboratory_work.counter.RequestCounterThread;
import com.example.laboratory_work.exception.DataRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    private CalculationService states;
    private RequestCounterThread counterThread;

    @Autowired
    public void setter(CalculationService newService){
        this.states = newService;
    }

    private static final String template = "The words \" %s \" have %d symbols \"%c\"";
    private static final String template1 = "The words  %s have %d symbols %c ";

    @GetMapping("/Data")
    public String get(@RequestParam(value = "words") String words,
                      @RequestParam(value = "symbol") char symbols)throws DataRequestException{
           counterThread = new RequestCounterThread();
           DataClass gr = new DataClass(words,symbols);
           return String.format(template,gr.getWords(),states.calc(gr),gr.getSymbol());
    }
    @PostMapping("/Data")
    public ResponseEntity<?> post1(@RequestBody List<DataClass> list){
        List<String> res = new ArrayList<>();
        list.forEach((element)->{
            res.add( String.format(template1,element.getWords(),states.calc(element),element.getSymbol()));
        });
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
