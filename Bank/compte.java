import java.io.Serializable;

public class compte implements Serializable{
    int id;
    double solde;
    public compte(int id, double solde){
        super();
        this.id=id;
        this.solde=solde;
    }
    public int getid(){
        return id;
    }
    public double getsolde(){
        return solde;
    }
}

