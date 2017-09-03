### Jacob Taylor ###
### Homework 3 ###
### 9/3/17 ###
### CPSC 4175 ###

1) The software requirements specification must contain what the product must do, and the constraints on the product.

2) An example of ambiguity is "All users will have an unique identifier." This could draw confusion by meaning that each user must have an identifier, or that all users share the same identifier for the group of users.

3) This Data Flow Diagram shows the flow of data in and out of the student grades domain. The grading system is the process to which all 
the data goes through. The three entities of student, instructor, and student records system all send data to the grading system. For example, the student sends completed work to the system, and receives graded work in return.

4) This diagram is a finite state machine for the shopping cart. It shows initial and end states of user login and log-out, and the various states of the cart. The user views their cart then decides to add, remove, or clear their cart. After their cart is in the state they desire, they can checkout or log-out. 

5) This is a entity relationship diagram of a database. The three entities are order, product, and customer, each with their own primary key and relationship to other tables. The order includes many products, and the customer can make many orders.

6) This diagram represents a SADT design of our online store project. The four phases are login, navigation, ordering, and transaction processing. The arrows pointing into the boxes represent input required to perform the actions in the boxes. The arrows coming from above the boxes represent controls which affect the processes. For example, User login process requires server connection to login to the account, and also requires the user name and password as input to enter the account.

7) This Specification and Description Language design document shows the various states, inputs, and outputs of the project. The process starts and waits user login, verifies the information and continues to the home screen if valid. Then the user can log-out and view cart to add items. The user has options to remove or add items as shown by the branched arrows. The checkout results in an order being generated, and then
transaction processing occurs based on balance. Then the 	user can log-out or continue shopping.

8) This is a simple operation done in the Z language. The operation is called check in and executes whenever there is a change in the log. The operation checks to see if the name we are looking for is in staff, then that the name is in the set of checked out staff.
Afterwards it adds the name to the checked in set, and removes them from the checked out set. Finally it keeps the user set the same size.