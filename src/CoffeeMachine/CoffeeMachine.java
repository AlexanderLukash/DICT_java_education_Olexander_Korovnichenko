package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final int WATER_PER_CUP = 200; // мл води
    private static final int MILK_PER_CUP = 50;   // мл молока
    private static final int COFFEE_BEANS_PER_CUP = 15; // г кавових зерен

    // Метод для перевірки, скільки чашок кави можна приготувати
    public void checkIngredients(int availableWater, int availableMilk, int availableCoffeeBeans, int requestedCups) {
        // Розрахунок максимально можливої кількості чашок
        int maxCupsByWater = availableWater / WATER_PER_CUP;
        int maxCupsByMilk = availableMilk / MILK_PER_CUP;
        int maxCupsByCoffeeBeans = availableCoffeeBeans / COFFEE_BEANS_PER_CUP;

        // Максимальна кількість чашок, яку можна приготувати з наявними інгредієнтами
        int maxCups = Math.min(Math.min(maxCupsByWater, maxCupsByMilk), maxCupsByCoffeeBeans);

        // Перевірка, чи достатньо інгредієнтів для приготування запитаної кількості чашок
        if (requestedCups == 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + maxCups + " more than that)");
        } else if (maxCups == requestedCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > requestedCups) {
            System.out.println("Yes, I can make that amount of coffee (and even "
                    + (maxCups - requestedCups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + maxCups + " cups of coffee");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        // Запитуємо кількість інгредієнтів у користувача
        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int requestedCups = scanner.nextInt();

        // Перевіряємо, скільки чашок можна приготувати
        coffeeMachine.checkIngredients(availableWater, availableMilk, availableCoffeeBeans, requestedCups);
    }
}
