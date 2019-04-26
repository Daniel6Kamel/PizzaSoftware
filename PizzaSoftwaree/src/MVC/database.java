package MVC;

import java.sql.*;

public class database {
	private String url="jdbc:MySQL://localhost:3306/pizzadb";
	private String username="daniel";
	private String pass="kamel";
	
	PizzaModel pm;
	
	//using MySQL database in my localhost (phpMyAdmin)
	public String getURL() {
		return url;
	}
	
	//my username is daniel
	public String getUserName() {
		return username;
	}
	
	//my password is kamel
	public String getPass(){
		return pass;
	}
	
	//this method will be executed when the user press on the placeOrder Button,
	//it will insert into the database the pizza type in the pizzaType column,
	// and the pizza dough type in the pizzaDoughType column,YES in the extraCheese 
	// and/or YES in the Mushrooms and/or YES in the Pineapple and/or YES in the Sausage columns 
	// if the user chose those extra toppings and NO in the respective columns if the user didn't.
	//Also it will insert the cost of the pizza in the pizzaCost column.
	public void execUpdate(PizzaModel pm) {
		this.pm=pm;
		try {
			Connection myConn=DriverManager.getConnection(getURL(), getUserName(), getPass());
			PreparedStatement pt=myConn.prepareStatement("insert into pizzatable(pizzaType,pizzaDoughType,extraCheese,Mushrooms,Pineapple,Sausage,pizzaCost)values(?,?,?,?,?,?,?)");
			pt.setString(1,pm.getType());
			pt.setString(2,pm.getDough());
			pt.setString(3,pm.getExtraCheese());
			pt.setString(4,pm.getMushrooms());
			pt.setString(5, pm.getPineapple());
			pt.setString(6,pm.getSausage());
			pm.calculateCost();//to calculate the cost before getting it,because the cost is initially equal to 0.
			pt.setInt(7, pm.getCost());
			
			pt.executeUpdate();
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
}
