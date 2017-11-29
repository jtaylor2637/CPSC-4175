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
 * @author jtayl
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
    
    //default constructor
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
    /*
    custom constructor for each new user
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
    
    
    /*
    set order history list
    */
    public void setOrderList(ArrayList<Order> orders){
        orderList = orders;
    }
    //return the order history
    public ArrayList<Order> getOrderList(){
        return orderList;
    }
    
    /*add an order to history
    
    */
    public void addOrder(Order ord){
        
        orderList.add(ord);
    }
    /*
    remove an order from history
    */
    public void removeOrder(Order ord){
        orderList.remove(ord);
    }
    /* change status of an order in history
    
    */
    public void updateOrder(Order ord, String stat){
               
        int found = orderList.indexOf(ord);
        orderList.get(found).setStatus(stat);
        
        
    }
    
    /*
    returns the list of past orders
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
    /*
    creates random uuid for user
    */
    public void setUUID(){
        uuid = UUID.randomUUID().toString();
    }
    
    /*
    get uuid
    */
    public String getUUID(){
        return uuid;
    }
    
    /*
    set cart of the user
    */
    public void setCart(Cart cart){
        this.userCart = cart;
    }
    
    /*
    return user cart
    */
    public Cart getCart(){
        return userCart;
    }
    
    /*
    set username
    */
    public void setUsername(String name) {
        this.userName = name;
    }
    
    /*
    get username
    */
    public String getUsername() {
        return(userName);
    }
    
    /*
    set address
    */
    public void setAddress(String address) {
        this.userAddress = address;
    }
    
    /*
    get user address
    */
    public String getAddress() {
        return(userAddress);
    }
    
    /*
    set payment method
    */
    public void setMethod(String method) {
        this.paymentMethod = method;
    }
    
    /*
    get payment method
    */
    public String getMethod() {
        return(paymentMethod);
    }
    
    /*
    set user pass
    */
    public void setPass(String pass) {
        this.userPass = pass;
    }
    
    /*
    get user pass
    */
    public String getPass() {
        return(userPass);
    }
    
    /*
    set user email
    */
    public void setEmail(String email) {
        this.userEmail = email;
    }
    
    /*
    get user email
    */
    public String getEmail() {
        return(userEmail);
    }
    
    /*
    set user balance
    */
    public void setBalance(float balance) {
        this.userBalance = balance;
    }
    
    /*
    get user balance
    */
    public float getBalance() {
        return(userBalance);
    }
    
    /*
    view the items in the cart
    */
    public void viewCart(Cart cart){
        cart.getItemsInCart();
    }
    
    /*
    
    */
    public void placeOrder(){
        //something
    }
    /*
    
    */
    public void trackOrder(){
        //something
    }
    /*
    
    */
    public void cancelOrder(){
        //something
    }
    
    /*
    display order summary of an order
    */
    public void viewOrder(Order order){
        order.displayOrder();
        order.getSummary();
    }
    
    public void selectCategory(){
        //something
    }
    
    /*
    add money to the balance
    */
    public void addMoney(float amount){
        setBalance(getBalance() + amount);
    }
    
    /*
    remove money from the balance
    */
    public void payMoney(float amount){
        if(getBalance() >= amount){
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Not enough money in account balance.");
        }
        
    }
    
    /*
    user information string
    */
    public String toString(){
        return("User Summary:\n" + "UserName: " + getUsername()+ "\nAddress: " + getAddress() + "\nPayment Method: " + getMethod() + "\nEmail: " + getEmail() + "\nPassword: " + getPass() + "\nBalance: " + getBalance() +"\n");
    }
    
}

