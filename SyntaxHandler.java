public class SyntaxHandler {
    public boolean verifiyString(String input)
    {
        boolean valid = true;
        int negative_count = 0;
        //remove the
        input = input.replace(" ","");

        //go through and process the string
        for (int i = 0; i<input.length(); i++)
        {
            /*
            first check if every mathmematical operator has a second numberical component
             */
            char test_chr = input.charAt(i);
            switch (test_chr)
            {
                case '+':
                case '-':
                case '/':
                case '*':
                case '%':
                case '^':
                    if(test_chr=='-')
                    {
                        negative_count +=1;
                        if(negative_count>2)
                        {
                            valid = false;
                        }
                    }
                    else {
                        negative_count = 0;
                    }
                    String value_after_operation = String.valueOf(input.charAt(i+1));
                    //allow negative numbers
                    if(input.charAt(i+1)!='-') {
                        try {
                            Double num = Double.parseDouble(value_after_operation);
                        } catch (NumberFormatException e) {
                            valid = false;
                        }
                    }

                    break;
            }
            //System.out.println(input);
        }




        return valid;
    }
}
