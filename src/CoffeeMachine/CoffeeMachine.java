package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    // Константи для кількості інгредієнтів на одну чашку кави
    private static final int WATER_PER_CUP = 200; // мл води
    private static final int MILK_PER_CUP = 50;   // мл молока
    private static final int COFFEE_BEANS_PER_CUP = 15; // г кавових зерен

    // Метод для розрахунку інгредієнтів
    public void calculateIngredients(int cups) {
        int totalWater = WATER_PER_CUP * cups;
        int totalMilk = MILK_PER_CUP * cups;
        int totalCoffeeBeans = COFFEE_BEANS_PER_CUP * cups;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffeeBeans + " g of coffee beans");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        // Запит у користувача кількості чашок кави
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        // Розрахунок інгредієнтів
        coffeeMachine.calculateIngredients(cups);
    }
}
