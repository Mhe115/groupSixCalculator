import java.util.Scanner;
public class Calculator {

    public static String calculation = "";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your calculation: ");
        calculation = input.nextLine();
        calculation = calculation.replace(" ","");
        Calculator calculator = new Calculator();
        calculator.UseCalculator(calculation);
        input.close();

    }
    public void UseCalculator(String input)
    {


        //SyntaxHandler syntax = new SyntaxHandler();

        Operations.calc(input.replace(" ",""));

        //input.close();
    }
}