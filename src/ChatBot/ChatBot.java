package ChatBot;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "DICTBot";
        int birthYear = java.time.Year.now().getValue();

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
    }
}
