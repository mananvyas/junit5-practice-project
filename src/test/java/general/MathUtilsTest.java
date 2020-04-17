package general;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPositiveInteger() {
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual);
    }

    @Test
    void addOneNegativeInteger() {
        int expected = 3;
        int actual = mathUtils.add(5,-2);
        assertEquals(expected, actual);
    }

    @Test
    void addNegativeInteger() {
        int expected = -6;
        int actual = mathUtils.add(-4,-2);
        assertEquals(expected, actual);
    }

    @Test
    void testDivide(){
        //AssertThrows  - Very useful assertion

        //Important Note: It takes 2 arguments -
        // first arg: expectedType which is nothing but expected exception from the specific method call
        // second arg: executable - which is nothing but a function which might generate an exception
        //Other way around is to use try catch but this is compact version using lambdas.

        //Note: Might need to set language level from IntelliJ Project Structure -> Module -> select Java 8 or more

        //Comment and Uncomment following 2 lines to verify assertThrows working
        assertThrows(ArithmeticException.class, () ->  mathUtils.divide(1, 0));
        //assertThrows(NullPointerException.class, () ->  mathUtils.divide(1, 0));
    }
}