package parametrized;

import exception.BadStringValue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static utils.Validator.validateInputOperation;
import static utils.Validator.validateInputString;

public class ValidatorTestDataProvider {
    /**
     * DataProvider для позитивных тестов.
     *
     * @return массив тестовых данных
     */
    @DataProvider(name = "positiveTestData")
    public Object[][] positiveTestData() {
        return new Object[][]{
                {"123"},
                {"-456"},
                {"0"},
                {"999999999"}
        };
    }

    /**
     * DataProvider для негативных тестов.
     *
     * @return массив тестовых данных: {входная строка, ожидаемое сообщение об ошибке}
     */
    @DataProvider(name = "negativeTestData")
    public Object[][] negativeTestData() {
        return new Object[][]{
                {"abc", "Не корректное число abc"},
                {"12.34", "Не корректное число 12.34"},
                {"--123", "Не корректное число --123"},
                {"", "Не корректное число "},
                {"123abc", "Не корректное число 123abc"},
                {"+123", "Не корректное число +123"},
                {"%", "Не корректный символ - %"},
                {"2147483648", "Число выходит за пределы допустимого диапазона: 2147483648"}, // Выше максимального значения int
                {"-2147483649", "Число выходит за пределы допустимого диапазона: -2147483649"} // Ниже минимального значения int
        };
    }

    /**
     * Позитивные тесты с использованием DataProvider.
     *
     * @param input  входная строка
     * @throws BadStringValue если введены некорректные данные
     */
    @Test(dataProvider = "positiveTestData")
    public void testValidateInputStringPositive(String input) throws BadStringValue {
        validateInputString(input);
    }

    /**
     * Негативные тесты с использованием DataProvider.
     *
     * @param input           входная строка
     * @param expectedMessage ожидаемое сообщение об ошибке
     * @throws BadStringValue если введены некорректные данные
     */
    @Test(dataProvider = "negativeTestData", expectedExceptions = BadStringValue.class)
    public void testValidateInputStringNegative(String input, String expectedMessage) throws BadStringValue {
        validateInputString(input);
    }

    @Test(dataProvider = "negativeTestData", expectedExceptions = BadStringValue.class)
    public void testValidateInputOperationNegative(String input, String expectedMessage) throws BadStringValue {
        validateInputOperation(input);
    }
}
