import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindrome(String text){
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int l = cleanedText.length();
        for(int i =0 ; i < l/2 ;i++){
            if (cleanedText.charAt(i) != cleanedText.charAt(l-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Character or String : ");

        String text = scanner.nextLine();

        if(isPalindrome(text)){
            System.out.println("This text is Palindrome !");
        }
        else {
            System.out.println("This text Not Palindrome !");
        }
    }
}
