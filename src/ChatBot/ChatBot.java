package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "DICTBot";
        int birthYear = java.time.Year.now().getValue();

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");

        // Додаємо символ ">" для позначення введення користувачем
        System.out.print("> ");

        // Створення об'єкта для зчитування введення від користувача
        Scanner scanner = new Scanner(System.in);

        String yourName = scanner.nextLine(); // Зчитуємо ім'я користувача
        System.out.println("What a great name you have, " + yourName + "!");

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        // Вводимо числа, після того як поділимо їх на 3, 5 та 7
        System.out.print("Remainder when divided by 3:> ");

        int remainder3 = scanner.nextInt();

        System.out.print("Remainder when divided by 5:> ");

        int remainder5 = scanner.nextInt();

        System.out.print("Remainder when divided by 7:> ");

        int remainder7 = scanner.nextInt();

        // Обчислюємо вік за формулою
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виводимо вгаданий вік
        System.out.println("\nYour age is " + age + "; that's a good time to start programming!");

        // Виводимо числа від 0 до того числа, яке введе користувач
        System.out.println("Now I will prove to you that I can count to any number you want!");
        System.out.print("Enter a positive number:> ");
        int userInput = scanner.nextInt();

        // Виведення чисел від 1 до userInput
        for (int i = 1; i <= userInput; i++) {
            System.out.println(i + "!");
        }

        scanner.close();

    }
}
