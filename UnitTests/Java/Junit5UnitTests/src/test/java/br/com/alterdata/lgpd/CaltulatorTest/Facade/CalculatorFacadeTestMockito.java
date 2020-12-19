package br.com.alterdata.lgpd.CaltulatorTest.Facade;

import br.com.alterdata.lgpd.facade.CalculatorFacade;
import br.com.alterdata.lgpd.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // nao utilizo a aplicação do springBoot para inicializar o spring, só uso o mock
public class CalculatorFacadeTestMockito {

    //Sempre garatir todos cenarios, negativo, misto, positivo

    @Mock
    private CalculatorService calculatorService; // cria o mock que vou utilizar no facade

    @InjectMocks //injeta no facate para quando precisar
    private CalculatorFacade calculatorFacade;

    @Test
    public  void sumTest(){
        //Arrange
        int a = 7; //loca um valor ro local da variavel.. se inverter ou alguem mexer no metodo, vai alertar
        int b = 8;
        int expectedResult = 15;
        //Act
        Mockito.when(calculatorService.sum(a, b)).thenReturn(expectedResult);
        //Assert
        Integer result = calculatorFacade.sum(a,b);
//        result = null;
        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calculatorService, Mockito.times(1)).sum(a,b); //garanto que o metodo vai ser chamado
    }


    @Test
    public  void sumTest2(){
        //Arrange
        int a = -8; //loca um valor ro local da variavel.. se inverter ou alguem mexer no metodo, vai alertar
        int b = -5;
        int expectedResult = -14;
        //Act
        Mockito.when(calculatorService.sum(a, b)).thenReturn(expectedResult);
        //Assert
        Integer result = calculatorFacade.sum(a,b);
//        result = null;
        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calculatorService, Mockito.times(1)).sum(a,b); //garanto que o metodo vai ser chamado
    }


    @Test
    public  void sumTest3(){
        //Arrange
        int a = -9; //loca um valor ro local da variavel.. se inverter ou alguem mexer no metodo, vai alertar
        int b = -5;
        int expectedResult = -14;
        //Act
        Mockito.when(calculatorService.sum(a, b)).thenReturn(expectedResult);
        //Assert
        Integer result = calculatorFacade.sum(a,b);
//        result = null;
        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calculatorService, Mockito.times(1)).sum(a,b); //garanto que o metodo vai ser chamado
    }

    @Test
    public void subtractTest() {
        int a = 10;
        int b = 4;
        int expectedResult = 6;

        Mockito.when(calculatorService.subtract(a, b)).thenReturn(expectedResult);

        Integer result = calculatorFacade.subtract(a, b);

        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calculatorService, Mockito.times(1)).subtract(a, b);
    }

    @Test
    public void multiplyTest() {
        int a = 4;
        int b = 10;
        int expectedResult = 40;

        Mockito.when(calculatorService.multiply(a, b)).thenReturn(expectedResult);

        Integer result = calculatorFacade.multiply(a, b);

        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calculatorService, Mockito.times(1)).multiply(a, b);
    }

    @Test
    public void divideTest() {
        int a = 12;
        int b = 4;
        int expectedResult = 3;

        Mockito.when(calculatorService.divide(a, b)).thenReturn(expectedResult);

        Integer result = calculatorFacade.divide(a, b);

        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calculatorService, Mockito.times(1)).divide(a, b);
    }

    @Test
    public void sumAndMultiplyTest() {
        int a = 2;
        int b = 4;
        int sum = 6;
        int c = 6;
        int expectedResult = 36;

        CalculatorFacade calcFacadeMock = Mockito.spy(calculatorFacade); //espionando a service, pra mockar o metodo interno
                    //retorna a instancia de facede mockada

        Mockito.when(calcFacadeMock.sum(a, b)).thenReturn(sum); //to mocando pq n quero testar os metos, quero testar somente sum and multply
        Mockito.when(calcFacadeMock.multiply(sum, c)).thenReturn(expectedResult);

        Integer result = calculatorFacade.sumAndMultiply(a, b, c);

        Assertions.assertEquals(result, expectedResult);
        Mockito.verify(calcFacadeMock, Mockito.times(1)).sum(a, b); //validando se o metodo foi chamado com os parametros a, b
        Mockito.verify(calcFacadeMock, Mockito.times(1)).multiply(sum, c);
    }


}
