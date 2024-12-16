import java.math.BigDecimal;

public class Division extends Operations{

    BigDecimal a = new BigDecimal(0);
    BigDecimal b = new BigDecimal(0);
    Division(BigDecimal a, BigDecimal b){
        this.a = a;
        this.b = b;
    }

    public BigDecimal divide(){
        try
        {
            return a.divide(b);
        }
        catch (ArithmeticException e)
        {

        }

        return null;
    }
}