import java.util.Scanner;
public class Calculator {

    public static String calculation = "";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your calculation: ");
        calculation = input.nextLine();
        System.out.println("");
        Operations operation = new Operations();
        System.out.println(operation.Calculate());
        input.close();

    }
}