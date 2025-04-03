package utils;

import exception.BadStringValue;

public class Validator {
    /**
     * Проверяет строку на наличие в ней только цифр от 0 до 9 и проверяет в хождения числа в допустимый димпазон
     *
     * @param input проверяемая строка
     * @return строка в случае успешной проверки, null в случае неуспешной.
     */
    public static String validateInputString(String input) throws BadStringValue {
        if (input.matches("-?[0-9]+") && !input.isEmpty()) {
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new BadStringValue("Число выходит за пределы допустимого диапазона: " + input);
            }
            return input;
        } else {
            throw new BadStringValue("Не корректное число " + input);
        }
    }
    /**
     * Проверяет строку на наличие в ней только символов +,-,/,*
     *
     * @param input проверяемая строка
     * @return строка в случае успешной проверки, null в случае неуспешной.
     */
    public static String validateInputOperation(String input) throws BadStringValue {
        if (input.matches("[+\\-/*]") && !input.isEmpty()) {
            return input;
        } else {
            throw new BadStringValue("Не корректный символ - " + input);
        }
    }
}


