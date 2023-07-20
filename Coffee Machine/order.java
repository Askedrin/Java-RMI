import java.io.Serializable;

public class order implements Serializable {
    String orders;
    int change;
    public order(){
        this.orders="";
        this.change=0;
    }
}
