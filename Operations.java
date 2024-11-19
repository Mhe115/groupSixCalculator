import java.math.BigDecimal;

public class Operations extends Calculator{

    String input = "";
    Operations(){}

    protected void Calculate(){
        String result = "";
        //while (calculation.length() > 0) {
        System.err.println("* = " + calculation.split("\\*")[0].length());
        System.err.println("/ = " + calculation.split("\\/")[0].length());
            if (calculation.split("\\*")[0].length() < calculation.split("\\/")[0].length()){
                BigDecimal a = new BigDecimal(calculation.split("\\*")[0]);
                calculation = calculation.substring(calculation.split("\\*")[0].length() + 1, calculation.length());
                BigDecimal b = new BigDecimal(getNextNum());
                System.out.println(a + " " + calculation + " " + b);
                //Multiplication
            }
            
            if (calculation.split("\\/")[0].length() > calculation.split("\\+")[0].length()){
                //Division
            }

            else {
                //Addition
            }

            
        //}

        //return result;
    }

    private String getNextNum(){
        String runningNum = calculation.split("\\*")[0];
        runningNum = calculation.split("\\/")[0];
        runningNum = calculation.split("\\+")[0];
        return runningNum;
    }
}