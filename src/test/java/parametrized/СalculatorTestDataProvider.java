package parametrized;

import exception.BadStringValue;
import model.Сalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов для класса Сalculator с DataProvider
 */
public class СalculatorTestDataProvider {
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
     * DataProvider с тестовыми данными и ожидаемым результатом для позитивных тестов
     * @return массив тестовых данных: {число1, число2, операция, ожидаемый результат}
     */
    @DataProvider
    public Object[][] positiveTestData(){
        return new Object[][]{
                {"5", "3", "+", 8},
                {"10", "4", "-", 6},
                {"7", "2", "*", 14},
                {"20", "5", "/", 4},
                {"20", "1", "/", 20},
                {"-1", "9", "+", 8},
                {"-2147483647", "-1", "+", -2147483648},
                {"2147483646", "1", "+", 2147483647},
                {"0", "9", "+", 9},
                {"0", "9", "/", 0},
                {"-2", "-2", "*", 4},
        };
    }

    /**
     * DataProvider для негативных тестов.
     *
     * @return массив тестовых данных: {число1, число2, операция, ожидаемое сообщение об ошибке}
     */
    @DataProvider
    public Object[][] negativeTestData() {
        return new Object[][]{
                {"10", "0", "/", "На ноль делить нельзя."},
                {null, "5", "+", "Одна из строк равна null."},
                {"2147483647", "1", "+", "Переполнение при сложении."},
                {"-2147483648", "1", "-", "Переполнение при вычитании."},
                {"2147483647", "2", "*", "Переполнение при умножении."}
        };
    }

    /**
     * Позитивные тесты с использованием DataProvider
     * @param num1 первое число
     * @param num2 второе число
     * @param operation операция
     * @param expectedResult ожидаемый результат
     */
    @Test(dataProvider = "positiveTestData")
    public void testPositiveCasesDataProvider(String num1, String num2, String operation, int expectedResult) {
        calculator.putString(num1, num2, operation);
        assertEquals(calculator.getResult(), expectedResult);
    }

    /**
     * Негативные тесты с использованием DataProvider.
     *
     * @param num1 первое число
     * @param num2 второе число
     * @param operation операция
     * @param expectedMessage ожидаемое сообщение об ошибке
     * @throws BadStringValue если введены некорректные данные
     */
    @Test(dataProvider = "negativeTestData", expectedExceptions = BadStringValue.class)
    public void testNegativeCases(String num1, String num2, String operation, String expectedMessage) throws BadStringValue {
        try {
            calculator.putString(num1, num2, operation);
        } catch (BadStringValue e) {
            assertEquals(e.getMessage(), expectedMessage);
            throw e;
        }
    }
}



