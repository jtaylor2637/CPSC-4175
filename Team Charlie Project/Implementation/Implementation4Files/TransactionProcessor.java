/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.util.UUID;

/**
 * The class that stores transaction information
 * @author Team Charlie
 */
public class TransactionProcessor {
    private static int count = 0; //id counter
    private int transNum; //id number
    private User currentUser; //the user who made the transaction
    private Order currentOrder; //the order which is being paid for
    private String uuid; //unique id for database
    

    /**
     * Custom constructor
     * @param current User that placed order
     * @param order Order being paid for
     */

    public TransactionProcessor(User current, Order order){
        setTransNum(++count);
        setUser(current);
        setOrder(order);
        setUUID();
    }
    
    

    /**
     * Set user of the transaction
     * @param user User who made the purchase
     */

    public void setUser(User user) {
        this.currentUser = user;
    }
    
    

    /**
     * generate random uuid
     */

    public void setUUID(){
        uuid = UUID.randomUUID().toString();
    }
     

    /**
     * get uuid
     * @return String UUID of the transaction
     */

    public String getUUID(){
        return uuid;
    }
    
   

    /**
     * gets the user that made the purchase
     * @return User who made the purchase
     */

    public User getUser() {
        return(currentUser);
    }
    
    

    /**
     * sets the order that is being processed
     * @param order Order that is being processed
     */

    public void setOrder(Order order){
        this.currentOrder = order;
    }
    
    

    /**
     * gets the order
     * @return Order being processed
     */

    public Order getOrder(){
        return(currentOrder);
    }
    

    /**
     * sets the transaction number
     * @param num Int number of the transaction
     */

    public void setTransNum(int num){
        this.transNum = num;
    }
   

    /**
     * gets the transaction number
     * @return Int number of the transaction
     */

    public int getTransNum(){
        return(transNum);
    }
    
    
    

    /**
     * produces a transaction report
     */

    public void produceReport(){
        System.out.println("Transaction Summary:\n" + "User: " + getUser().getUsername() + "\nOrder Number: " + getOrder().getOrderNumber()+ "\nOrder Amount: " + getOrder().getOrderCost() + "\nTransaction Number: " + getTransNum() + "\n");
         
    }
    
    

    /**
     * performs the transaction if the user has the money to do so
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
    

    /**
     * store the transaction into the database
     */

    public void storeTransaction(){
        Insert inserter = new Insert();
        System.out.println(getUUID());
        inserter.insertTransaction(getTransNum(), this.currentUser.getUsername(), this.currentOrder.getOrderNumber(), getUUID());
        System.out.println("Stored Transaction\n");//something
    }
}