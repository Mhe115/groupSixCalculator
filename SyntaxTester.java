public class SyntaxTester {
    public static void main(String args[])
    {
        String test = "2 + 2";
        SyntaxHandler syntaxHandler = new SyntaxHandler();
        if(!syntaxHandler.verifiyString(test))
        {
            System.out.println("INVALID");
        }
        else
        {
            System.out.println();
        }

    }
}
