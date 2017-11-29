/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementationnogui;

/**
 * The item class including its data and basic functions
 * @author jtayl
 */
public class Item {
    private String itemName; //item name
    private float itemPrice; //item price
    private String itemDescription; //item description
    private int itemId; //id 
    private int itemStock; //item stock
    private int itemQuantity; //item quantity
    
    /*
    default constructor
    */
    public Item(){
        setName("Basic Book");
        setPrice(100.00f);
        setDesc("Just your average book");
        setId(001);
        setStock(8);
        setQuantity(1);
        
    }
    
    /*
    custom constructor
    */
    public Item(String name, float price, String desc, int id, int stock, int quantity){
        setName(name);
        setPrice(price);
        setDesc(desc);
        setId(id);
        setStock(stock);
        setQuantity(quantity);
        
    }
    /*
    set item name
    */
    public void setName(String name) {
        this.itemName = name;
    }
    
    /*
    get item name
    */
    public String getName() {
        return(itemName);
    }
    /*
    set item price
    */
    public void setPrice(float price) {
        this.itemPrice = price;
    }
    /*
    get item price
    */
    public float getPrice() {
        return(itemPrice);
    }
    /*
    set item description
    */
    public void setDesc(String description) {
        this.itemDescription = description;
    }
    /*
    get item description
    */
    public String getDesc() {
        return(itemDescription);
    }
    /*
    set item id
    */
    public void setId(int id) {
        this.itemId = id;
    }
    /*
    get item id
    */
    public int getId(){
        return(itemId);
    }
    /*
    set item stock
    */
    public void setStock(int stock) {
        this.itemStock = stock;
    }
    /*
    get item stock
    */
    public int getStock(){
        return(itemStock);
    }
    /*
    set item quantity
    */
    public void setQuantity(int quantity) {
        this.itemQuantity = quantity;
    }
    /*
    get item quantity
    */
    public int getQuantity(){
        return(itemQuantity);
    }
    /*
    increase item quantity
    */
    public void increaseQuantity(){
        this.itemQuantity += 1;
    }
    /*
    decrease item quantity
    */
    public void decreaseQuantity(){
        this.itemQuantity -= 1;
    }
    /*
    get item information
    */
    public String toString() {
        return("Item Info:\n" + "Book Title: " + getName() + "\nBook Price: " + getPrice() + "\nBook Description: " + getDesc() + "\nBook Id: " + getId() + "\nBook Stock: " + getStock() + "\nBook Quantity: " + getQuantity() + "\n");
    }
    /*
    get shortened item information
    */
    public String cartDesc(){
        return("Book Title: " + getName() + "\nBook Price: " + getPrice() + "\nBook Description: " + getDesc() + "\nBook Quantity: " + getQuantity() + "\n");
    }
    
    
    
    
}
