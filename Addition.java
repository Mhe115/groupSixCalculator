import java.math.BigDecimal;

public class Addition extends Operations{

    BigDecimal a = new BigDecimal(0);
    BigDecimal b = new BigDecimal(0);
    Addition (BigDecimal a, BigDecimal b){
        this.a = a;
        this.b = b;
    }
    public BigDecimal Add(){
        return a.add(b);
    }
}