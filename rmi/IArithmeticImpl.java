import java.rmi.*;
import java.rmi.server.*;

public class IArithmeticImpl extends UnicastRemoteObject implements IArithmetic
{
    public IArithmeticImpl() throws RemoteException
    {
    }

    public double add(double d1, double d2) throws RemoteException
    {
        return d1 + d2;
    }
}
