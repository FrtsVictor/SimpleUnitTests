package br.com.alterdata.lgpd.CaltulatorTest.Facade;

import br.com.alterdata.lgpd.facade.CalculatorFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalculatorClassFacadeTests {

    @Autowired
    private CalculatorFacade calculatorFacade;

    @Test
    public  void sumTest(){
        //Arrange
        int a = 7;
        int b = 8;
        //Act
        Integer result = calculatorFacade.sum(a, b);
        //Assert

//        result = null;
        Assertions.assertEquals(result, 15);
    }


}
