import java.net.*;
import java.rmi.*;

public class Server
{
    public static void main(String args[])
    {
        // or `java -Djava.rmi.server.hostname=192.168.2.1 Server`
        // System.setProperty("java.rmi.server.hostname","192.168.2.1");
        try {
            IArithmeticImpl impl = new IArithmeticImpl();
            Naming.rebind("api", impl);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
