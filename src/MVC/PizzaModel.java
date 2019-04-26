package MVC;

import java.util.*;

public class PizzaModel {
	
	private int cost; 
	private String type;
	private String dough;
	private List<String> extraToppings=new ArrayList<String>();//list that will contain the extra toppings if any.

	//set the pizza type method.
	public void setType(String n) {
		type= n;
	}
	
	//get the pizza type method.
	public String getType() {
		return type;
	}

	//set the dough method method.
	public void setDough(String d) {
		dough= d;
	}
	
	//get the dough method.
	public String getDough() {
		return dough;
	}
	
	//method to add the extra toppings to the list.
	public void addToExtraToppings(String eT) {
		extraToppings.add(eT);
	}
	
	
	//method to get the extraToppings ArrayList so it can be used in the PizzaController class,
	//to then be able to clear the list using the method clear() when the user press on the calcCost button,
	//because the user didn't place the order and when he pressed on the calcCost button it called the calculateCost method,
	//which adds in the extraToppings ArrayList the chosen extra toppings, but because the user didn't place the order,
	//we don't want those extra toppings to be in the list, so we have to clear it bu using the clear() method 
	public List<String> getExtraToppingsList() {
		return extraToppings;
	}
	
	
	
	//method that return YES if the user has added extra Cheese to his pizza
	//returns NO if he didn't.
	//will be used in the database class.
	public String getExtraCheese() {
		if(extraToppings.size()!=0) {
			if(extraToppings.contains("ExtraCheese")) {
				return "YES";
			}else {return "NO";}
		}else {
			return "NO";
		}
	}
	
	//method that return YES if the user has added Mushrooms to his pizza
	//returns NO if he didn't.
	//will be used in the database class.
	public String getMushrooms() {
		if(extraToppings.size()!=0) {
			if(extraToppings.contains("Mushrooms")) {
				return "YES";
			}else {return "NO";}
		}else {
			return "NO";
		}
	}
	
	//method that return YES if the user has added Pineapple to his pizza
	//returns NO if he didn't.
	//will be used in the database class.
	public String getPineapple() {
		if(extraToppings.size()!=0) {
			if(extraToppings.contains("Pineapple")) {
				return "YES";
			}else {return "NO";}
		}else {
			return "NO";
		}
	}
	
	
	//method that return YES if the user has added Sausage to his pizza
	//returns NO if he didn't.
	//will be used in the database class.
	public String getSausage() {
		if(extraToppings.size()!=0) {
			if(extraToppings.contains("Sausage")) {
				return "YES";
			}else {return "NO";}
		}else {
			return "NO";
		}
	}
	
	
	
	//method to calculate the cost of the pizza created.
	public int calculateCost(){
		if(type=="Chicken") {
			cost+=10;
		}else if(type=="Pepperoni") {
			cost+=9;
		}else {
			cost+=8;
		}
		if(extraToppings.size()!=0) {
			for(String element:extraToppings) {
				if(element.equals("ExtraCheese")) {
					cost+=2;
				}else if(element.equals("Mushrooms")) {
					cost+=1;
				}else if(element.equals("Pineapple")) {
					cost+=2;
				}else if(element.equals("Sausage")) {
					cost+=2;
				}
			}
		}
		
		return cost;
	}
	
	//method to get the cost of the pizza.
	public int getCost() {
		return cost;
	}
	
	//method to set cost back to 0 after the user press on the calcCost button
	public void setCost() {
		cost=0;
	}
		
}
