import model.Сalculator;

import java.util.Scanner;

import static utils.Validator.validateInputOperation;
import static utils.Validator.validateInputString;

public class Application {
    public static void main(String[] args) {

        // Создание объекта Сalculator
        Сalculator calculator = new Сalculator();

        // Бескоченый цикл, чтобы выполнение программы не прекращалось
        while (true) {

            // Создание сканера, который считывает значение с консоли.
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите первое число");
            // Проверка первого числа
            String str1 = validateInputString(scanner.next());
            System.out.println("Введите второе число");
            // Проверка второго числа
            String str2 = validateInputString(scanner.next());

            System.out.println("Введите операцию (+, -, *, /)");
            // Проверка оператора
            String operation = validateInputOperation(scanner.next());

            // Добавление сроки в калькулятор.
            calculator.putString(str1,str2,operation);

        }
    }
}
