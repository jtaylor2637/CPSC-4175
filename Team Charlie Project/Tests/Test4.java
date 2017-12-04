public static void Test(){
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
       
}