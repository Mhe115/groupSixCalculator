import java.util.Scanner;
public class Calculator {

    public static String calculation = "";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your calculation: ");
        calculation = input.nextLine();
        Operations operation = new Operations();
        operation.Calculate();
        input.close();
    }
}