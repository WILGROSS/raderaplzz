package systementor.cidemo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    private static final Logger logger = Logger.getLogger(CalculatorTest.class.getName());

    private final int a = 1;
    private final int b = 2;


    private final int devideA = 4;
    private final int devideB = 2;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    void divideWithLogging() {

        logger.info("divide " + devideA + " with " + devideB);

        if (b == 0){
            logger.severe("divide by zero!!");
            throw new IllegalArgumentException("divide by zero");
        }

        int result = devideA / devideB;
        assertEquals(2,result);
    }


    @Test
    void addShouldReturn3() {
        int result = calculator.add(a,b);
        assertEquals(3,result);
    }

    @Test
    void addShouldReturn3_withPrintln() {
        System.out.println("Println INFO: Starting test addShouldReturn3...");

        int result = calculator.add(a, b);
        System.out.println("Println INFO: Result from calculator: " + result);

        try {
            assertEquals(5, result);
            System.out.println("Println SUCCESS: Test passed! addShouldReturn3 returned 3");
        } catch (AssertionError e) {
            System.out.println("Println ERROR: Test failed! Expected 3 but got: " + result);
            throw e;
        }
    }

    @Test
    void addShouldReturn3_withLogger() {
        logger.info("Starting test addShouldReturn3...");

        int result = calculator.add(a, b);
        logger.info("Result from calculator: " + result);

        try {
            assertEquals(3, result);
            logger.info("SUCCESS: Test passed! addShouldReturn3 returned 3");
        } catch (AssertionError e) {
            logger.severe("FAIL: Expected 3 but got " + result);
            throw e;
        }
    }

    @Test
    void subtractShouldReturnNegative1() {
        int result = calculator.subtract(a,b);
        assertEquals(-1,result);
    }

    @Test
    void multiplyShouldReturn2() {
        int result = calculator.multiply(a,b);
        assertEquals(2,result);
    }


    @Test
    void divideShouldReturn0() {
        int result = calculator.divide(a,b);
        assertEquals(0,result);
    }


    @Test
    void divideByZeroThrowsError(){
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5,0));
    }



}