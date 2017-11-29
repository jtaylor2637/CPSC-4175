/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The application test class which runs all the main methods and menus for the application. 
 * @author jtayl
 */
public class ImplementationNoGUI {
    /*
    establishes the connection to the sql database
    */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters and location
            String schoolurl = "jdbc:sqlite:H:/Software Engineering/Project/Implem3/Implem2 with database/sqlite-tools-win32-x86-3200100/pd.db";
            String homeurl = "jdbc:sqlite:C:/Users/jtayl/Documents/Documents/CSU/Software Engineering/Project/Implem3/Implem2 with database/sqlite-tools-win32-x86-3200100/pd.db";
            // create a connection to the database
            conn = DriverManager.getConnection(schoolurl);
            
            System.out.println("Connection to SQLite has been established.\n");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /*
    main menu display function
    with 7 main options for the user to choose from
    auto = automatic testing on or off
    this function loops until the user inputs a correct option
    */
    public static int displayMenu(boolean auto){
        ArrayList<Integer> choices = new ArrayList<Integer>();
        choices.add(1);
        choices.add(2);
        choices.add(3);
        choices.add(4);
        choices.add(5);
        choices.add(6);
        choices.add(7);
        Scanner scan = new Scanner(System.in);
        int userChoice = 0;
        int count = 0;
        do{
            if(count != 0){
                System.out.println("Please only input a valid choice 1-6!");
            }
            System.out.println("Welcome to the main menu!");
            System.out.println("Enter 1 to view available items from the store.");
            System.out.println("Enter 2 to add an item to your cart");
            System.out.println("Enter 3 to view your cart.");
            System.out.println("Enter 4 to view / edit your personal information.");
            System.out.println("Enter 5 to view your past orders.");
            System.out.println("Enter 6 to add money to your account.");
            System.out.println("Enter 7 to log out of the store and exit.");
            System.out.println("What would you like to do? ");
            if(auto == false){
                try {
                    userChoice = scan.nextInt();
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input type!");
                    break;
                } 
            } else {
                break;
            }
            
            
            count++;
        } while(choices.contains(userChoice) == false);
        return userChoice;
        
    }
    /*
    this function displays all of the items in the store via a for loop
    SRS 3.1.3.7, 3.1.4.1, 3.1.4.2
    */
    public static void displayItems(ArrayList<Item> items){
        System.out.println("Items available in the store at the moment are...");
        for(int i = 0; i < items.size(); i++){
            System.out.println("Item " + (i+1) +"\n");
            System.out.println(items.get(i).toString());
            System.out.println();
        }
    }
    /*
    takes the users cart, a list of items to allow user to input a item id for the desired item and then it puts it in the cart, if they already have an item of the same type it increases the quantity of that item instead
    SRS 3.1.1.2, 3.1.4.3
    */
    public static void addItemToCart(ArrayList<Item> items, Cart userCart, boolean auto){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the item id of the item you would like to add to your cart.");
        //int selected;
        boolean found = false;
        Item desired;
        if(auto == false){            
        
            try {
                int userChoice = scan.nextInt();
                System.out.println();
                for(int i = 0; i < items.size(); i++){
                    if(items.get(i).getId() == userChoice){
                        //selected = i;
                        desired = items.get(i);
                        found = true;
                        if(userCart.containsItem(desired)) {
                            System.out.println("Another copy of " + desired.getName() + " has been added to your cart.");
                            userCart.increaseQuantity(desired);
                        } else {
                            userCart.addItem(desired);
                        }

                        //System.out.println("We made it");
                    }
                }
                if(found == false){
                    System.out.println("Item Id not found");
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input type!");
            }
        } else {
            desired = items.get(0);
            if(userCart.containsItem(desired)) {
                System.out.println("Another copy of " + desired.getName() + " has been added to your cart.");
                userCart.increaseQuantity(desired);
            } else {
                userCart.addItem(desired);
            }
        }
        
    }
    /*
    allows the user to remove an item from the cart by item id if it is in their cart
    SRS 3.1.1.3
    */
    public static void removeItemFromCart(Cart userCart, boolean auto){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the item id of the item you would like to remove from your cart.");
        //int selected;
        boolean found = false;
        Item desired;
        
        if(auto == false){
                    
            try {
                int userChoice = scan.nextInt();
                System.out.println();
                desired = userCart.containsItemWithId(userChoice);

                if(desired == null){
                    found = false;                    
                } else {
                    found = true;
                    userCart.removeItem(desired);

                }

                if(found == false){
                    System.out.println("Item Id not found");
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input type!");
            }
        } else {
            //System.out.println("Enter the item id of the item you would like to remove from your cart.");
            desired = userCart.containsItemWithId(1);
            userCart.removeItem(desired);
        }
        
    }
    
    /*
    allows the user to change the amount of an item in their cart and removes it if they specify 0 as the amount
    SRS 3.1.1.10
    */
    public static void changeItemQuantity(Cart userCart, boolean auto){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the item id of the item you would like to change the quantity of.");
        boolean found = false;
        Item desired;
        if(auto == false){
                    
            try {
                int userChoice = scan.nextInt();
                System.out.println();
                desired = userCart.containsItemWithId(userChoice);

                if(desired == null){
                    found = false;                    
                } else {
                    found = true;
                    System.out.println("Enter the amount of the item you would like to change the quantity to.");
                    try {
                        
                        int amount = scan.nextInt();
                        System.out.println();
                        if(amount == 0){
                            userCart.removeItem(desired);
                        } else {
                            userCart.changeQuantity(desired, amount);
                        }
                        
                    } catch(InputMismatchException e){
                        System.out.println("Invalid input type!");
                    }


                }

                if(found == false){
                    System.out.println("Item Id not found");
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input type!");
            }
        } else {
            //System.out.println("Enter the item id of the item you would like to change the quantity of.");
            desired = userCart.containsItemWithId(1);
            System.out.println("Enter the amount of the item you would like to change the quantity to.");
            userCart.changeQuantity(desired, 2);
        }
        
    }
    
    
    
    /*
    Cart editing menu
    allows user to remove item from cart, add item to cart, change quantity
    checks for valid input
    */
    public static void editCart(ArrayList<Item> items, Cart userCart, boolean auto){
        ArrayList<Integer> choices = new ArrayList<Integer>();
        choices.add(1);
        choices.add(2);
        choices.add(3);
        choices.add(4);
        
        
        if(auto == false){            
        
            Scanner scan = new Scanner(System.in);
            int userChoice = 0;
            int count = 0;
            do{
                if(count != 0){
                    System.out.println("Please only input a valid choice 1-4!");
                }
                System.out.println("Cart editing menu");
                System.out.println("Enter 1 to remove an item from the cart.");
                System.out.println("Enter 2 to add an item to your cart.");
                System.out.println("Enter 3 to change the quantity of an item in the cart.");
                System.out.println("Enter 4 to cancel editing.");
                System.out.println("What would you like to do? ");
                try {
                    userChoice = scan.nextInt();
                    switch(userChoice){
                        case 1:
                            System.out.println(userCart.cartString());
                            userCart.calcTotal();
                            System.out.println("Total Cost: " + userCart.getTotal());
                            removeItemFromCart(userCart, auto);
                            break;
                        case 2:
                            System.out.println(userCart.cartString());
                            userCart.calcTotal();
                            System.out.println("Total Cost: " + userCart.getTotal());
                            addItemToCart(items, userCart, auto);
                            break;
                        case 3:
                            System.out.println(userCart.cartString());
                            userCart.calcTotal();
                            System.out.println("Total Cost: " + userCart.getTotal());
                            changeItemQuantity(userCart, auto);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Incorrect input!");
                            break;
                    }
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input type!");
                    break;
                }

                count++;
            } while(choices.contains(userChoice) == false);
        } else {
            System.out.println("Cart editing menu");
            System.out.println("Enter 1 to remove an item from the cart.");
            System.out.println("Enter 2 to add an item to your cart.");
            System.out.println("Enter 3 to change the quantity of an item in the cart.");
            System.out.println("Enter 4 to cancel editing.");
            System.out.println("What would you like to do? ");
            removeItemFromCart(userCart, auto);
            System.out.println();
            addItemToCart(items, userCart, auto);
            System.out.println();
            changeItemQuantity(userCart, auto);
            System.out.println();
        }
    }
    
    /*
    allows user to place an order if they have sufficient funds and stores the transaction in to the database
    SRS 3.1.1.8, 3.1.2.1, 3.1.2.11, 3.1.2.12, 3.1.3.9, 3.1.5.1, 3.1.5.2, 3.1.5.3
    */
    public static void createOrder(User us1, Cart userCart){
        userCart.calcTotal();
        if(us1.getBalance() < userCart.getTotal()){
            System.out.println("Your balance is: " + us1.getBalance());
            System.out.println("The order costs: " + userCart.getTotal());
            System.out.println("You do not have enough funds for this purchase.");
            
        } else {
            Order ord = new Order(userCart, "pending");
            TransactionProcessor tp1 = new TransactionProcessor(us1, ord);
            ord.setOrderContents(userCart.orderString());
            tp1.performTransaction();
            System.out.println("Order processed and payment recieved, order added to order history.\n");
            us1.updateOrder(ord, "shipping");
            
        }
        
        
        
    }
    
    /*
    Cart main menu, allows users to go to the cart editing menu or go straight to purchasing
    Satifies SRS 3.1.1.1, 3.1.1.4, 3.1.1.5, 3.1.1.6, 3.1.1.7, 3.3.3.6
    */
    public static void viewCart(ArrayList<Item> items, Cart userCart, User us1, boolean auto){
        System.out.println(userCart.cartString());
        userCart.calcTotal();
        System.out.println("Total Cost: " + userCart.getTotal());
        
        if(auto == false){
                    
            Scanner scan = new Scanner(System.in);
            int userChoice = 0;
            int count = 0;
            if(userCart.isEmpty() == false){
                while((userChoice != 1 || userChoice != 2) && userCart.isEmpty() == false){
                    if(count != 0){
                        System.out.println(userCart.cartString());
                        userCart.calcTotal();
                        System.out.println("Total Cost: " + userCart.getTotal());
                    }
                    count++;
                    System.out.println("\nWould you like to edit your cart?\nEnter 1 for Yes and 2 for No.\n");
                    try {
                        userChoice = scan.nextInt();
                        if(userChoice == 2){
                            break;
                        } else if (userChoice == 1){
                            editCart(items, userCart, auto);
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid input type!");
                    }
                }

                userChoice = 0;
                count = 0;

                while((userChoice != 1 || userChoice != 2) && userCart.isEmpty() == false){
                    if(count != 0){
                        System.out.println(userCart.cartString());
                        userCart.calcTotal();
                        System.out.println("Total Cost: " + userCart.getTotal());
                    }
                    count++;
                    System.out.println("\nWould you like to purchase everything in your cart?\nEnter 1 for Yes and 2 for No.\n");
                    try {
                        userChoice = scan.nextInt();
                        if(userChoice == 2){
                            break;
                        } else if (userChoice == 1){
                            createOrder(us1, userCart);
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid input type!");
                    }
                }

            }
        } else {
            
            
            System.out.println("\nWould you like to edit your cart?\nEnter 1 for Yes and 2 for No.\n");
            editCart(items, userCart, auto);
            
            System.out.println(userCart.cartString());
            userCart.calcTotal();
            System.out.println("Total Cost: " + userCart.getTotal());
            
            System.out.println("\nWould you like to purchase everything in your cart?\nEnter 1 for Yes and 2 for No.\n");
            createOrder(us1, userCart);
        }
        
        
    }
    
    /*
    changes user info depending on choice from menu such as address, password or email
    */
    public static void changeUserAttribute(User us1, int choice){
        System.out.println(us1.toString());
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String update;
        switch(choice){
            case 1:
                System.out.println("Enter your new address.");
                try {
                    update = scan.nextLine();
                    us1.setAddress(update);
                    System.out.println("Information updated.");
                    break;
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input type!");
                }
                
            case 2:
                System.out.println("Enter your new password.");
                try {
                    update = scan.nextLine();
                    us1.setPass(update);
                    System.out.println("Information updated.");
                    break;
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input type!");
                }
            case 3:
                System.out.println("Enter your new email.");
                try {
                    update = scan.nextLine();
                    us1.setEmail(update);
                    System.out.println("Information updated.");
                    break;
                } catch(InputMismatchException e) {
                    System.out.println("Invalid input type!");
                }
            default:
                break;
        }
    }
    
    /*
    main menu for editing user info, asks them to select a choice for editing
    SRS 3.1.3.3, 3.1.3.4
    */
    public static void editUserInfo(User us1, boolean auto){
        System.out.println(us1.toString());
        
        Scanner scan = new Scanner(System.in);
        int userChoice = 0;
        int count = 0;
        int userChoice2 = 0;
        ArrayList<Integer> choices = new ArrayList<Integer>();
        choices.add(1);
        choices.add(2);
        choices.add(3);
        choices.add(4);
        
        if(auto == false){         
                
            while((userChoice != 1 || userChoice != 2))
            {

                    System.out.println("\nWould you like to edit your user info?\nEnter 1 for Yes and 2 for No.\n");
                    try {
                        userChoice = scan.nextInt();
                        if(userChoice == 2){
                            break;
                        } else if (userChoice == 1){
                            do{
                                if(count != 0){
                                    System.out.println("Please only input a valid choice 1-4!");
                                }
                                System.out.println("User editing menu");
                                System.out.println("Enter 1 for address.");
                                System.out.println("Enter 2 for password.");
                                System.out.println("Enter 3 for email.");
                                System.out.println("Enter 4 to cancel.");
                                System.out.println("What would you like to do? ");
                                try {
                                    userChoice2 = scan.nextInt();
                                    switch(userChoice2){
                                        case 1:
                                            changeUserAttribute(us1, 1);
                                            break;
                                        case 2:
                                            changeUserAttribute(us1, 2);
                                            break;
                                        case 3:
                                            changeUserAttribute(us1, 3);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Incorrect input!");
                                            break;
                                    }
                                } catch(InputMismatchException e) {
                                    System.out.println("Invalid input type!");
                                    break;
                                }
                                count++;
                            } while(choices.contains(userChoice2) == false);




                        } else {
                            System.out.println("Invalid choice!");
                        }
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid input type!");
                    }
            }
        } else{
            System.out.println("User editing menu");
            System.out.println("Enter 1 for address.");
            System.out.println("Enter 2 for password.");
            System.out.println("Enter 3 for email.");
            System.out.println("Enter 4 to cancel.");
            System.out.println("What would you like to do? ");
            
            us1.setAddress("AutomatedTesting Lane");
            us1.setPass("autobots");
            us1.setEmail("auto@auto.org");
            
            System.out.println(us1.toString());
        }
        
    }
    
    /*
    displays the order history of the user
    SRS 3.1.2.2, 3.1.2.4, 3.1.2.4, 3.1.2.5, 3.1.2.8, 3.1.2.9
    */
    public static void displayOrderHistory(User us1){
        System.out.println(us1.orderHistory());
    }
    
    /*
    allows the user to add more funds to their account
    SRS 3.1.3.8
    */
    public static void addMoneyToUser(User us1, boolean auto){
        Scanner scan = new Scanner(System.in);
        int userChoice = 0;
        float userChoice2;
        int count = 0;
        if(auto == false){                   
        
            while((userChoice != 1 || userChoice != 2))
            {
                    System.out.println("\nWould you like to add more funds?\nEnter 1 for Yes and 2 for No.\n");
                    try {
                        userChoice = scan.nextInt();
                        if(userChoice == 2){
                            break;
                        } else if (userChoice == 1){
                            System.out.println("How much would you like to add?");
                            try {
                                userChoice2 = scan.nextFloat();
                                if(userChoice2 > 0){
                                    us1.addMoney(userChoice2);
                                    System.out.println("You have added " + userChoice2 + " dollars to your account.");
                                    System.out.println("New balance: " + us1.getBalance());
                                } else {
                                    System.out.println("Invalid amount!");
                                }
                            } catch(InputMismatchException e){
                                System.out.println("Invalid input type!");
                            }
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    } catch(InputMismatchException e) {
                        System.out.println("Invalid input type!");
                    }
            }
        } else {
            System.out.println("\nWould you like to add more funds?\nEnter 1 for Yes and 2 for No.\n");
            us1.addMoney(2000);
            System.out.println("You have added " + 2000 + " dollars to your account.");
            System.out.println("New balance: " + us1.getBalance());
        }
    }
    
    /*
    main method of the application
    makes an array of items for the store
    connects to the database
    adds the user to the database if not already in it 
    then displays the main menu
    and does corresponding user choice
    SRS 3.1.3.2, 3.1.3.5, 
    */
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();
        Item book1 = new Item("Object Oriented Design", 500.0f, "An intro to Object Oriented Design Principles", 1, 20, 1);
        Item book2 = new Item("Mathematics for Dummies", 250.0f, "2 + 2 = Fish", 2, 20, 1);
        Item book3 = new Item("Speaking English as a American", 125.0f, "When to use their, there, or they're", 3, 20, 1);
        Item book4 = new Item("Historically Speaking", 420.0f, "A exploration of the world through time", 4, 20, 1);
        Item book5 = new Item("Let's get Physical", 180.0f, "All you wanted to know about thrust, friction, heat, and motion", 5, 20, 1);
        items.add(book1);
        items.add(book2);
        items.add(book3);
        items.add(book4);
        items.add(book5);
        
        
        connect();
        User us1 = new User("SusanNichols", "24 Richard Lane", "Credit Card", "susan_nichols@gmail.com", "sn123", 600.0f);
        
        
        Insert tableInsert = new Insert();
        tableInsert.insertUser(us1.getUsername(), us1.getPass(), us1.getAddress(), us1.getBalance());
        
        //automatic tester, comment these lines and uncomment the user tester for application use
        /*
        displayMenu(true);
        System.out.println();
        displayItems(items);
        System.out.println();
        addItemToCart(items, us1.getCart(), true);
        System.out.println();
        viewCart(items, us1.getCart(), us1, true);
        System.out.println();
        editUserInfo(us1, true);
        System.out.println();
        displayOrderHistory(us1);
        System.out.println();
        addMoneyToUser(us1, true);
        System.out.println();
        createOrder(us1, us1.getCart());
        System.out.println();
        displayOrderHistory(us1);
       */









//reuser tester
        
        boolean done = false;
        while(done == false){
            int choice = displayMenu(false);
            System.out.println();
            switch(choice){
                case 1:
                    displayItems(items);
                    System.out.println("\nGoing back to main menu...\n");
                    break;
                case 2:
                    addItemToCart(items, us1.getCart(), false);
                    System.out.println("\nGoing back to main menu...\n");
                    break;
                case 3:
                    viewCart(items, us1.getCart(), us1, false);
                    System.out.println("\nGoing back to main menu...\n");
                    break;
                case 4:
                    editUserInfo(us1, false);
                    break;
                case 5:
                    displayOrderHistory(us1);
                    break;
                case 6:
                    addMoneyToUser(us1, false);
                    break;
                case 7:
                    done = true;
                    //System.out.println();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("unrecognized input! exiting program");
                    break;
            }
        }
        
        
        
       
    }
    
}
