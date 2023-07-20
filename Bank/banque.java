
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface banque extends Remote {
    void crediter(int id, double solde) throws RemoteException;
    void debiter(int id, double solde) throws RemoteException;
    List<compte> list() throws RemoteException;
    double liresolde (int id) throws RemoteException;
}

