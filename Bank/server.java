import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class server extends UnicastRemoteObject implements banque{
    static List<compte> liste= new ArrayList<compte>();
    public server() throws RemoteException{
        super();
    }
    public static void main(String[] args) {
        compte c1= new compte(1,20000);
        compte c2= new compte(2, 50000);
        liste.add(c1);
        liste.add(c2);



        

        try{
            LocateRegistry.createRegistry(4444);
            server obj= new server();
            Naming.rebind("rmi://localhost:4444/OB", obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void crediter(int id, double solde)throws RemoteException{
        for ( compte c: liste){
            if(c.getid()==id){
                c.solde=c.solde+solde;
            }
        }

    }

    @Override
    public void debiter(int id, double solde) throws RemoteException{
        for ( compte c: liste){
            if(c.getid()==id){
                c.solde=c.solde-solde;
            }
        }
    }
    @Override
    public double liresolde(int id){
        double lire_solde=0;
        for(compte c: liste){
            if(c.id==id){
                lire_solde= c.solde;
            }
        }
        return lire_solde;
    }
    @Override
    public List<compte> list(){
        return liste;
    }
    
}
