import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealEstate {
    private Address[] addresses;
    private Property[] properties;
    private List<User> users;

    public RealEstate () {
        this.users = new ArrayList<>(); //TODO: decide which list to use
    }

    public void createUser () {
        Scanner scanner = new Scanner(System.in);
        String username = null;
        do {
            System.out.println("Enter username: ");
            username = scanner.nextLine();
        } while (this.usernameExists(username));
        System.out.println("Your username is OK!");
        String password = null;
        do {
            System.out.println("Enter a password: ");
            password = scanner.nextLine();
        } while (!this.isStrongPassword(password));
        System.out.println("Your password is strong!");

        String phone = null;
        do {
            System.out.println("Enter a phone: ");
            phone = scanner.nextLine();
        } while (!this.isValidCellPhone(phone));
        System.out.println("Your phone is valid");
        System.out.println("Are you a broker? ");
        String brokerAnswer = scanner.nextLine();
        boolean broker = false;
        if (brokerAnswer.equals("Yes")) {
            broker = true;
        }
        User newUser = new User(username, password, phone, broker);
        this.users.add(newUser);
        System.out.println("The user was added!");
    }

    private boolean isValidCellPhone (String phone) {
        boolean valid = false;
        boolean validLength = false;
        boolean onlyDigits = true;
        boolean validStart = false;
        if (phone.length() == 10) {
            validLength = true;
        }
        if (phone.startsWith("05")) {
            validStart = true;
        }
        for (int i = 0; i < phone.length(); i++) {
            char currentChar = phone.charAt(i);
            if (!Character.isDigit(currentChar)) {
                onlyDigits = false;
                break;
            }
        }

        if (validLength && onlyDigits && validStart) {
            valid = true;
        }
        return valid;
    }

    private boolean isStrongPassword (String password) {
        boolean strong = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (Character.isDigit(currentChar)) {
                containsDigit = true;
            } else {
                if (currentChar == '_' || currentChar == '%' || currentChar == '$') {
                    containsSpecialChar = true;
                }
            }
        }
        if (containsDigit && containsSpecialChar) {
            strong = true;
        }
        return strong;
    }

    private boolean usernameExists (String username) {
        boolean exists = false;
        for (int i = 0; i < this.users.size(); i++) {
            User currentUser = this.users.get(i);
            if (currentUser != null) {
                if (currentUser.getUsername().equals(username)) {
                    exists = true;
                    break;
                }
            }
        }
        return exists;
    }

    public User login () {
        User found = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User currentUser : this.users) {
            if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
                found = currentUser;
                break;
            }
        }
        //use stream instead of loop
        return found;
    }
}
