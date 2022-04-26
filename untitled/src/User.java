public class User {
    private String username;
    private String password;
    private String phone;
    private boolean broker;

    public User(String username, String password, String phone,
                boolean broker) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.broker = broker;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword() {
        return password;
    }
}
