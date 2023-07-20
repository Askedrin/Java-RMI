import java.rmi.Remote;
import java.rmi.RemoteException;
public interface machineinterface  extends Remote{
    
    public Boolean verifypiece(int piece)throws RemoteException;
    public void servclient()throws RemoteException;
    public void givechange(int choice) throws RemoteException;
    
}
