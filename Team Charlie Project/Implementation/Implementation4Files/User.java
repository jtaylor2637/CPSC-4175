/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * The user class and all of its information and functionality
 * @author Team Charlie
 */
public class User {
    private String userName; //username of the user
    private String userAddress; //user address
    private String paymentMethod; //preferred payment method
    private String userPass; //user password
    private String userEmail; //user email
    private float userBalance; //user balance
    private Cart userCart; //users current cart
    private ArrayList<Order> orderList; //order history
    private String uuid; //unique user id
    
    

    /**
     * default constructor
     */
    public User() {
        setUsername("default");
        setAddress("100 Road Avenue");
        setMethod("Credit");
        setPass("1234");
        setEmail("default@gmail.com");
        setBalance(100.00f);
        setCart(new Cart());
        setOrderList(new ArrayList<Order>());
        setUUID();
    }
    

    /**
     * custom constructor for each new user
     * @param user String user name 
     * @param address String user address
     * @param method String user method
     * @param email String user email
     * @param pass String user pass
     * @param balance Float user balance
     */

    public User(String user, String address, String method, String email, String pass, float balance) {
        setUsername(user);
        setAddress(address);
        setMethod(method);
        setEmail(email);
        setPass(pass);
        setBalance(balance);
        setCart(new Cart());
        setOrderList(new ArrayList<Order>());
        setUUID();
    }
    
    
    

    /**
     * set order history list
     * @param orders ArrayList of orders
     */

    public void setOrderList(ArrayList<Order> orders){
        orderList = orders;
    }
    

    /**
     * return the order history
     * @return ArrayList of orders
     */
    public ArrayList<Order> getOrderList(){
        return orderList;
    }
    
    

    /**
     * Adds an order to order history
     * @param ord Order to be added
     */

    public void addOrder(Order ord){
        
        orderList.add(ord);
    }
    

    /**
     * Removes an order from the history
     * @param ord Order to be removed
     */

    public void removeOrder(Order ord){
        orderList.remove(ord);
    }
    

    /**
     * change status of an order in history
     * @param ord Order to be updated
     * @param stat String of the new status
     */

    public void updateOrder(Order ord, String stat){
               
        int found = orderList.indexOf(ord);
        orderList.get(found).setStatus(stat);
        
        
    }
    
    

    /**
     * Gets order history
     * @return String of the order history
     */

    public String orderHistory(){
        if(orderList.isEmpty() == true){
            return ("You have not placed any orders yet.\n");
        } else {
            String orders = "\n";
            for(Order ord : orderList){
                ord.displayOrder();
                orders+= ord.getSummary() + "\n";
            }
            return orders;
        }
        
    }
    

    /**
     * Creates UUID
     */

    public void setUUID(){
        uuid = UUID.randomUUID().toString();
    }
    
    

    /**
     * Gets UUID
     * @return String of the user UUID
     */

    public String getUUID(){
        return uuid;
    }
    
   

    /**
     * Sets the cart to the user
     * @param cart Cart to be tied to the user
     */

    public void setCart(Cart cart){
        this.userCart = cart;
    }
    
    

    /**
     * Gets the user's cart
     * @return Cart the user's cart
     */

    public Cart getCart(){
        return userCart;
    }
    
    

    /**
     * Sets the user's name
     * @param name String username of the user
     */

    public void setUsername(String name) {
        this.userName = name;
    }
    
   

    /**
     * gets username
     * @return String username of the user
     */

    public String getUsername() {
        return(userName);
    }
    
    

    /**
     * Sets the user's address
     * @param address String address of the user
     */

    public void setAddress(String address) {
        this.userAddress = address;
    }
    
    

    /**
     * Gets the user address
     * @return String address of the user
     */

    public String getAddress() {
        return(userAddress);
    }
    
    

    /**
     * sets the payment method of the user
     * @param method String payment method
     */

    public void setMethod(String method) {
        this.paymentMethod = method;
    }
    
    

    /**
     * Gets the payment method
     * @return String of the payment method
     */

    public String getMethod() {
        return(paymentMethod);
    }
    
    

    /**
     * Sets the user's password
     * @param pass String password desired
     */

    public void setPass(String pass) {
        this.userPass = pass;
    }
    
    

    /**
     * Gets the user's password
     * @return String of the password
     */

    public String getPass() {
        return(userPass);
    }
    
    

    /**
     * Sets the user's email
     * @param email String of the user's email
     */

    public void setEmail(String email) {
        this.userEmail = email;
    }
    
    

    /**
     * Gets the user's email
     * @return String of the user's email
     */

    public String getEmail() {
        return(userEmail);
    }
    
    

    /**
     * Sets the user's balance
     * @param balance Float of the user's balance
     */

    public void setBalance(float balance) {
        this.userBalance = balance;
    }
    
   

    /**
     * Get's user's balance
     * @return Float of the user's balance
     */

    public float getBalance() {
        return(userBalance);
    }
    
   

    /**
     * View cart's items
     * @param cart Cart object to be inspected
     */

    public void viewCart(Cart cart){
        cart.getItemsInCart();
    }
    
   

    /**
     * Nothing
     */

    public void placeOrder(){
        //something
    }
   

    /**
     * Nothing
     */

    public void trackOrder(){
        //something
    }
    

    /**
     * Nothing
     */

    public void cancelOrder(){
        //something
    }
    
    

    /**
     * View an order summary
     * @param order Order to be examined
     */

    public void viewOrder(Order order){
        order.displayOrder();
        order.getSummary();
    }
    
    /**
     * Nothing
     */
    public void selectCategory(){
        //something
    }
    
    

    /**
     * Add money to user
     * @param amount Float amount to be added
     */

    public void addMoney(float amount){
        setBalance(getBalance() + amount);
    }
    
    

    /**
     * Remove money from user
     * @param amount Float cost to be paid
     */

    public void payMoney(float amount){
        if(getBalance() >= amount){
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Not enough money in account balance.");
        }
        
    }
    
    /**
     * User summary
     * @return String summary of user info
     */
    public String toString(){
        return("User Summary:\n" + "UserName: " + getUsername()+ "\nAddress: " + getAddress() + "\nPayment Method: " + getMethod() + "\nEmail: " + getEmail() + "\nPassword: " + getPass() + "\nBalance: " + getBalance() +"\n");
    }
    
}

