import java.math.BigDecimal;

public class Operations extends Calculator{

    String input = "";
    String lastCalculate = "";
    Operations(){}

    protected void Calculate(){
        String result = "";
            if (calculation.split("\\*")[0].length() < calculation.split("\\/")[0].length()){
                BigDecimal a = new BigDecimal(getNextNum());
                try{
                    calculation = calculation.substring(calculation.split("\\*")[0].length() + 1, calculation.length());
                } catch(StringIndexOutOfBoundsException e){
                    calculation = "";
                }
                BigDecimal b = new BigDecimal(getNextNum());
                try{
                    calculation = calculation.substring(getNextNum().length(), calculation.length());
                } catch(StringIndexOutOfBoundsException e){
                    calculation = "";
                }
                
                //Multiplication
                Multiplication multiplication = new Multiplication(a, b);
                calculation = multiplication.multiply().toString()  + calculation;
                System.out.println(calculation);
            }
            
            if (calculation.split("\\/")[0].length() < calculation.split("\\*")[0].length()){
                BigDecimal a = new BigDecimal(calculation.split("\\/")[0]);
                BigDecimal b = new BigDecimal(getNextNum());
                calculation = calculation.substring(calculation.split("\\/")[0].length() + getNextNum().length() + 1, calculation.length());
                System.out.println(a + " " + calculation + " " + b);
                //division
                Division division = new Division(a, b);
                calculation = division.divide().toString() + calculation;
                System.out.println(calculation);
            }

            else {
                //Addition
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
        runningNum = runningNum.split("\\-")[0];
        return runningNum;
    }
}