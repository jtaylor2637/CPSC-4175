#### Jacob Taylor
#### CPSC 4175
#### 9/9/17
### HW4

1) An entity class models information that is long lived, such as an account class for a banking software product. A boundary class models the interaction between the software product and its users or actors, such as a transaction processor class for any store software. A control class models mathematical computations and algorithms within its class, such as a class for computing required amounts of materials for a construction company.

2) A use case for my project is the "user places an item in their cart and places an order for the item they desired, the transaction is processed and order is shipped."

3) Successful Scenario:

	1. User A correctly types in their information into the login screen
	2. User A submits their login credentials to the authenticator.
	3. Upon verification, the application loads the store's home screen for the user.
	4. User A selects a textbook they need for their class.
	5. User A is directed to that specific textbooks page for further information.
	6. After reviewing the textbook information the user adds the book to their cart.
	7. User A navigates to their cart for checkout.
	8. User A confirms the items in their cart and presses the checkout button.
	9. The application directs the user to the payment confirmation page.
	10. User A chooses their payment method and confirms their order.
	11. User A's payment is processed and a transaction occurs.
	12. User A's order becomes processed and stored in their order history and the application database.
	13. User A awaits order delivery.
	14. User A receives order and is satisfied.
	
4) Unsuccessful Scenario:

	1. User A correctly types in their information into the login screen
	2. User A submits their login credentials to the authenticator.
	3. Upon verification, the application loads the store's home screen for the user.
	4. User A selects a textbook they need for their class.
	5. User A is directed to that specific textbooks page for further information.
	6. After reviewing the textbook information the user adds the book to their cart.
	7. User A navigates to their cart for checkout.
	8. User A realizes they added the wrong textbook to their cart.
	9. User A is unable to remove that item from their cart.
	10. User A does not place a new order due to frustration with the application.
	
5) Nouns: user, item, cart, order, transaction, textbook, screen, credentials, authenticator, application, page.
Entity Classes: user, item, order
Boundary Classes: transaction, cart

6) Diagram on git hub

7) CRC on git hub, used UML class diagram to model it.

8) Diagram on git hub

9) Diagram on git hub

10) Diagram on git hub
	