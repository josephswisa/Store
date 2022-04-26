import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        Store store = new Store();
        do{
            System.out.println("1. Open a new account");
            System.out.println("2. Login to an existing account");
            System.out.println("3. Exit");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    store.createUser();
                    break;
                case 2:
                    User user = store.login();
                    if (user == null) {
                        System.out.println("Wrong credentials");
                    } else {
                        System.out.println("Welcome!");
                    }
                    if(store.getCostumers().contains(user)) {
                        ((Costumer)(user)).print();
                        store.purchase(user);
                    }
                    if(store.getEmployees().contains(user)) {
                        ((Employee) user).print();
                        store.employeeMenu(user);
                    }
                    break;
                case 3:
                    break;
            }

        } while (userChoice !=3);

    }












    }


