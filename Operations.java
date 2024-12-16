public class Operations extends Calculator{

    public static double calc(String calculation) {
        // Space Removal
        calculation = calculation.replace(" ", "");

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
        for (int i = 0; i < calculation.length(); i++) { //for loop to make sure that all opperations of that type are completed
            char currentChar = calculation.charAt(i);

            if (operators.indexOf(currentChar) != -1) {
                // Find the left operation
                int leftStart = i - 1;
                while (leftStart >= 0 && (Character.isDigit(calculation.charAt(leftStart)) || calculation.charAt(leftStart) == '.')) {
                    leftStart--;
                }
                leftStart++;

                double leftOperand = Double.parseDouble(calculation.substring(leftStart, i));

                // Find the right operstion
                int rightEnd = i + 1;
                while (rightEnd < calculation.length() && (Character.isDigit(calculation.charAt(rightEnd)) || calculation.charAt(rightEnd) == '.')) {
                    rightEnd++;
                }

                double rightOperand = Double.parseDouble(calculation.substring(i + 1, rightEnd));

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
                System.out.println(leftOperand + currentChar + rightOperand +"="+result);
                // Replace the evaluated part of the calculation with the result
                calculation = calculation.substring(0, leftStart) + result + calculation.substring(rightEnd);
                System.out.println(calculation);
                break;
            }
        }

        return calculation;
    }
}
