import java.util.Scanner;

public class TempConverter {
    public TempConverter() {
    }

    public static void CelToFah() {
        System.out.println("Enter temperature in celsius : ");
        Scanner sc = new Scanner(System.in);
        double tempC = (double)sc.nextInt();
        double tempF = tempC * 1.8 + 32.0;
        System.out.println("Temperature in Fahrenheit is : " + tempF);
    }

    public static void FahToCel() {
        System.out.println("Enter temperature in Fahrenheit : ");
        Scanner sc = new Scanner(System.in);
        double tempF = (double)sc.nextInt();
        double tempC = (tempF - 32.0) / 1.8;
        System.out.println("Temperature in Celsius is : " + tempC);
    }

    public static void main(String[] args) {
        System.out.println("1 : Celsius to Fahrenheit \n2 : Fahrenheit to Celsius ");
        System.out.println("Enter option :");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1 -> CelToFah();
            case 2 -> FahToCel();
        }

    }
}
