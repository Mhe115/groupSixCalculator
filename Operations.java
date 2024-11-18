import java.math.BigDecimal;

public class Operations extends Calculator{

    String input = "";
    Operations(){}

    protected String Calculate(){
        String result = "";
        //while (calculation.length() > 0) {

            if (calculation.split("\\*")[0].length() > calculation.split("\\/")[0].length() & calculation.split("\\*")[0].length() > calculation.split("\\+")[0].length()){
                BigDecimal a = new BigDecimal(calculation.split("\\*")[0]);
                calculation = calculation.substring(calculation.split("\\*")[0].length(), 0);
                //Multiplication
            }
            
            if (calculation.split("\\/")[0].length() > calculation.split("\\+")[0].length()){
                //Division
            }

            else {
                //Addition
            }

            
        //}

        return result;
    }
}