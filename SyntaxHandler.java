public class SyntaxHandler {
    public boolean verifiyString(String input)
    {
        boolean valid = true;
        //this is used to check if negative numbers are valid
        int negative_count = 0;
        //remove the spaces from the string to make it consistent
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
                        if(negative_count>2)//there would be no reason for three - to appear in a row
                        {
                            valid = false;
                        }
                    }
                    else {
                        negative_count = 0;
                    }
                    String value_after_operation = String.valueOf(input.charAt(i+1));
                    //allow negative numbers
                    char next_char = input.charAt(i+1);
                    if(next_char!='-'&&next_char!='('&&next_char!=')') {
                        try { //check if the number after the operand is a number
                            Double num = Double.parseDouble(value_after_operation);
                            //if it isn't a number, this will throw an error
                        } catch (NumberFormatException e) {
                            valid = false;
                            //System.out.println(input.charAt(i+1));
                            int char_id = input.charAt(i+1);
                            if(char_id>=65&&char_id<=90||char_id>=97&&char_id<=122) //test to see if its a letter
                            {
                                System.out.println("Invalid Calculation: Unexpected letter/unassigned variable");
                            }
                            else if(char_id==42||char_id==43||char_id==45||char_id==47||char_id==94){
                                System.out.println("Invalid Calculation: Expected two operands for every operator");
                            }
                            else
                            {
                                System.out.println("Invalid Calculation: Unexpected character, not compatible with calculator");
                            }
                        }
                    }
                    break;
            }
            //System.out.println(input);
        }




        return valid;
    }
    public boolean veriftyQuadratic(String input)
    {
        boolean valid = true;
        int comma_count = 0;
        input = input.replace(" ", "");
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(i))
            {
                if(input.charAt(i)!=',')
                {
                    //valid=false;
                }
                else
                {
                    comma_count+=1;
                    if(comma_count>3)
                    {
                        valid = false;
                    }
                }
            }
        }
        System.out.println("Clac is:" + valid);
        return valid;
    }
}
