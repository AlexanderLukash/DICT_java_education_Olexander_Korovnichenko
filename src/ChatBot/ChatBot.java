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

        scanner.close();

    }
}
