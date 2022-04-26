import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        RealEstate realEstate = new RealEstate();
        do {
            System.out.println("What do you want to do? ");
            System.out.println("1 - Create account");
            System.out.println("2 - Login to your account");
            System.out.println("3 - Exit");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    realEstate.createUser();
                    break;
                case 2:
                    User user = realEstate.login();
                    if (user == null) {
                        System.out.println("Wrong credentials");
                    } else {
                        System.out.println("Welcome!");
                    }
                    break;
                case 3:
                    break;
            }
        } while (userChoice != 3);

    }
}
