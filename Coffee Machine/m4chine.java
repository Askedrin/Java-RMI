import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class m4chine extends UnicastRemoteObject implements machineinterface {
    public m4chine()throws RemoteException {
        super();    
    }
    order order1= new order();
    public static void main(String[] args){
        
        
        try {
            m4chine obj= new m4chine();
            LocateRegistry.createRegistry(1234);
            Naming.rebind("rmi://localhost:1234/OB", obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Boolean verifypiece(int piece){
        if (piece== 10 || piece==20 || piece==50 ||piece==100){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void servclient(){
        int cont=1;
        Scanner pcsscn= new Scanner(System.in);
        Scanner contscn= new Scanner(System.in);
        Scanner chscn = new Scanner(System.in);
        int ch;
        Scanner contscn2= new Scanner(System.in);
        while(cont==1){
            System.out.println("\t\t please insert your piece: ");
            
            int piecei= pcsscn.nextInt();
            if(verifypiece(piecei)){
                order1.change=order1.change+piecei;
            }else{
                System.out.println("sorry this piece is not accepted !");
            }
            
            

            System.out.println("do you want to add another piece ?: 1 for yes ");
            
            cont= contscn.nextInt();
        }

        System.out.println(order1.change);
        System.out.println("\t cool now you have entered all the pieces you need, time to order \t");
   
        int cont2=1;
        while(cont2==1){

            System.out.println("what do you want to order, cafe(0) or biscuits(1) ?: ");
            ch= chscn.nextInt();

            givechange(ch);
            System.out.println("do you want to order something else ?: 1 for yes ");
            
            cont2= contscn2.nextInt();
        }
        System.out.println("here is what you ordered: \t\t");
        System.out.println(order1.orders);
        System.out.println("here is the change: \t\t");
        System.out.println(order1.change);
   
    }

    @Override
    public void givechange(int choice){
        if(choice==0){
            order1.orders=order1.orders+" cafe";
            order1.change=order1.change-50;
            System.out.println("cafe added !");
        }else if( choice==1){
            order1.orders=order1.orders+" biscuits";
            order1.change=order1.change-30;
            System.out.println("biscuits added !");
        }else{
            System.out.println("sorry we don't have what you asked for !");
        }
    }
    

}
