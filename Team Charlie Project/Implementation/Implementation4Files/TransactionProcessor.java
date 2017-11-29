/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.util.UUID;

/**
 * The class that stores transaction information
 * @author jtayl
 */
public class TransactionProcessor {
    private static int count = 0; //id counter
    private int transNum; //id number
    private User currentUser; //the user who made the transaction
    private Order currentOrder; //the order which is being paid for
    private String uuid; //unique id for database
    /*
    custom constructor
    */
    public TransactionProcessor(User current, Order order){
        setTransNum(++count);
        setUser(current);
        setOrder(order);
        setUUID();
    }
    
    /*
    set user who made transaction
    */
    public void setUser(User user) {
        this.currentUser = user;
    }
    
    /*
    generate random uuid
    */
    public void setUUID(){
        uuid = UUID.randomUUID().toString();
    }
     /*
    return uuid
    */
    public String getUUID(){
        return uuid;
    }
    
    /*
    return user
    */
    public User getUser() {
        return(currentUser);
    }
    
    /*
    set order
    */
    public void setOrder(Order order){
        this.currentOrder = order;
    }
    
    /*
    get order
    */
    public Order getOrder(){
        return(currentOrder);
    }
    /*
    set trans id
    */
    public void setTransNum(int num){
        this.transNum = num;
    }
    /*
    get id
    */
    public int getTransNum(){
        return(transNum);
    }
    
    /*
    make transaction report
    */
    public void produceReport(){
        System.out.println("Transaction Summary:\n" + "User: " + getUser().getUsername() + "\nOrder Number: " + getOrder().getOrderNumber()+ "\nOrder Amount: " + getOrder().getOrderCost() + "\nTransaction Number: " + getTransNum() + "\n");
         
    }
    
    /*
    perform transaction for user if balance is sufficient
    */
    public void performTransaction(){
        if(currentUser.getBalance() > currentOrder.getOrderCost()){
            produceReport();
            currentUser.payMoney(currentOrder.getOrderCost());
            getOrder().getOrderCart().emptyCart();
            storeTransaction();
            getOrder().storeOrder();
            currentUser.addOrder(currentOrder);
        } else {
            System.out.println("Not enough money in balance for this order, please add more funds to purchase.");
        }
        //something
    }
    /*
    insert transaction into the database
    */
    public void storeTransaction(){
        Insert inserter = new Insert();
        System.out.println(getUUID());
        inserter.insertTransaction(getTransNum(), this.currentUser.getUsername(), this.currentOrder.getOrderNumber(), getUUID());
        System.out.println("Stored Transaction\n");//something
    }
}