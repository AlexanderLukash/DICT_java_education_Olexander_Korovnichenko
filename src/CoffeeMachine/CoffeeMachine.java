package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;

    // Метод для виведення поточного стану кавомашини
    public void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    // Метод для покупки еспресо
    public void buyEspresso() {
        if (checkIngredients(250, 0, 16)) {
            water -= 250;
            coffeeBeans -= 16;
            disposableCups--;
            money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    // Метод для покупки лате
    public void buyLatte() {
        if (checkIngredients(350, 75, 20)) {
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposableCups--;
            money += 7;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    // Метод для покупки капучино
    public void buyCappuccino() {
        if (checkIngredients(200, 100, 12)) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups--;
            money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    // Метод для перевірки, чи достатньо інгредієнтів
    public boolean checkIngredients(int waterNeeded, int milkNeeded, int coffeeNeeded) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans < coffeeNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    // Метод для поповнення запасів
    public void fill(int addedWater, int addedMilk, int addedCoffeeBeans, int addedCups) {
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedCups;
    }

    // Метод для вилучення грошей
    public void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        label:
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                    String choice = scanner.next();
                    switch (choice) {
                        case "1" -> coffeeMachine.buyEspresso();
                        case "2" -> coffeeMachine.buyLatte();
                        case "3" -> coffeeMachine.buyCappuccino();
                        case "back" -> {
                            continue;
                        }
                        default -> System.out.println("Invalid choice.");
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int addedWater = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int addedMilk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int addedCoffeeBeans = scanner.nextInt();
                    System.out.println("Write how many disposable coffee cups you want to add:");
                    int addedCups = scanner.nextInt();
                    coffeeMachine.fill(addedWater, addedMilk, addedCoffeeBeans, addedCups);
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.printState();
                    break;
                case "exit":
                    break label;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }
    }
}
