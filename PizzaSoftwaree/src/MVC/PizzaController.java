package MVC;

import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PizzaController {
	
	
	
	//The PizzaController will coordinate interactions between the PizzaModel and the View.
	private PizzaModel pm;
	private View v;
	private database db;
	
	//Constructor.
	public PizzaController(PizzaModel pm,View v,database db) {
		this.pm=pm;
		this.v=v;
		this.db=db;
		
		// Tell the View that when ever the placeOrder button,
		// is clicked to execute the actionPerformed method,
		// in the placeOrderListener inner class.
		this.v.addPlaceOrderListener(new placeOrderListener());
		
		//tell the view that when the user press on the calculate cost button,
		//to execute the actionPerformed method,
		//in the showCostListener inner class.
		this.v.showPizzaCostListener(new showCostListener());
	}
	
	
	//will open a new JDialog which will show the cost of the pizza that the user want before placing the order.
	class showCostListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String pType=v.getPizzaType();
			String dType=v.getDoughType();
			ArrayList<String> ListOfeT=v.getListOfStrings();
			
			pm.setType(pType);
			pm.setDough(dType);
			
			//check the ArrayList(that was created in the view),
			//if it's size if positive,
			//add those extra toppings to the PizzaModel List 
			//so that the getCost() method would be able to calculate the cost of the user's chosen pizza.
			if(ListOfeT.size()!=0) {
				for(String str : ListOfeT) {
					if(str.equals("cheese")) {
						pm.addToExtraToppings("ExtraCheese");
					}
					if(str.equals("mushrooms")) {
						pm.addToExtraToppings("Mushrooms");
					}
					if(str.equals("sausage")) {
						pm.addToExtraToppings("Sausage");
					}
					if(str.equals("pineapple")) {
						pm.addToExtraToppings("Pineapple");
					}
				}
			}
			
			pm.calculateCost();//calculate the pizza cost
			
			v.setCostTF(pm.getCost());//set the cost of the pizza in the costTF text field.
			
			pm.setCost(); //put the cost back to 0 so it won't accumulate every time the user press on
						  //the calculate cost button or when he press on the place order button.
			
			ListOfeT.clear(); //because the user didn't place his order we don't want to register his 
							  //extra toppings choices,this is why after the cost will be shown
							  //to the user we will clear the List in the View and set it's size back to 0.
			
			pm.getExtraToppingsList().clear();// we also want to clear and set back the size
											  //of the extraToppings List in the PizzaModel
											  //so when the calcButton method will be called after pressing
											  //the Place Order button won't calculate also the cost of
											  //toppings that were chosen when the calcCost button was pressed.
		}
		
	}
	
	
	class placeOrderListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String pType=v.getPizzaType();
			String dType=v.getDoughType();
			ArrayList<String> ListOfeT=v.getListOfStrings();
			
			pm.setType(pType);
			pm.setDough(dType);
			
			//check the ArrayList(that was created in the view),
			//if it's size if positive,
			//add those extra toppings to the PizzaModel List 
			//so that the getCost() method would be able to calculate the cost of the user's chosen pizza.
			if(ListOfeT.size()!=0) {
				for(String str : ListOfeT) {
					if(str.equals("cheese")) {
						pm.addToExtraToppings("ExtraCheese");
					}
					if(str.equals("mushrooms")) {
						pm.addToExtraToppings("Mushrooms");
					}
					if(str.equals("sausage")) {
						pm.addToExtraToppings("Sausage");
					}
					if(str.equals("pineapple")) {
						pm.addToExtraToppings("Pineapple");
					}
				}
			}
			
			
			
			//when clicking this button the information of the pizza will be inserted into the database.
			db.execUpdate(pm);
			
			
			//this will open a new JFrame,
			//in that JFrame will be shown the steps to prepare the pizza.
			new newFrameOnClick(pm,v);
			
			
			//And at the end we will close the window using setVisible(false) and dispose().
			v.setVisible(false);
			v.dispose();
		}
		
	}
}
