import java.math.BigDecimal;

public class Operations extends Calculator{

    String input = "";
    String lastCalculate = "";
    String temp_calculation = "null";
    int insert_point = 0;
    Operations(){}

    protected void Calculate(){
        FindBrackets();
        if (calculation.split("\\*")[0].length() < calculation.split("\\/")[0].length()){
            //Multiplication
            Multiplication multiplication = new Multiplication(getA(), getB());
            calculation = multiplication.multiply().toString()  + calculation;
            System.out.println(calculation);
        }
            
        if (calculation.split("\\/")[0].length() < calculation.split("\\*")[0].length()){
            //division
            Division division = new Division(getA(), getB());
            calculation = division.divide().toString() + calculation;
            System.out.println(calculation);
        }
 
        //Addition
        //----------------------------------\\
        if(!temp_calculation.equals("null"))
        {
            calculation = temp_calculation.substring(0,insert_point) + calculation + temp_calculation.substring(insert_point);
            System.out.println(calculation);
            temp_calculation = "null";
            //
        }
        if (lastCalculate != calculation){
            lastCalculate = calculation;
            Calculate();
        }

    }

    private String getNextNum(){
        String runningNum = calculation.split("\\*")[0];
        runningNum = runningNum.split("\\/")[0];
        runningNum = runningNum.split("\\+")[0];
        if (runningNum.split("\\-")[0].length() != 0) {
            runningNum = runningNum.split("\\-")[0];    
        }
        
        return runningNum;
    }

    private BigDecimal getA(){
        //Finds the next number in the string and shortens calculation accordingly
        BigDecimal a = new BigDecimal(getNextNum());
        try{
            calculation = calculation.substring(getNextNum().length() + 1, calculation.length());
        } catch(StringIndexOutOfBoundsException e){
            calculation = "";
        }
        return a;
        
    }

    private BigDecimal getB(){
        //Finds the next number in the string and shortens calculation accordingly
        BigDecimal b = new BigDecimal(getNextNum());
        try{
            calculation = calculation.substring(getNextNum().length(), calculation.length());
        } catch(StringIndexOutOfBoundsException e){
            calculation = "";
        }

        return b;
    }
    private void FindBrackets()
    {
        boolean opened_bracket = false;
        boolean found_closed_bracket = false;
        int open_bracket_index = 0;
        int bracket_end_index = 0;


        for (int i = 0; i < calculation.length(); i++)
        {

            if(calculation.charAt(i)=='(')
            {
                opened_bracket = true;
                open_bracket_index = i;
            }
            if (calculation.charAt(i)==')' && opened_bracket) {
                found_closed_bracket = true;
                int end_point = calculation.length()-1;
                bracket_end_index = i;
                if(bracket_end_index+1>calculation.length()-1)
                {
                    bracket_end_index = i;
                }
                else
                {
                    bracket_end_index = i+1;
                    end_point = calculation.length();
                }

                temp_calculation = calculation.substring(0,open_bracket_index) + calculation.substring(bracket_end_index,end_point);
                bracket_end_index = i;
                insert_point = open_bracket_index;
                calculation = calculation.substring(open_bracket_index+1,bracket_end_index);
                System.out.println(
                        "temp calc: " + temp_calculation + "\n" + "calc:" + calculation + "\n" +
                        "("+calculation+")"
                );
                break;
            }
        }
    }
}