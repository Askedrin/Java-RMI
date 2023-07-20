import java.rmi.Naming;

public class client {
    public static void main(String[] args) {
        try {
            machineinterface iwto= (machineinterface) Naming.lookup("rmi://localhost:1234/OB");
            iwto.servclient();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
