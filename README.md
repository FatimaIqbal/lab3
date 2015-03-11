Author: Fatima Iqbal
Reg. No: 01137

*****	File transfer App in C and Java	*****

There are two file transfering applications one in C and the other one in Java.Both of them work in a similar way.The client connects to a server first and then
the server transfers a file to the client. After which the connection between them is finished. 

File tranfer using Java
There are two java classes in this app:
-client.java
-server.java

File transfer using C
There are two files in this app:
-client.c
-server.c

How to run code?
For running these apps, follow the following instructions:
-Copy these files in some folder in ubuntu
-Change the path of the sample file (file to be transfered) in the server.c and server.java
-Change the path of the sample file (according to where you want the new file to be created) in the client.c and client.java
-Save the changes
-Compile ad execute the code
-first run a client(may it be a java client or a c client) and then run a server(may it be java server or c server)

Format of sample file to be used
-You can use any text file for transfering.

Whats in unit_test class?
-Basically i have created my unit tests in this class
-I'm checking whether i can tranfer files across different platforms and across same platforms

Whats in the server.c and server.java files?
-server files basically listen for a client at the said port
-after a client comes a connection is established between the two
-then the server stars transfering the said file to the client
-after transfering the file the connection between the two is closed 

whats in the client.c and client.java files?
-client initiates a connection with a server given the port at which the server is listening
-after that it starts recieving a file , which is being saved at the said path and file
-and lastly the connection is closed


Following is the link of the source code on github
https://github.com/FatimaIqbal/lab3.git
