import java.util.Scanner;

public class StudGradeCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Marks Out of 100 : ");
        int marks = scanner.nextInt();

        if(marks<=100&& marks>90){
            System.out.println("Your Grade is A+");
        }
        else if(marks<=90&& marks>80){
            System.out.println("Your Grade is A");
        }
        else if(marks<=80&& marks>70){
            System.out.println("Your Grade is B+");
        }
        else if(marks<=70&& marks>60){
            System.out.println("Your Grade is B");
        }
        else if(marks<=60&& marks>50){
            System.out.println("Your Grade is C+");
        }
        else if(marks<=50&& marks>40){
            System.out.println("Your Grade is C");
        }
        else if(marks<=40&& marks>30){
            System.out.println("Your Grade is D");
        }
        else {
            System.out.println("Failed , Better luck next time !");
        }
    }
}
