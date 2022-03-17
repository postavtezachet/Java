package com.example.laboratory_work;

import com.example.laboratory_work.exception.DataRequestException;
import org.springframework.beans.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.logging.LogManager;


@RestController
public class Controller {

    private CalculationService cl = new CalculationService();
    private static final String template = "The words \" %s \" have %d symbols \"%c\"";
    @GetMapping("/Data")
    public String get(@RequestParam(value = "words") String words,
                      @RequestParam(value = "symbol") char symbols)throws DataRequestException{

           DataClass gr = new DataClass(words,symbols);
           return String.format(template,gr.getWords(),cl.calc(gr),gr.getSymbol());
    }


}
