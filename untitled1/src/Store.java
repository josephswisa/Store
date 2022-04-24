import com.sun.prism.shader.Solid_ImagePattern_Loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Product> products;
    private List<Employee> employees;
    private List<Costumer> costumers;

    public Store() {
        this.products = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.costumers = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return this.employees = employees;
    }

    public List<Costumer> getCostumers(){
        return this.costumers=costumers;
    }

    public List<Product> getProducts(){
        return this.products = products;
    }

    public void createUser () {
        Scanner scanner = new Scanner(System.in);
        String firstName;
            System.out.println("Enter your first Name");
            firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String  lastName = scanner.nextLine();
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
        boolean vipMember = false;
        Rank userRank = Rank.REGULAR;
        System.out.println("For user -1, For Employee -2");
        int accountChoice =scanner.nextInt();
        if(accountChoice == 1)
        {
            System.out.println("Are you a VIP member? 1-YES, 2-NO");
            int choice=scanner.nextInt();
            if(choice ==1) vipMember=true;
        }
        if(accountChoice == 2) {
            System.out.println("Choose your employee Rank");
            int rank1 = scanner.nextInt();
            switch(rank1) {
                case 1:
                    userRank = Rank.REGULAR;
                    break;
                case 2:
                    userRank = Rank.MANAGER;
                    break;
                case 3:
                    userRank =Rank.BOARD;
                    break;
            }
        }
        switch (accountChoice) {
            case 1:
                Costumer newCostumer = new Costumer(username,password,firstName,lastName,vipMember);
                this.costumers.add(newCostumer);
                break;
            case 2:
                Employee newEmployee = new Employee(username,password,firstName,lastName,userRank);
                this.employees.add(newEmployee);
                break;


        }

        System.out.println("The user was added");

    }

    public User login () {
        User found = null;
        boolean isEmployee = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User currentUser : this.employees) {
            if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
                found = currentUser;
                isEmployee = true;
                break;
            }
        }
        if (!isEmployee) {
            for (User currentUser : this.costumers) {
                if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
                    found = currentUser;
                    break;
                }
            }
        }
            return found;

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
        for (int i = 0; i < this.costumers.size(); i++) {
            User currentUser = this.costumers.get(i);
            if (currentUser != null) {
                if (currentUser.getUsername().equals(username)) {
                    exists = true;
                    break;
                }
            }
        }
                for (int i = 0; i < this.employees.size(); i++) {
                    User currentUser = this.employees.get(i);
                    if (currentUser != null) {
                        if (currentUser.getUsername().equals(username)) {
                            exists = true;
                            break;
                        }
            }
        }
        return exists;
    }

    public void showProductList(){
        for(int i=0;i<products.size();i++)
        {
            System.out.println(i+" "+products.get(i).getProductName()+" ,Quantity: "+products.get(i).getQuantity());
        }
    }




    public void purchase(User user) {
        Scanner scanner = new Scanner(System.in);
        List<Product> cartList = new ArrayList<>();
        double totalSum = 0;
        int quantityChoice;
        int costumerChoice=0;
        Cart newCart = new Cart(cartList, totalSum);
        while(costumerChoice != -1) {
            showProductList();
            System.out.println("Choose a product from the list");
            System.out.println("End purchase with -1");
            costumerChoice = scanner.nextInt();
            if(costumerChoice != -1) {
                System.out.println("Choose product quantity");
                quantityChoice = scanner.nextInt();
                if (getProducts().get(costumerChoice).getQuantity() >= quantityChoice) {
                    cartList.add(getProducts().get(costumerChoice));
                    totalSum += getProducts().get(costumerChoice).getPrice();
                    getProducts().get(costumerChoice).setQuantity(getProducts().get(costumerChoice).getQuantity() - quantityChoice);
                }
            }
            newCart.setProductList(cartList);
            newCart.setTotalCart(totalSum);
        }
        if(employees.contains(user)){
            switch( ((Employee)user).getRankType()){
                case REGULAR:
                    newCart.setTotalCart((newCart.getTotalCart())*0.9);
                    break;
                case MANAGER:
                    newCart.setTotalCart((newCart.getTotalCart())*0.8);
                    break;
                case BOARD:
                    newCart.setTotalCart((newCart.getTotalCart())*0.7);
                    break;
            }
        }
        System.out.println("The total cost of the cart was " + newCart.getTotalCart());
        user.setTotalPurchases(user.getTotalPurchases()+1);
        user.setTotalMoneySpent((int) (user.getTotalMoneySpent()+totalSum));
    }

    public void employeeMenu(User user) {
        int employeeChoice = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Print all the costumers");
            System.out.println("2. Print all the  VIP costumers");
            System.out.println("3. Print all the costumers that made atleast 1 sale");
            System.out.println("4. Print the highest buyer");
            System.out.println("5. Add a new product");
            System.out.println("6. Update quantity");
            System.out.println("7. Purchase");
            System.out.println("8.Logout");
            employeeChoice = scanner.nextInt();
            switch (employeeChoice) {
                case 1:
                    for (int i = 0; i < costumers.size(); i++) {
                        System.out.println(costumers.get(i).getFirstName() + "" + costumers.get(i).getLastName());
                    }
                    break;
                case 2:
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).isVip()) {
                            System.out.println(costumers.get(i).getFirstName() + "" + costumers.get(i).getLastName());
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < costumers.size(); i++) {
                        if (costumers.get(i).getTotalPurchases() >= 1) {
                            System.out.println(costumers.get(i).getFirstName() + " " + costumers.get(i).getLastName());
                        }
                    }
                    break;
                case 4:
                    int totalSpent = 0;
                    User found = null;
                    for (User currentUser : this.costumers) {
                        if (currentUser.getTotalMoneySpent() > totalSpent) {
                            totalSpent = currentUser.getTotalMoneySpent();
                            found = currentUser;
                        }
                    }
                    if (found == null) {
                        System.out.println("There is no costumer with the biggest purchase");
                    } else
                        System.out.println(found.getFirstName() + " " + found.getLastName() + " ,Total spent:" + found.getTotalMoneySpent());
                    break;
                case 5:

                    System.out.println("Enter the product name");
                    String productName = scanner.next();
                    System.out.println("Enter the product quantity");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter the product price");
                    int price = scanner.nextInt();
                    Product newProduct = new Product(productName, quantity, price);
                    products.add(newProduct);
                    break;
                case 6:
                    System.out.println("Choose a product from the list");
                    showProductList();
                    int productChoice = scanner.nextInt();
                    System.out.println("Enter the quantity");
                    int quantityChoice = scanner.nextInt();
                    products.get(productChoice).setQuantity(quantityChoice);
                    break;
                case 7:
                    purchase(user);
                    break;
                case 8:
                    break;
            }
        } while(employeeChoice !=8);





    }






}
