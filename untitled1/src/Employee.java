public class Employee extends User {
    Rank rankType;

    public Employee(String username, String password, String firstName, String lastName,Rank rankType) {
        super(username, password, firstName, lastName);
        this.rankType = rankType;
    }

    public Rank getRankType() {
        return rankType;
    }

    public void print(){
        super.print();
        System.out.println("RANK: "+rankType);
    }
}
