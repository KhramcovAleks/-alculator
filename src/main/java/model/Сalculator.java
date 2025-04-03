package model;

import exception.BadStringValue;

public class Сalculator {
    /**
     * Переменная для хранения результата вычислений
     */
    private int result;

    /**
     * Возвращает значение параметра int
     * @return значение параметра int
     */
    public int getResult() {
        return result;
    }

    /**
     * Основной метод для выполнения операции над двумя числами.
     *
     * @param newString1 первое число в виде строки
     * @param newString2 второе число в виде строки
     * @param operation операция (+, -, *, /)
     * @throws BadStringValue если введены некорректные данные или происходит деление на ноль
     */
    public void putString(String newString1, String newString2, String operation) throws BadStringValue {
            // Проверка входных данных
            validateInput(newString1, newString2, operation);
            // Преобразование первой строки в число
            int num1 = Integer.parseInt(newString1);
            // Преобразование второй строки в число
            int num2 = Integer.parseInt(newString2);

            performOperation(num1, num2, operation);
            printResult();
        }

    /**
     * Выполняет арифметическую операцию над двумя числами.
     *
     * @param num1      первое число
     * @param num2      второе число
     * @param operation операция (+, -, *, /)
     * @throws BadStringValue если операция не поддерживается
     */
    private void performOperation(int num1, int num2, String operation) throws BadStringValue {
            switch (operation) {
                case "+":
                    result = sum(num1, num2);
                    break;
                case "-":
                    result = subtraction(num1, num2);
                    break;
                case "*":
                    result = myltiply(num1, num2);
                    break;
                case "/":
                    result = division(num1, num2);
                    break;
            }
    }

    /**
     * Проверяет, что входные строки не равны null.
     *
     * @param newString1 первая строка
     * @param newString2 вторая строка
     * @param newString3 третья строка
     * @throws BadStringValue если одна из строк равна null
     */
    public void validateInput(String newString1, String newString2, String newString3) throws BadStringValue {
        if (newString1 == null || newString2 == null || newString3 == null) {
            throw new BadStringValue("Одна из строк равна null.");
        }
    }

    /**
     * Метод сложения
     * @param a первое число
     * @param b второе число
     * @return результат сложения
     */
    public int sum(int a, int b) throws BadStringValue {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            throw new BadStringValue("Переполнение при сложении.");
        }
        if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new BadStringValue("Переполнение при сложении.");
        }
        return a + b;
    }

    /**
     * Метод умножения
     * @param a первое число
     * @param b второе число
     * @return результат умножения
     */

    public int myltiply(int a, int b) throws BadStringValue {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b) {
            throw new BadStringValue("Переполнение при умножении.");
        }
        if (a > 0 && b < 0 && a < Integer.MIN_VALUE / b) {
            throw new BadStringValue("Переполнение при умножении.");
        }
        if (a < 0 && b > 0 && a < Integer.MIN_VALUE / b) {
            throw new BadStringValue("Переполнение при умножении.");
        }
        if (a < 0 && b < 0 && a < Integer.MAX_VALUE / b) {
            throw new BadStringValue("Переполнение при умножении.");
        }
        return a * b;
    }

    /**
     * Метод вычитания
     * @param a первое число
     * @param b второе число
     * @return результат вычитания
     */
    public int subtraction(int a, int b) throws BadStringValue {
        if (a > 0 && b < 0 && a > Integer.MAX_VALUE + b) {
            throw new BadStringValue("Переполнение при вычитании.");
        }
        if (a < 0 && b > 0 && a < Integer.MIN_VALUE + b) {
            throw new BadStringValue("Переполнение при вычитании.");
        }
        return a - b;
    }

    /**
     * Метод деления и проверка деления на 0
     * @param a первое число
     * @param b второе число
     * @return результат деления
     */
    public int division(int a, int b) throws BadStringValue {
        if (b == 0) {
            throw new BadStringValue("На ноль делить нельзя.");
        }
        return a / b;
    }

    /**
     * Выводим результат вычислений в консоль.
     */
    private void printResult() {
        System.out.println("Итого: " + result);
    }
}

