import java.rmi.*;

public class Client
{
    public static void main(String args[])
    {
        try {
            String serverURL = "rmi://" + args[0] + "/api";

            IArithmetic interface_arithmetic
                = (IArithmetic)Naming.lookup(serverURL);

            double d1 = Double.valueOf(args[1]).doubleValue();
            double d2 = Double.valueOf(args[2]).doubleValue();

            System.out.println("The sum is: "
                               + interface_arithmetic.add(d1, d2));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
