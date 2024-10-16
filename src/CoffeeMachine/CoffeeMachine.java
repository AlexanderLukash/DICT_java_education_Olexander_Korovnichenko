package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;
    private String state = "choosing action";  // початковий стан машини
    private final Scanner scanner = new Scanner(System.in);

    // Зберігаємо кількість інгредієнтів для різних станів наповнення
    private int fillWater;
    private int fillMilk;
    private int fillCoffeeBeans;

    // Метод для обробки введених даних
    public void input(String input) {
        switch (state) {
            case "choosing action":
                handleAction(input);
                break;
            case "choosing coffee type":
                handleCoffeeChoice(input);
                break;
            case "filling water":
                fillWater = Integer.parseInt(input);
                state = "filling milk";
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case "filling milk":
                fillMilk = Integer.parseInt(input);
                state = "filling coffee beans";
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case "filling coffee beans":
                fillCoffeeBeans = Integer.parseInt(input);
                state = "filling cups";
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                break;
            case "filling cups":
                int fillCups = Integer.parseInt(input);
                fill(fillWater, fillMilk, fillCoffeeBeans, fillCups);
                state = "choosing action";
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
        }
    }

    // Метод для обробки вибору дії
    private void handleAction(String action) {
        switch (action) {
            case "buy":
                state = "choosing coffee type";
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                break;
            case "fill":
                state = "filling water";
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "take":
                take();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "remaining":
                printState();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Unknown action, please try again.");
                System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
    }

    // Метод для обробки вибору типу кави
    private void handleCoffeeChoice(String choice) {
        switch (choice) {
            case "1":
                buyEspresso();
                state = "choosing action";
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "2":
                buyLatte();
                state = "choosing action";
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "3":
                buyCappuccino();
                state = "choosing action";
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case "back":
                state = "choosing action";
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            default:
                System.out.println("Invalid coffee choice.");
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
        }
    }

    // Метод для покупки еспресо
    private void buyEspresso() {
        if (checkIngredients(250, 0, 16)) {
            water -= 250;
            coffeeBeans -= 16;
            disposableCups--;
            money += 4;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    // Метод для покупки лате
    private void buyLatte() {
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
    private void buyCappuccino() {
        if (checkIngredients(200, 100, 12)) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups--;
            money += 6;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    // Метод для перевірки інгредієнтів
    private boolean checkIngredients(int waterNeeded, int milkNeeded, int coffeeNeeded) {
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
    private void fill(int addedWater, int addedMilk, int addedCoffeeBeans, int addedCups) {
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        disposableCups += addedCups;
    }

    // Метод для вилучення грошей
    private void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    // Метод для виведення поточного стану кавомашини
    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        while (true) {
            String input = machine.scanner.next();
            machine.input(input);
        }
    }
}
