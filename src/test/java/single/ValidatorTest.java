package single;

import exception.BadStringValue;
import org.testng.annotations.Test;
import utils.Validator;
import static org.testng.Assert.assertEquals;
import static utils.Validator.validateInputOperation;
import static utils.Validator.validateInputString;

public class ValidatorTest {

    /**
     * Позитивные проверки
     */
    @Test
    public void testValidateInputStringPositive() throws BadStringValue {
        assertEquals(validateInputString("123"), "123");
    }

    @Test
    public void testValidateInputNegativeStringPositive() throws BadStringValue {
        assertEquals(validateInputString("-456"), "-456");
    }

    /**
     * Негативные проверки
     */

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Не корректное число abc")
    public void testInvalidNumberInput() throws BadStringValue {
        validateInputString("abc");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Не корректный символ - %")
    public void testInvalidOperationInput() throws BadStringValue {
        validateInputOperation("%");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Не корректное число --123")
    public void testValidateInputStringNegativeDoubleMinus() throws BadStringValue {
        validateInputString("--123");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Не корректное число 12.34")
    public void testValidateInputStringNegativeDecimal() throws BadStringValue {
        validateInputString("12.34");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Число выходит за пределы допустимого диапазона: 2147483648")
    public void testValidateInputStringAboveMaxInt() throws BadStringValue {
        validateInputString("2147483648");
    }

    @Test(expectedExceptions = BadStringValue.class, expectedExceptionsMessageRegExp = "Число выходит за пределы допустимого диапазона: -2147483649")
    public void testValidateInputStringBelowMinInt() throws BadStringValue {
        validateInputString("-2147483649");
    }
}
