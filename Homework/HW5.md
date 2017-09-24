### Jacob Taylor
#####  HW5
##### CPSC4175
##### 9/24/17

1. The two basic ways of designing a product is data oriented design and operation oriented design. Operation oriented design focuses on operation, an example being data flow analysis. Data oriented design focuses on data first, then the procedures are designed to conform to the data structure.

2. The input to the design work flow is the specification document, and the output is the design document. The specification document influences design by showing the designer what the program needs to accomplish, therefore affecting how they solve those required functions. The design document affects design because it represents the current working plan of how to design the project to best satisfy the requirements.

3. Input variables: Hours Completed, Good Standing, Required Classes Completed, Degree Major, Name, ID. Data Variables: Minimum Hours, Good or Bad Standing, Completed Required Classes, Major Desired. Output Variables: AbleToGraduate

4. Transaction: Enter Student Information broken down into sub procedures such as Enter hours completed, classes completed etc. Determine Eligibility broken down into validate minimum hours, validate good standing, validate minimum required classes. Display Eligibility just tells whether you can graduate or not.

5. One class that might be appropriate would be a RequiredClasses class. It would contain attributes such as the current Major, current Student, and a array list of the classes. The behaviors would be to get and set the student, major, and different required classes, add or remove a required class, change the completion status of a class, and a determine if all completed method.

6. I believe that our project focuses more on the iterative design phase which includes analysis, implementation, and testing. one reason I believe this is the case is because our class is designed to use the four phases. Another reason would be that the process of creating software is a continuous process of utilizing the different phases to make a well designed product that does what it is required to do. When developing software, you are always testing, designing, analyzing and implementing.

7. Testing an implementation is simply seeing if the code can produce correct output, but testing a design means making sure the code is satisfying all the requirement specifications from the design plan. One procedure for testing the design would be to create many students of different majors, and determine if the implementation accounts for different required classes for each different major. An object oriented design based procedure for this problem would be to determine if the minimum classes required, and hours required are dependent on the major of the student.

8. The cyclomatic complexity of figure 1 is 3 because it has two conditional branches plus the 1 from the formula. I'm not sure if it would be infinite because the condition 2 is rechecked after procedure 4.

9. I used the ARGO case tool. It seems like it could be useful to speed up the process of making tons of gets and sets methods for classes, but overall I feel like you will have to do the editing in the code after generating it anyhow. I just find it easier to do it by hand in the IDE.

10. The article brings up some good points regarding software design. The way that the shuttle group focuses a huge amount of effort into the design and testing phases reduces the chances of errors in the final code dramatically. I could not even imagine writing so much documentation regarding every little change in the code. I commend this group for their incredible ability to create near perfect code. The article does make some assumptions regarding coders however that I believe are unfair, it shouldn't be assumed that in order to create perfect software you have to be an ordinary person who can't stand out from the crowd, I believe it just takes an immense amount of time and effort to focus in on the software developing process in order to create software that's more than just good enough.