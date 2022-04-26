import java.util.ArrayList;

public class Costumer  extends  User{

    boolean vip;


    public Costumer(String username, String password, String firstName, String lastName, boolean vip) {
        super(username, password, firstName, lastName);
        this.vip = vip;
    }


    public boolean isVip() {
        return vip;
    }

    public void print() {
        super.print();
        System.out.println("VIP");
    }
}
