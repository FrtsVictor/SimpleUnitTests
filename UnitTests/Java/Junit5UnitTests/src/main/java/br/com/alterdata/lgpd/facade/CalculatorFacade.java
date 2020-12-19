package br.com.alterdata.lgpd.facade;

import br.com.alterdata.lgpd.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatorFacade {

    @Autowired
    private CalculatorService calculatorService;

    public Integer sum(int a, int b){
        return this.calculatorService.sum(a, b);
    }

    public Integer subtract(int a, int b){ return this.calculatorService.subtract(a, b); }
    public Integer multiply(int a, int b){ return this.calculatorService.multiply(a, b); }
    public Integer divide(int a, int b){ return this.calculatorService.divide(a, b); }
    public Integer sumAndMultiply(int a, int b, int c){ return this.calculatorService.sumAndMultiply(a, b, c); }

}
