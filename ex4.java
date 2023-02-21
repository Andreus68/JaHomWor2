import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class ex4 {

    private static Logger LOGGER = Logger.getLogger(ex4.class.getName());
    public static void main(String[] args) throws IOException {
        Handler handler = new FileHandler("test.log");
        Logger.getLogger(ex4.class.getName()).addHandler(handler);
        LOGGER.setUseParentHandlers(false);

        LOGGER.info("Application has been started");
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Scaner has been started");
        boolean running = true;
        while(running) {
            System.out.println("выберете необходимую операция: 1 - суммирование, 2 - вычитание, 3 - умножение, 4 - деление, 5 - выйти из калькулятора");
            int operation = sc.nextInt();
            if(operation == 5){
                running = false;
                LOGGER.info("User has left the application");
                break;
            }
            System.out.println("Введите первое число");
            double firstNumber = sc.nextDouble();
            System.out.println("Введите второе число");
            double secondNumber = sc.nextDouble();

            controller(operation, firstNumber, secondNumber);
        }
    }

    private static double sum(double i, double j){
        LOGGER.info(MessageFormat.format("Operation summing has been selected for numbers {0} and {1}", i, j));
        return i + j;
    }

    private static double diff(double i, double j){
        LOGGER.info(MessageFormat.format("Operation difference has been selected for numbers {0} and {1}", i, j));
        return i - j;
    }

    private static double multiply(double i, double j){
        LOGGER.info(MessageFormat.format("Operation multiplying has been selected for numbers {0} and {1}", i, j));
        return i * j;
    }

    private static double divide(double i, double j){
        LOGGER.info(MessageFormat.format("Operation dividing has been selected for numbers {0} and {1}", i, j));
        return i/j;
    }

    private static void controller(int operation, double firstNumber, double secondNumber){
        System.out.println("результат операции: ");
        double result;
        switch (operation){
            case 1:
                result = sum(firstNumber, secondNumber);
                System.out.println(result);
                break;
            case 2:
                result = diff(firstNumber, secondNumber);
                System.out.println(result);
                break;
            case 3:
                result = multiply(firstNumber, secondNumber);
                System.out.println(result);
                break;
            case 4:
                result = divide(firstNumber, secondNumber);
                System.out.println(result);
                break;
            default:
                LOGGER.severe(MessageFormat.format("Error while executing operation, number {} has been input", operation));
                System.out.println("ошибка при выборе операции");
        }

    }
}