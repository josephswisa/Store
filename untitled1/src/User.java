public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int totalMoneySpent;
    private int totalPurchases;


    public User(String username, String password, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalMoneySpent =0;
        this.totalPurchases=0;
    }

    public void setTotalMoneySpent(int totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public void setTotalPurchases(int totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public int getTotalPurchases() {
        return totalPurchases;
    }

    public String getFirstName() {
        return this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName = lastName;
    }


    public String getUsername() {
        return this.username = username;
    }

    public String getPassword () {return this.password = password;}

    public void print(){
        System.out.println("HELLO "+this.firstName +" "+lastName+" ");

    }



}
