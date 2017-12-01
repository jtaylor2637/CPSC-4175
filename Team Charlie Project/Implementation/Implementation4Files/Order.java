/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.util.UUID;

/**
 * The order class handles all of the information and data related to orders created by the user.
 * @author Team Charlie
 */
public class Order
{
    private Cart orderedItems; //the cart of items
    private String status; //the status of the order
    private int orderNumber; //order number for the database and user
    private float orderCost; //cost of the order
    private String order; //the string of what the order contains
    private String orderSummary; //the string of a summary of the order information
    private static int count = 0; //id counter
    private String uuid; //unique id for database
    
    

    /**
     * Satisfies SRS 3.1.2.6
     * @param orderCart Cart that order is based on
     * @param status String status of the order
     */

    public Order(Cart orderCart, String status) {
        setOrderCart(orderCart);
        setStatus(status);
        setOrderNumber(++count);
        setUUID();
        //setOrderCost(orderCost);
        //setOrder(order);
    }
    

    /**
     * sets uuid to a random value for each instance
     * Satisfies SRS 3.1.2.10
     */

    public void setUUID(){
        uuid = UUID.randomUUID().toString();
    }
    

    /**
     * gets order UUID
     * @return String of the order UUID
     */

    public String getUUID(){
        return uuid;
    }
    
    

    /**
     * Gets order status
     * @return String status of the order
     */

    public String getStatus(){
        return status;
    }
    

    /**
     * Returns cart of the order
     * @return Cart of the order
     */

    public Cart getOrderCart(){
        return orderedItems;
    }
    

    /**
     * Set the corresponding cart 
     * @param cart Cart of the order
     */

    public void setOrderCart(Cart cart){
        this.orderedItems = cart;
    }
    
    

    /**
     * Set status of the order
     * @param status String status of the order
     */

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    /**
     * Gets order number
     * @return Int number of the order
     */

    public int getOrderNumber() {
        return orderNumber;
    }
    
    

    /**
     * Sets the order number
     * @param orderNumber Int number of the order
     */

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    

    /**
     * gets cost of the order
     * @return Float cost of the order
     */

    public float getOrderCost() {
        //orderCost = orderedItems.getTotal();
        return orderedItems.getTotal();
    }
    
     

    /**
     * Set order contents
     * @param ordString String contents of the order
     */
    
    public void setOrderContents(String ordString){
        order = ordString;
    }
    
    

    /**
     * Get order contents
     * @return String contents of the order
     */

    public String getOrder() {
        return(order);
        
    }
    
       

    /**
     * Set order summary
     * @param summ String summary of the order
     */
    
    public void setSummary(String summ){
        this.orderSummary = summ;
    }
    
    

    /**
     * Get the order summary
     * @return String summary of the order
     */

    public String getSummary(){
        return(orderSummary);
    }
    
    

    /**
     * sets the order summary to the order number, the order cost, the status of the order, and its contents
     * Satisfies SRS 3.1.2.12
     */

    public void displayOrder() {
        setSummary("Here is your order information: \n" + "Order number: " + getOrderNumber() + "\nOrder Cost: " + getOrderCost() + "\nOrder Status: " + getStatus() + "\nOrder contains: " + getOrder() + "\n" );
        //System.out.println("Here is your order information: ");
    }
    
    

    /**
     * Update the order status
     * @param newStatus String status of the order
     */

    public void updateStatus(String newStatus) {
        status = newStatus;
    }
    
    

    /**
     * insert the order into the database
     * Satisfies SRS 3.1.2.11
     */

    public void storeOrder() {
        Insert orderInsert = new Insert();
        orderInsert.insertOrder(getOrderNumber(), getStatus(), getOrderCost(), getUUID());
        System.out.println(getUUID());
        System.out.println("The order information has been stored for future reference\n");
    }
}
