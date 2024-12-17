public class Operations extends Calculator{

    public static double calc(String calculation) {
        // Space Removal
        calculation = calculation.replace(" ", "");
        String temp_calc;

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
            System.out.println("("+temp_calc+")");
            //do operations on temp calc
            while (temp_calc.contains("^"))
            {
                temp_calc = evaluate(temp_calc,"^");
            }
            while (temp_calc.contains("*")||temp_calc.contains("/"))
            {
                temp_calc = evaluate(temp_calc,"*/");
            }
            while (temp_calc.contains("+")||temp_calc.contains("-"))
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

        // ^ first cause of BIMDAS
        while (calculation.contains("^")) {
            calculation = evaluate(calculation, "^");
        }

        // Then we do * and /
        while (calculation.contains("*") || calculation.contains("/")) {
            calculation = evaluate(calculation, "*/");
        }

        // Then + and -
        while (calculation.contains("+") || calculation.contains("-")) {
            calculation = evaluate(calculation, "+-");
        }

        // The final calculation should now be a single number
        return Double.parseDouble(calculation);
    }

    private static String evaluate(String calculation, String operators) {

        int minus_count = 0;
        boolean minus_valid = false;
        for (int i = 0; i < calculation.length(); i++) { //for loop to make sure that all opperations of that type are completed
            char currentChar = calculation.charAt(i);
            if(currentChar=='-')
            {
                minus_count+=1;
            }
            else
            {
                minus_count = 0;
            }
            if (operators.indexOf(currentChar) != -1) {

                // Find the left operation
                int leftStart = i - 1;

                while (leftStart >= 0 && (Character.isDigit(calculation.charAt(leftStart)) || calculation.charAt(leftStart) == '.'||(calculation.charAt(leftStart)=='-'&&minus_count<3))) {
                    leftStart--;
                }
                leftStart++;
                System.out.println("Left Start: " + leftStart);
                System.out.println("i:"+ i);
                System.out.println(calculation.substring(leftStart, i));
                //my attempt at negative numbers, feel free to do what you have to
                double leftOperand;
                try {
                    leftOperand = Double.parseDouble(calculation.substring(leftStart, i));
                }
                catch (Exception e)
                {
                    continue;
                }
                // Find the right operation
                int rightEnd = i + 1;
                while (rightEnd < calculation.length() && (Character.isDigit(calculation.charAt(rightEnd)) || calculation.charAt(rightEnd) == '.')) {
                    rightEnd++;
                }

                double rightOperand;
                try {
                    rightOperand = Double.parseDouble(calculation.substring(i + 1, rightEnd));
                }
                catch (Exception e)
                {
                    continue;
                }
                // Perform the operation -temp
                double result = 0;
                switch (currentChar) {
                    case '^':
                        result = Math.pow(leftOperand, rightOperand);
                        break;
                    case '*':
                        result = leftOperand * rightOperand;
                        break;
                    case '/':
                        result = leftOperand / rightOperand;
                        break;
                    case '+':
                        result = leftOperand + rightOperand;
                        break;
                    case '-':
                        result = leftOperand - rightOperand;
                        break;
                }
                System.out.println(Double.toString(leftOperand) + (char)currentChar + Double.toString(rightOperand) +"="+result);
                // Replace the evaluated part of the calculation with the result
                calculation = calculation.substring(0, leftStart) + result + calculation.substring(rightEnd);
                System.out.println(calculation);
                break;
            }
        }

        return calculation;
    }
}
