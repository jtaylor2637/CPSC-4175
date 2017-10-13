##3.0 Specific Requirements

###3.1 Functionality

	3.1.1 Cart

	    3.1.1.1 The cart shall display information about all products within it

		3.1.1.2 The cart shall allow the user to add products to it

		3.1.1.3 The cart shall allow the user to remove products from it

		3.1.1.4 The cart shall display the current total price of all items in it

		3.1.1.5 The cart shall only allow the user to see its contents

		3.1.1.6 The cart shall notify the user if it is empty before they view it

		3.1.1.7 The cart shall allow the user to save the status of their cart and come back to it later

		3.1.1.8 The cart shall allow user to confirm the contents of their cart and check out

		3.1.1.9 The cart shall allow the user to remove all items at once

		3.1.1.10 The cart shall allow the user to modify the quantity of the items in their cart

    3.1.2 Order

		3.1.2.1 The application shall allow the user to place an order of desired items originating from the cart

		3.1.2.2 The application shall allow the user to view the details of a specific order

		3.1.2.3 The application shall allow the user to view the items in a specific order

		3.1.2.4 The application shall allow the user to view the cost of a specific order

		3.1.2.5 The application shall allow the user to view the shipping status of an order

		3.1.2.6 The application shall assign a unique identifying order number for every order

		3.1.2.7 The application shall allow the user to cancel an order

		3.1.2.8 The application shall keep track of all orders for a user

		3.1.2.9 The application shall allow the user to search through past orders

		3.1.2.10 The application shall display valuable information about the order to the user when requested

		3.1.2.11 The application shall store order information to the database

		3.1.2.12 The application shall create an order summary as requested by user or admin

	3.1.3 User

		3.1.3.1 The application shall allow the user to login to their store account which is accessed with their unique name and their password

		3.1.3.2 The application shall keep all of the user’s information in a database, allowing the user to avoid reentering their information each time they use the site.

		3.1.3.3 The application shall allow the user to view their personal information

		3.1.3.4 The application shall allow the user to update their personal information

		3.1.3.5 The application shall display a menu of options for the user to choose from

		3.1.3.6 The application shall allow the user to navigate to their cart from the menu

		3.1.3.7 The application shall allow the user to view all the items available in the store

		3.1.3.8 The application shall allow the user to add money to their balance

		3.1.3.9 The application shall allow the user to purchase items from the store via the cart

	3.1.4 Item

		3.1.4.1 The application shall have a store consisting of all the items available for purchase

		3.1.4.2 The application shall display various information about the item which includes its name, description, cost, and quantity in stock

		3.1.4.3 The application shall allow the user to add items from the store to their cart

	3.1.5 Transaction Processor

		3.1.5.1 The application shall process transactions for a user after confirming an order

		3.1.5.2 The application shall prevent the transaction from occurring if the user does not have enough funds in their balance.

		3.1.5.3 The application shall prompt the user to add more funds if their order costs more than their available funds

		3.1.5.4 The application shall generate a unique identifying number for every transaction performed on the store

		3.1.5.5 The application shall store valid and completed transactions in a database with references to the order id number and user name


