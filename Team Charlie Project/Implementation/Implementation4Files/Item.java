/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

/**
 * The item class including its data and basic functions
 * @author Team Charli
 */
public class Item {
    private String itemName; //item name
    private float itemPrice; //item price
    private String itemDescription; //item description
    private int itemId; //id 
    private int itemStock; //item stock
    private int itemQuantity; //item quantity
    
    

    /**
     * Default item constructor
     */

    public Item(){
        setName("Basic Book");
        setPrice(100.00f);
        setDesc("Just your average book");
        setId(001);
        setStock(8);
        setQuantity(1);
        
    }
    
    

    /**
     * custom constructor
     * @param name String name of the item
     * @param price Float price of the item
     * @param desc String description of the item
     * @param id Int id of the item
     * @param stock Int stock of the item
     * @param quantity Int quantity of the item being purchased
     */

    public Item(String name, float price, String desc, int id, int stock, int quantity){
        setName(name);
        setPrice(price);
        setDesc(desc);
        setId(id);
        setStock(stock);
        setQuantity(quantity);
        
    }
    

    /**
     * set item name
     * @param name String item name
     */

    public void setName(String name) {
        this.itemName = name;
    }
    
    

    /**
     * get item name
     * @return String item name
     */

    public String getName() {
        return(itemName);
    }
    

    /**
     * set item price
     * @param price Float price of the item
     */

    public void setPrice(float price) {
        this.itemPrice = price;
    }
    

    /**
     * get item price
     * @return Float price of the item
     */

    public float getPrice() {
        return(itemPrice);
    }
    

    /**
     * set item description
     * @param description String description of the item
     */

    public void setDesc(String description) {
        this.itemDescription = description;
    }
    

    /**
     * get item description
     * @return String description of the item
     */

    public String getDesc() {
        return(itemDescription);
    }
    

    /**
     * set item id
     * @param id Int id of the item
     */

    public void setId(int id) {
        this.itemId = id;
    }
    


    /**
     * get item id
     * @return Int id of the item
     */

    public int getId(){
        return(itemId);
    }
    

    /**
     * set item stock
     * @param stock Int stock of the item
     */

    public void setStock(int stock) {
        this.itemStock = stock;
    }
    

    /**
     * get item stock
     * @return Int stock of the item
     */

    public int getStock(){
        return(itemStock);
    }
    

    /**
     * set item quantity
     * @param quantity Int quantity of the item
     */

    public void setQuantity(int quantity) {
        this.itemQuantity = quantity;
    }
    

    /**
     * get item quantity
     * @return Int quantity of the item
     */

    public int getQuantity(){
        return(itemQuantity);
    }
    

    /**
     * increase item quantity
     */

    public void increaseQuantity(){
        this.itemQuantity += 1;
    }
    

    /**
     * decrease item quantity
     */

    public void decreaseQuantity(){
        this.itemQuantity -= 1;
    }
    
    /**
     * @return String item information  
     * 
     */
    public String toString() {
        return("Item Info:\n" + "Book Title: " + getName() + "\nBook Price: " + getPrice() + "\nBook Description: " + getDesc() + "\nBook Id: " + getId() + "\nBook Stock: " + getStock() + "\nBook Quantity: " + getQuantity() + "\n");
    }
    

    /**
     *
     * @return String description of the item for the cart summary
     */

    public String cartDesc(){
        return("Book Title: " + getName() + "\nBook Price: " + getPrice() + "\nBook Description: " + getDesc() + "\nBook Quantity: " + getQuantity() + "\n");
    }
    
    
    
    
}
