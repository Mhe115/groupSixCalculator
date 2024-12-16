import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
//create an enumerator for each of the different menus
enum mode
{
    MAINMENU,
    CALCULATOR,
    QUADRATICCALC,
    RANDOMQUESTION,
};

public class Main {
    public static void main(String[] args)
    {
        //print out a little title
        System.out.println("Welcome to Group 6 Calculator");
        //create instances of objects we need to use
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();
        QuadraticCalc qcalc = new QuadraticCalc();
        //create the variables for managing our menu
        QuadraticRandom randomq = new QuadraticRandom();
        boolean using_program = true;
        mode Current_menu = mode.MAINMENU;
        String user_input;

        while (using_program)
        {
            switch (Current_menu) {
                case MAINMENU:
                    //in the main menu we present options of submenus the user can enter by inputting a number
                try {
                    System.out.println("Press the numbers to acess the respective tools of this program\n" +
                            "1 - Calculator     2 - Quadratic calculator    3 - Problem Generator   4 - Exit Program");
                    switch (input.nextInt()) {
                        case 1:
                            Current_menu = mode.CALCULATOR;
                            break;
                        case 2:
                            Current_menu = mode.QUADRATICCALC;
                            break;
                        case 3:
                            Current_menu = mode.RANDOMQUESTION;
                            break;
                        case 4:
                            using_program = false;
                            break;
                        default:
                            //if a user types something invalid, we throw an error to catch
                            throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    //if the user typed something invalid. We tell them what happened
                    //and let them input again
                    input.nextLine();
                    System.out.println("Invalid input, please only enter the designated numbers");
                }
                break;
                case CALCULATOR:
                    //in this menu, we use the calculator class to preform calculations

                    System.out.println("Enter your calculation: (type 'esc' to go back to main menu)");
                    user_input = input.next();
                    if(user_input.equals("esc"))
                    {
                        Current_menu = mode.MAINMENU;
                    }
                    else {
                        String calculation = user_input;
                        SyntaxHandler tester = new SyntaxHandler();
                        //allow the user to input, if what they enter is valid according to the verify string
                        //method, we calcualte using that input
                        if(tester.verifiyString(calculation)) {
                            calc.UseCalculator(calculation);
                        }
                        else
                        {
                            input.nextLine();
                        }

                        //input.close();
                    }
                    break;
                case QUADRATICCALC:
                    System.out.println("Enter your quadratic in the form of a,b,c where ax^2 + bx + c=0: (type 'esc' to go back to main menu)");
                    user_input = input.next();
                    try {
                        if (user_input.equals("esc")) {
                            Current_menu = mode.MAINMENU;
                        } else {
                            String calculation = user_input;
                            SyntaxHandler tester = new SyntaxHandler();
                            String[] num_array = calculation.split(",");
                            System.out.println(Arrays.toString(num_array));
                            //allow the user to input, if what they enter is valid according to the verify string
                            //method, we calcualte using that input
                            if (tester.veriftyQuadratic(calculation)) {

                                qcalc.solveEquation(Double.valueOf(num_array[0]), Double.valueOf(num_array[1]), Double.valueOf(num_array[2]));
                            } else {
                                System.out.println("Invalid formatting");
                                throw new NumberFormatException();

                            }
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        input.nextLine();
                    }
                    break;
                case RANDOMQUESTION:
                    randomq.questionmethod();
                    break;
            }
        }

    }
}
