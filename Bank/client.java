import java.rmi.Naming;

public class client {
    public static void main(String[] args) {
        try{
            banque stub=(banque) Naming.lookup("rmi://localhost:4444/OB");
            double s=stub.liresolde(1);
            System.out.println(s);
            stub.crediter(1, 10000);
            s= stub.liresolde(1);
            System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
