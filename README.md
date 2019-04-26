# PizzaSoftware
(Please note that my code is heavily commented.)
I made a software in which I used the MVC design pattern and I downloaded WAMP which contains phpMyAdmin to use the MySQL server.
I used the Eclipse IDE so I had to download the jdbc driver from from: dev.mysql.com/downloads/connector/j/ and here is a tutorial for downloading the connector j and to add the mysql database driver to classpath: https://www.youtube.com/watch?v=2i4t-SL1VsU&list=PLEAQNNR8IlB4R7NfqBY1frapYo97L6fOQ&index=2
Here is a tutorial(that i found useful) on the MVC design pattern: https://www.youtube.com/watch?v=dTVVa2gfht8&t=1s


**Here is what this java software is all about:**

We need to build a software for a pizza restaurant who wants to prepare different types of pizzas, e.g. Chicken Pizza, Pepperoni Pizza, and Vegetarian. 

Pizza types prices: 
· Chicken Pizza: 10$ 
· Pepperoni Pizza: 9$ 
· Vegetarian Pizza: 8$ 

There are 2 types of dough: Flatbread & Thin Crust. Customers can choose any of them without an extra cost. 
Prices for extra toppings: 

· Extra cheese 2$ 
· Mushrooms 1$ 
· Pineapple 2$ 
· Sausage 2$ 

User should be able to select the pizza type, dough type and also add extra toppings. The total price should be calculated based on customers choice. 

Below are the needed steps to prepare all types of pizza: 
1. Prepare the dough 
2. Add sauce and ingredients 
3. Bake the pizza 
4. Put in box 

The needed software should be a Java application that executes the logic to prepare pizzas, it should have a friendly user interface (using Swing) that allows the user to select the pizza and the dough type, add extra toppings, calculate the total price and place an order. 
All orders with the corresponding selected options and price should be stored in a database table of your choice after placing orders. 
