public class Operations{

    public static double calc(String calculation) {
        // Space Removal
        calculation = calculation.replace(" ", "");
        String temp_calc;

        //rearanging brackets that indicate multiplication e.g 2(9+8) >>>> 2*(9+8)
        if (calculation.matches(".*\\d\\(.*") || calculation.matches(".*\\d\\(.*")) { //.* just means anything can be there \\d means any digit (0-9) and ( means an open bracket
            // Replace digit followed by an open bracket 8( -> 8*(
            calculation = calculation.replaceAll("(\\d)(\\()", "$1*$2"); //$1 means the first chunk of String e.g in 8(9) it would be 8

            // Replace closing bracket followed by a digit )9 -> )*9
            calculation = calculation.replaceAll("(\\))(\\d)", "$1*$2"); //$2 means the second chunck of String e.g in 8(9) it would be (9)
        }

        //do brackets first
        while (calculation.contains("(")||calculation.contains(")"))
        {
            //The first closed bracket will be nearest to the last open bracket which is what we need to check so we cut off
            //up until the first closed bracket to make sure we don't get wierd edge cases like 2+(4*2)+(3-2)
            int closed_bracket_index = calculation.indexOf(")");
            String bracket_finder = calculation.substring(0,closed_bracket_index);
            int open_bracket_index = bracket_finder.lastIndexOf("(");
            //get the calculation inside the brakets we're looking for
            temp_calc=calculation.substring(open_bracket_index+1,closed_bracket_index);
            //System.out.println("("+temp_calc+")");
            //do operations on temp calc
            while (temp_calc.contains("^"))
            {
                temp_calc = evaluate(temp_calc,"^");
            }
            while (temp_calc.contains("*")||temp_calc.contains("/"))
            {
                temp_calc = evaluate(temp_calc,"*/");
            }
            while (temp_calc.contains("+")||(temp_calc.matches(".*\\d-.*") && !(temp_calc.charAt(0) == '-') && temp_calc.contains("-"))) // this ensures that - is only evaluated when it means take not for a negitive num
            {
                temp_calc = evaluate(temp_calc,"+-");
            }
            //create a string builder with our calculation string
            //stringbuilder was chosen because it allows for more powerful and efficent editing of strings
            StringBuilder calc_sb = new StringBuilder(calculation);
            //we delete the brakets and insert the result into their place
            calc_sb.delete(open_bracket_index,closed_bracket_index+1);
            calc_sb.insert(open_bracket_index,temp_calc);
            //System.out.println("String builder " +calc_sb);
            //convert out string builder into a string and set calculation equal to it
            calculation = calc_sb.toString();
            System.out.println(calculation);


        }
        
        // ^ next cause of BIMDAS
        while (calculation.contains("^")) {
            calculation = evaluate(calculation, "^");
        }
        
        // Then we do * and /
        while (calculation.contains("*") || calculation.contains("/")) {
            calculation = evaluate(calculation, "*/");
        }

        // Then + and -
        while (calculation.contains("+") || (calculation.matches(".*\\d-.*") && !(calculation.charAt(0) == '-') && calculation.contains("-"))) { // this ensures that - is only evaluated when it means take not for a negitive num
            calculation = evaluate(calculation, "+-");
        }

        // The final calculation should now be a single number
        return Double.parseDouble(calculation);
    }

    private static String evaluate(String calculation, String operators) {
        //System.out.println(calculation);
        //int minus_count = 0;
        //boolean minus_valid = false;
        double leftOperand = 0, rightOperand = 0; //make sure they are init or it will give out
        for (int i = 0; i < calculation.length(); i++) { //for loop to make sure that all opperations of that type are completed
            char currentChar = calculation.charAt(i);
            if (operators.indexOf(currentChar) != -1) { //if curren7+(2*-2)t char exists here

                // Find the left operand
                int leftStart = i - 1;

                while (leftStart >= 0 && (Character.isDigit(calculation.charAt(leftStart)) || calculation.charAt(leftStart) == '.' || (calculation.charAt(leftStart) == '-') && (leftStart == 0 || !Character.isDigit(calculation.charAt(leftStart - 1))))) {
                    leftStart--;
                }
                leftStart++;
                //System.out.println("Left Start: " + leftStart);
                //System.out.println("i:"+ i);
                //System.out.println(calculation.substring(leftStart, i));
                try {
                    leftOperand = Double.parseDouble(calculation.substring(leftStart, i));
                }
                catch (Exception e)
                {
                    System.err.println("Left Opp error:" + e);
                    System.exit(0);
                }
                // Find the right operand
                int rightEnd = i + 1;
                if (calculation.charAt(rightEnd) == '-') {
                    rightEnd++; // Move past the negative sign
                }
                while (rightEnd < calculation.length() && (Character.isDigit(calculation.charAt(rightEnd)) || calculation.charAt(rightEnd) == '.')) {
                    rightEnd++;
                }

                try {
                    rightOperand = Double.parseDouble(calculation.substring(i + 1, rightEnd));
                }
                catch (Exception e)
                {
                    System.err.println("Right Opp error:" + e);
                }
                // Perform the operation -temp
                try {
                double result = 0;
                switch (currentChar) {
                    case '^':
                        result = Math.pow(leftOperand, rightOperand);
                        break;
                    case '*':
                        Multiplication multiplication = new Multiplication();
                        result = multiplication.Execute(leftOperand, rightOperand);
                        break;
                    case '/':
                        Division division = new Division();
                        result = division.Execute(leftOperand, rightOperand);
                        break;
                    case '+':
                        Addition addition = new Addition();
                        result = addition.Execute(leftOperand, rightOperand);
                        break;
                    case '-':
                        Subtraction subtraction = new Subtraction();
                        result = subtraction.Execute(leftOperand, rightOperand);
                        break;
                }
                System.out.println(Double.toString(leftOperand) + (char)currentChar + Double.toString(rightOperand) +" = "+result);
                // Replace the evaluated part of the calculation with the result
                calculation = calculation.substring(0, leftStart) + result + calculation.substring(rightEnd);
                System.out.println(calculation);
                break;
                } catch (Exception e) {
                    System.err.println("Final errors" + e);
                }
            }
        }
        return calculation;
    }
}
