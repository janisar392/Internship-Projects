import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length) {
        String allowedChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }
}
