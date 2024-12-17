import java.util.Scanner;
import java.util.Random;

public class QuadraticRandom extends QuadraticCalc{

    private double[][] Questions = {
            {1, -3, 2},
            {1, 2, 1},
            {2, 5, -3},
            {1, 0, -4},
            {3, -7, 2}
    };

    private Random random = new Random();

    private int getRandomIndex() {
        return random.nextInt(Questions.length);
    }

    public double[] getRandomQuestion() {
        return Questions[getRandomIndex()];
    }


    public void displayQuestion(double[] question) {
        // Display the quadratic equation using println
        System.out.println("Welcome to the random Quadratic equation generator! This provides a question and its relative solution.\nHere is your quadratic equation:" + question[0] + "x² + " + question[1] + "x + " + question[2] + " = 0");
    }
    public void questionmethod(String user_input) {
        QuadraticCalc minusb = new QuadraticCalc();
        QuadraticRandom quadraticRandom = new QuadraticRandom();
        //Scanner input = new Scanner(System.in);
        double[] question = quadraticRandom.getRandomQuestion();
        quadraticRandom.displayQuestion(question);
        System.out.println("Enter 1 to show the Solution, or anything else to move to the next question\ntype esc to exit to main menu");

        if (user_input.equals("1")) {
            quadraticRandom.solveEquation(question[0], question[1], question[2]);

        } else { //System.out.println("1 was not entered. The question will not be displayed. Exiting");

        }  }  }
