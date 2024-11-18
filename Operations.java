import java.math.BigDecimal;

public class Operations extends Calculator{

    String input = "";
    Operations(){}

    protected String Calculate(){
        String result = "";
        //while (calculation.length() > 0) {

            if (calculation.split("\\*")[0].length() > calculation.split("\\/")[0].length()){
                //Multiplication
            }
            
            if (calculation.split("\\*")[0].length() < calculation.split("\\/")[0].length()){
                //Division
            }

            if (calculation.split("\\+")[0].length() > calculation.split("\\-")[0].length()){
                //Addition
            }

            else if (calculation.split("\\+")[0].length() < calculation.split("\\-")[0].length()){
                //Subtraction
            }

            
        //}

        return result;
    }
}