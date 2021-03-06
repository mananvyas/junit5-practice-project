package general;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//TestInstance will make sure that instance of a class will created only once to reduce burden at test run,
//rather than creating at each method run

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) -- This will create instance at each method run
class MathUtilsTest {

    MathUtils mathUtils;

    //Note:
    // BeforeAll even gets executed before the instance of class is created
    // hence method marked with BeforeAll/AfterAll annotation MUST be marked as static - so that those are available
    // regardless of class instance. - Very Important concept.

    @BeforeAll
    static void setUpBeforeAll(){
        System.out.println("Simple Before All");
    }
    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void tearDown() {
        //Nothing as of now
    }

    @Nested
    @DisplayName("All Add Tests Together")
    class AddTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)//Enabled for specific OS.
        @DisplayName("Simply Add 2 Positive Integers")
        void addPositiveInteger() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual);
        }

        @Test
        @EnabledOnJre(JRE.JAVA_8)
            //Enabled for specific version of JRE..
        void addOneNegativeInteger() {
            boolean isServerUp = true;//Change this value to fail the testcase

            //Putting assumptions and running tested if given assumption is true or false.
            assumeTrue(isServerUp);
            int expected = 3;
            int actual = mathUtils.add(5, -2);
            assertEquals(expected, actual);
        }
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

    @Test
    @Disabled
    void testDisabled(){
        fail("TDD method, should not run");
    }
}