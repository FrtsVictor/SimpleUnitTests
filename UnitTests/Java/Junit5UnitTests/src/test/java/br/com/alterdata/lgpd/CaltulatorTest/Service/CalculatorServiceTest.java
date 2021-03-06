package br.com.alterdata.lgpd.CaltulatorTest.Service;


import br.com.alterdata.lgpd.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void init(){
        this.calculatorService= new CalculatorService();
    }

    @Test
    public void sumTest() {
        int a = 7;
        int b = 8;
        int expectedResult = 15;

        Integer result = calculatorService.sum(a, b);

        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    public void subtractTest() {
        int a = 10;
        int b = 8;
        int expectedResult = 2;

        Integer result = calculatorService.subtract(a, b);

        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    public void multiplyTest() {
        int a = 3;
        int b = 7;
        int expectedResult = 21;

        Integer result = calculatorService.multiply(a, b);

        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    public  void divideTest(){
        //Arrange
        int a = 12; //loca um valor ro local da variavel.. se inverter ou alguem mexer no metodo, vai alertar10
        int b = 4;
        int expectedResult = 3;

        //Act
        Integer result = calculatorService.divide(a, b);

        Assertions.assertEquals(result, expectedResult);
    }


    @Test
    public void divideByZeroTest(){
        int a = 12;
        int b = 0;
        Exception exception = Assertions.assertThrows(ArithmeticException.class,() ->
                calculatorService.divide(a  , b));
        Assertions.assertEquals("Division by zero", exception.getMessage());
    }



}
