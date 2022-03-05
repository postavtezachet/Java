package com.example.laboratory_work;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private CalculationService cl = new CalculationService();
    private static final String template = "The words \" %s \" have %d symbols \"%c\"";
    @GetMapping("/Data")
    public String get(@RequestParam(value = "words", defaultValue =
            "World") String words, @RequestParam(value = "symbol", defaultValue =
            "a") char symbols){
            DataClass gr = new DataClass(words,symbols);
            return String.format(template,gr.getWords(),cl.calc(gr),gr.getSymbol());
    }

}
