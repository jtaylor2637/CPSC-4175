/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

import java.util.ArrayList;

/**
 * This class represents the cart for the store. It keeps track of items for a user and totals the items in the cart. The user can add items and remove items and change quantity
 * @author Team Charlie
 */
public class Cart
{
    private float total = 0; //total cost
    private int cartQuantity; //number of items in the cart
    private ArrayList<Item> itemsInCart;    //the items in the cart
    
    

    /**
     * Constructor for the cart, sets up an arraylist of items for the cart to hold
     */
    public Cart(){
         //this.total = 0;
         itemsInCart = new ArrayList<Item>();
         itemsInCart.clear();
    }
    

    /**
     * returns the total cost of the items in the cart
     * @return Float total of the cart
     */

    public float getTotal() {
        
        return total;
    }
    

    /**
     * calculates the total cost of all the items based on their quantity and price per item
     * Satisfies SRS 3.1.1.4
     *
     */

    public void calcTotal(){
        if(total == 0){
            for(Item item : itemsInCart){           
                total += (item.getQuantity() * item.getPrice());
            }
        } else{
            total = 0;
            for(Item item : itemsInCart){
                //total += item.getPrice();
            total += (item.getQuantity() * item.getPrice());
        }
        }
        
    }
    
    

    /**
     * gets total number of items in the cart by getting each quantity of item and adding them together
     * @return Int of the total amount of items in the cart
     */

    public int calcTotalItems(){
        int totalItems = 0;
        for(Item item : itemsInCart){
            totalItems += (item.getQuantity());
        }
        
        return totalItems;
    }
    
    

    /**
     * set total price of cart
     * @param total float price of the cart's content
     */
    
    public void setTotal(float total) {
        this.total = total;
    }
    
    

    /**
     * returns amount of items in the cart
     * @return int cart quantity of unique items
     */

    public int getCartQuantity() {
        return itemsInCart.size();
    }
    
    

    /**
     * get the array list object containing the items
     * @return ArrayList of items in the cart
     */

    public ArrayList<Item> getCart(){
        return itemsInCart;
    }
    
    

    /**
     * set quantity of the cart
     * @param cartQuantity int quantity of the cart
     */

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }
    
    

    /**
     * returns the string list of the items in the cart to be displayed for later
     * @return String list of the items in the cart
     */

    public String getItemsInCart() {
        String list = "Items in Cart:\n";
        for(Item item : itemsInCart){
            list += item.cartDesc();
        }
        return list;
    }
        
    

    /**
     * determines if the cart is empty or not
     * @return Boolean of whether cart is empty or not
     */

    public boolean isEmpty() {
        if (itemsInCart.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    

    /**
     * determines if the cart contains a certain item or not
     * @param item Item to be searched for
     * @return Boolean for found or not found
     */

    public boolean containsItem(Item item){
        if(itemsInCart.contains(item)){
            
            return true;
        } else {
            return false;
        }
    }
    
    

    /**
     * determines if the cart contains an item with specific id
     * @param id integer of the item to be found
     * @return Item object found in the cart
     */

    public Item containsItemWithId(int id){
        for(Item item : itemsInCart){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    

    /**
     * empties the cart
     * Satisfies SRS 3.1.1.9
     */

    public void emptyCart() {
        System.out.println("Emptying Cart.\n");
        itemsInCart.clear();
        System.out.println("The cart is now empty.\n");
    }
    
    

    /**
     * adds item to the cart by object
     * Satisfies SRS 3.1.1.2
     * @param item Item to be added
     */

    public void addItem(Item item){
        System.out.printf("Adding Item: %s to your cart.\n" , item.getName());
        itemsInCart.add(item);
        System.out.printf("Item: %s has been added to your cart.\n", item.getName());
    }
    
   

    /**
     * removes item from the cart by object
     * Satisfies SRS 3.1.1.3
     * @param item Item to be removed
     */

    public void removeItem(Item item) {
        System.out.printf("Removing Item: %s from your cart.\n" , item.getName());
        itemsInCart.remove(item);
        System.out.printf("Item: %s has been removed from your cart.\n", item.getName());
    }
    

    /**
     * returns the total unique items in the cart
     * @return int total items in cart that are unique
     */

    public int totalUniqueItems(){
        return itemsInCart.size();
    }
    

    /**
     *  prints a message
     */

    public void confirmCheckout() {
        System.out.println("Confirm your order?");
    }
    
    

    /**
     * changes the item quantity of a specific item to a specified amount
     * Satisfies SRS 3.1.1.10
     * @param item Item to change quantity of 
     * @param amount Int amount to change to
     */

    public void changeQuantity(Item item, int amount) {
        
        int ind = itemsInCart.indexOf(item);
        itemsInCart.get(ind).setQuantity(amount);
        System.out.println("You have changed " + item.getName() +"'s quantity to " + item.getQuantity() +".\n");
        //System.out.println("How many of the item would you like?");
    }
    
   

    /**
     * increases item quantity of an item by 1
     * @param item Item to be increased in quantity
     */

    public void increaseQuantity(Item item) {
        
        int ind = itemsInCart.indexOf(item);
        itemsInCart.get(ind).increaseQuantity();
        //System.out.println("How many of the item would you like?");
    }
    

    /**
     * decreases item quantity of an item by 1
     * @param item Item to be decreased in quantity
     */

    public void decreaseQuantity(Item item) {
        
        int ind = itemsInCart.indexOf(item);
        itemsInCart.get(ind).decreaseQuantity();
        //System.out.println("How many of the item would you like?");
    }
    
   

    /**
     * returns a descriptive string for the order summary
     * @return String to describe the cart fort the order
     */

    public String orderString(){
        String order = "\n";
        for(Item item : itemsInCart ){
            order += ("Item Name: " + item.getName() + " - " + "Item Cost: " + item.getPrice() +  " - Item Quantity: " + item.getQuantity() + "\n"  );
        }
        return(order);
    }
    

    /**
     * tells us the item information of the items in the cart
     * Satisfies SRS 3.1.1.1 and 3.1.1.6
     * @return String description of the cart's contents
     */

    public String cartString(){
        if(itemsInCart.isEmpty() == true){
            String emp = "Your cart is currently empty.";
            return emp;
        } else {
            String items = "\nYour cart currently contains:\n";
            for(Item item : itemsInCart){
                //items += ("Item Name")
                items += item.toString() + "\n";
            }
            return items;
        }
        
    }
    
}
