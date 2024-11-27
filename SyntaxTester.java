public class SyntaxTester {
    public static void main(String args[])
    {
        String test = "-2*(-2/4)*(2*(4*2))";
        String[] test2 = test.split("\\(");
        for(int i = 0; i<test2.length; i++)
        {
            System.out.println(test2[i]);
        }
        SyntaxHandler syntaxHandler = new SyntaxHandler();
        if(!syntaxHandler.verifiyString(test))
        {
            System.out.println("INVALID");
        }
        else
        {
            System.out.println("VALID");
        }

    }
}
