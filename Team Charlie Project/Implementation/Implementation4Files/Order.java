/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.util.UUID;

/**
 * The order class handles all of the information and data related to orders created by the user.
 * @author jtayl
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
    
    /*default constructor
    Satisfies SRS 3.1.2.6
    */
    public Order(Cart orderCart, String status) {
        setOrderCart(orderCart);
        setStatus(status);
        setOrderNumber(++count);
        setUUID();
        //setOrderCost(orderCost);
        //setOrder(order);
    }
    /*
    sets uuid to a random value for each instance
    Satisfies SRS 3.1.2.10
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
    returns the string of the status of the order
    */
    public String getStatus(){
        return status;
    }
    /*
    return the cart
    */
    public Cart getOrderCart(){
        return orderedItems;
    }
    /*
    set the order's corresponding cart
    */
    public void setOrderCart(Cart cart){
        this.orderedItems = cart;
    }
    
    /*
    set the status of the order
    */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /*
    return the order number
    */
    public int getOrderNumber() {
        return orderNumber;
    }
    
    /*
    set the order number
    */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    /*
    get the cost of the order
    */
    public float getOrderCost() {
        //orderCost = orderedItems.getTotal();
        return orderedItems.getTotal();
    }
    
    /*
    set the contents of the order
    */    
    public void setOrderContents(String ordString){
        order = ordString;
    }
    
    /*
    get the order contents
    */
    public String getOrder() {
        return(order);
        
    }
    
    /*
    set the order summary
    */    
    public void setSummary(String summ){
        this.orderSummary = summ;
    }
    
    /*
    get the order summary
    */
    public String getSummary(){
        return(orderSummary);
    }
    
    /*
    sets the order summary to the order number, the order cost, the status of the order, and its contents
    Satisfies SRS 3.1.2.12
    */
    public void displayOrder() {
        setSummary("Here is your order information: \n" + "Order number: " + getOrderNumber() + "\nOrder Cost: " + getOrderCost() + "\nOrder Status: " + getStatus() + "\nOrder contains: " + getOrder() + "\n" );
        //System.out.println("Here is your order information: ");
    }
    
    /*
    update the order status
    */
    public void updateStatus(String newStatus) {
        status = newStatus;
    }
    
    /*
    insert the order into the database
    Satisfies SRS 3.1.2.11
    */
    public void storeOrder() {
        Insert orderInsert = new Insert();
        orderInsert.insertOrder(getOrderNumber(), getStatus(), getOrderCost(), getUUID());
        System.out.println(getUUID());
        System.out.println("The order information has been stored for future reference\n");
    }
}
