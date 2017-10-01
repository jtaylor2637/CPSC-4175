#### HW6

#### 9/30/17

#### Jacob Taylor

#### CPSC 4175

1) Languages: Java and C++. Domains for Java: Developing an android mobile application, and developing an application for a university that must run on all platforms and handles server-side processes, it would be unwise to choose C++ for these domains because java is the basis of android development kit, java is cross platform and can run on any device that has a Java run time environment, and also is a server side interpreted language to be used for web servers. For C++ if I needed to create a mobile application that worked on all phones, I would use C++ because it is supported by Apple, Android, and Windows Phones, and if I was tasked with creating a video game, I would use C++ in unreal engine because I could create a higher quality game than using java.

2) One bad example with variable name practices is if I am creating a program that takes tons of user input to do computations and instead of naming each variable something relevant to the computation, I name them userIn1 userIn2, and so on. Another bad example would be to program a application that utilizes several libraries that aren't commonly known, and during one of the methods many imported functions are utilized without comments explaining what they are accomplishing.

3) IBM coding standards for procedures start with a series of prologue comments that have a title, purpose, history of changes, the return values, and how to call the procedure. Another standard for SQL/PL is to list the arguments of the procedure below the line calling the procedure. I prefer the IBM method which explains every procedure and makes it easier to understand.

4) I have had this happen when I was programming assignments in Data Structures. Instead of typing the for loop to print out all of the values in whatever collection I was working with, I created a method which handled generic types and printed out the contents as needed.

5) A stub is a class or artifact that must be created in order to test another class. A driver is a code artifact that must be called by two parent artifacts in order to test it. I have used stubs before in games programming. When I wanted to test a new command length in my text based game I needed to add the new command class and link it to my parser and the classes it would affect even without providing all of the functionality that the command would do.

6) Two strengths of top down integration are fault isolation and early detection of design flaws. A weakness it that potentially reusable code artifacts may not be adequately tested.

7) Two strengths of bottom up integration are that testing is done with the aid of drivers and operational artifacts are thoroughly tested, and that it supports fault isolation. Its weakness is that design faults are detected late in the implementation.

8) A DSL is similar to the testing of the interfaces done between the logical artifacts and the operational artifacts once they are done with integration. The interface between the layers reduces the risk of errors created when piecing them together.

9) Testing carried out by the implementation group will not be anywhere close to as thorough as the SQA group, and oftentimes the implementation group may not test an artifact due to their incorrect assumption created by overconfidence that the artifact they created should work. Also the SQA will be able to settle differences between two different members of the implementation group's work easier than an internal compromise.

10) Dijkstra letter focuses on the abolishment of the goto statement. However, I feel that in today's programming world, multitasking, multi-threading, and other parallel processes are so common in required projects that having some form of jump or subroutine seems necessary. He goes through the progress of the process to explain how he believes there should not be any sudden jumps, and that it should be linear. I agree that the programmer typically feels he or she is done after the program compiles, and that the machine takes over during the execution. Overuse of the goto is not a good practice to have, and I personally haven't used in but in assembler, but I believe that with good structure and design a program could use it without breaking the intended progress of the process.