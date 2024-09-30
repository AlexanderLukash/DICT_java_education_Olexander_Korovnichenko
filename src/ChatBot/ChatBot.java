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
        System.out.print("Remainder when divided by 3:");
        System.out.print("> ");

        int remainder3 = scanner.nextInt();

        System.out.print("Remainder when divided by 5:");
        System.out.print("> ");

        int remainder5 = scanner.nextInt();

        System.out.print("Remainder when divided by 7:");
        System.out.print("> ");

        int remainder7 = scanner.nextInt();

        // Обчислюємо вік за формулою
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виводимо вгаданий вік
        System.out.println("\nYour age is " + age + "; that's a good time to start programming!");

        scanner.close();

    }
}
