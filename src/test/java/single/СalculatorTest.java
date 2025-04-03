package single;

import exception.BadStringValue;
import model.Сalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


/**
 * Набор отдельных тестов для класса Сalculator
 */
public class СalculatorTest {

    /**
     * Создание переменной с классом Сalculator.
     */
    private Сalculator calculator;
    /**
     * Метод который выполняется перед каждый тестом, создает объект класса.
     */
    @BeforeMethod
    public void setUp() {
        calculator = new Сalculator();
    }

    /**
     * Позитивные проверки
     */
    @Test
    public void testSumPositive() throws BadStringValue {
        calculator.putString("5", "3", "+");
        assertEquals(calculator.getResult(), 8);
    }

    @Test
    public void testSubtractionPositive() throws BadStringValue {
        calculator.putString("10", "4", "-");
        assertEquals(calculator.getResult(), 6);
    }

    @Test
    public void testMultiplyPositive() throws BadStringValue {
        calculator.putString("7", "2", "*");
        assertEquals(calculator.getResult(), 14);
    }

    @Test
    public void testDivisionPositive() throws BadStringValue {
        calculator.putString("20", "5", "/");
        assertEquals(calculator.getResult(), 4);
    }

    @Test
    public void testDivisionOnePositive() throws BadStringValue {
        calculator.putString("20", "1", "/");
        assertEquals(calculator.getResult(), 20);
    }

    @Test
    public void testSumNegativeOnesPositive() throws BadStringValue {
        calculator.putString("-1", "9", "+");
        assertEquals(calculator.getResult(), 8);
    }

    @Test
    public void testSumExtremeNegativeOnesPositive() throws BadStringValue {
        calculator.putString("-2147483647", "-1", "+");
        assertEquals(calculator.getResult(), -2147483648);
    }

    @Test
    public void testSumExtremePositiveOnesPositive() throws BadStringValue {
        calculator.putString("2147483646", "1", "+");
        assertEquals(calculator.getResult(), 2147483647);
    }

    @Test
    public void testSumExtremePositive() throws BadStringValue {
        calculator.putString("0", "9", "+");
        assertEquals(calculator.getResult(), 9);
    }

    @Test
    public void testDivisionNullPositive() throws BadStringValue {
        calculator.putString("0", "9", "/");
        assertEquals(calculator.getResult(), 0);
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.myltiply(2, 3), 6);
    }

    @Test
    public void testAdd() {
        assertEquals(calculator.sum(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtraction(5, 3), 2);
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.division(6, 2), 3);
    }

    /**
     * Негативные проверки
     */
    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "На ноль делить нельзя.")
    public void testDivisionByZero() throws BadStringValue {
        calculator.putString("10", "0", "/");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "На ноль делить нельзя.")
    public void testMetodDivisionByZeroMetod() throws BadStringValue {
        calculator.division(10,0);
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Одна из строк равна null.")
    public void testNullInput() throws BadStringValue {
        calculator.putString(null, "5", "+");
    }
    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Переполнение при сложении.")
    public void testOverflowAddition() throws BadStringValue {
        calculator.putString("2147483647", "1", "+");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Переполнение при вычитании.")
    public void testOverflowSubtraction() throws BadStringValue {
        calculator.putString("-2147483648", "1", "-");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Переполнение при умножении.")
    public void testOverflowMultiplication() throws BadStringValue {
        calculator.putString("2147483647", "4", "*");
    }
    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Переполнение при умножении.")
    public void testSubtractOverflow() throws BadStringValue {
        calculator.myltiply(Integer.MIN_VALUE, 2);
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Переполнение при умножении.")
    public void testMultiplyOverflow() throws BadStringValue {
        calculator.myltiply(Integer.MAX_VALUE, 2);
    }

}
