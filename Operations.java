import java.math.BigDecimal;

public class Operations extends Calculator{

    String input = "";
    String lastCalculate = "";
    Operations(){}

    protected void Calculate(){
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
}