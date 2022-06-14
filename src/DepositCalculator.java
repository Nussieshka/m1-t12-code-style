import java.util.Scanner;

public class DepositCalculator {
    static final int CONST = 2;
    static final double PERCENT_RATE = 0.6;

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return random(pay, CONST);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return random(amount + amount * yearRate * depositPeriod, CONST);
    }

    double random(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void printMenu() {
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double result = 0.0;
        System.out.println("Процентная ставка: " + PERCENT_RATE);
        switch (action) {
            case 1:
                result = calculateSimplePercent(amount, PERCENT_RATE, period);
                System.out.println(result);
                break;
            case 2:
                result = calculateComplexPercent(amount, PERCENT_RATE, period);
                break;
            default:
                break;
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().printMenu();
    }
}
