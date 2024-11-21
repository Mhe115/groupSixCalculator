import java.math.BigDecimal;

public class Multiplication extends Operations{

    BigDecimal a = new BigDecimal(0);
    BigDecimal b = new BigDecimal(0);
    Multiplication(BigDecimal a, BigDecimal b){
        this.a = a;
        this.b = b;
    }

    public BigDecimal multiply(){
        return a.multiply(b);
    }
}