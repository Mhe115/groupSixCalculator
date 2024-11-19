public class SyntaxHandler {
    public boolean verifiyString(String input)
    {
        boolean valid = true;
        int open_bracket = 0;
        //remove the
        input = input.replace(" ","");

        //go through and process the string
        for (int i = 0; i<input.length(); i++)
        {
            /*
            first check if every mathmematical operator has a second numberical component
             */
            char test_chr = input.charAt(i);
            switch (test_chr) {
                case '+':
                    //case '-':
                case '/':
                case '*':
                case '%':
                case '^':
                    try {
                        String value_after_operation = String.valueOf(input.charAt(i + 1));


                        try {
                            Double num = Double.parseDouble(value_after_operation);
                        } catch (NumberFormatException e) {
                            valid = false;
                            System.out.println("Syntax Error: please fully complete the operation");
                        }
                    } catch (IndexOutOfBoundsException e)
                    {
                        valid = false;
                        System.out.println("Syntax Error: please fully complete the operation");
                    }
                    break;
                case '(':
                    open_bracket ++;
                    break;
                case ')':
                    open_bracket --;
                    break;
            }
            //System.out.println(input);
        }

        if(open_bracket!=0)
        {
            valid = false;
            System.out.println("Syntax Error: please close all brackets in your operation" + open_bracket);
        }


        return valid;
    }
}
