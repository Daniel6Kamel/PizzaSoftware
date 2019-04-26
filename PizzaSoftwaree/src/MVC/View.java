package MVC;

import java.awt.event.*;
import java.awt.FlowLayout;

import javax.swing.*;
import java.util.*;

public class View extends JFrame {
	
	String[] pizza = {"Chicken","Vegetarian","Pepperoni"};//The 3 types of pizza.
    String[] dough = {"Flatbread","Thin Crust"};//The 2 types of dough.
    
    private ArrayList<String> listOfToppings=new ArrayList<String>();//ArrayList that contains String(s) representing the extra toppings that the user chose.
    
	private JLabel PizzaType=new JLabel("Pizza Type:");
	private JComboBox<String> pizzaChoice=new JComboBox<String>(pizza);//Combo Box that contains the pizza types.
	
	private JLabel DoughType=new JLabel("Dough Type:");
	private JComboBox<String> doughChoice=new JComboBox<String>(dough);//Combo Box that contains the dough types.
	
	private JLabel extraTop=new JLabel("Chose extra Toppings:");
	private JCheckBox cheese=new JCheckBox("Extra Cheese");//check box representing if the user wants to chose Extra Cheese or not.
	private JCheckBox mushrooms=new JCheckBox("Mushrooms");//check box representing if the user wants to chose Mushrooms or not.
	private JCheckBox pineapple=new JCheckBox("Pineapple");//check box representing if the user wants to chose Pineapple or not.
	private JCheckBox sausage=new JCheckBox("Sausage");//check box representing if the user wants to chose Sausage or not.
	
	private JButton calcCost=new JButton("Calculate Cost");
	private JTextField costTF=new JTextField(5);
	
	private JButton placeOrder=new JButton("Place Order");//Button when clicked will create the user's pizza.
	
	private JPanel panel1 = new JPanel(); // panel 1 will contain the pizzaChoice JComboBox.
	private JPanel panel2= new JPanel(); // panel 2 will contain the doughChoice JComboBox.
	private JPanel panel3=new JPanel(); // panel 3 will contain the costTF JTextField.
	
	//Constructor
	public View(){
		super("Chose Your Pizza");
		Box boxLayout=Box.createVerticalBox();
		this.add(boxLayout); // using the box layout in our frame.
		this.setSize(510,390);
		this.setResizable(false); //user won't be able to change the frame size.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when pressing x the frame will close.
		
		panel1.setLayout(new FlowLayout()); 
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		
		boxLayout.add(PizzaType);
		panel1.add(pizzaChoice);
		
		boxLayout.add(panel1);
		boxLayout.add(DoughType);
		
		panel2.add(doughChoice);
		boxLayout.add(panel2);
		
		boxLayout.add(extraTop);
		boxLayout.add(cheese);
		boxLayout.add(mushrooms);
		boxLayout.add(pineapple);
		boxLayout.add(sausage);
		
		boxLayout.add(calcCost);
		panel3.add(costTF);
		boxLayout.add(panel3);
		
		boxLayout.add(placeOrder);
		
	}
	
	
	//method that will return true is the check box cheese is selected
	//this method will be used in the newFrameOnClick class.
	public boolean getCheeseBoolean() {
		if(cheese.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	//method that will return true is the check box mushrooms is selected
	//this method will be used in the newFrameOnClick class.
	public boolean getMushroomsBoolean() {
		if(mushrooms.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	//method that will return true is the check box pineapple is selected
	//this method will be used in the newFrameOnClick class.
	public boolean getPineappleBoolean() {
		if(pineapple.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	//method that will return true is the check box sausage is selected
	//this method will be used in the newFrameOnClick class.
	public boolean getSausageBoolean() {
		if(sausage.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	//method to get the pizza type that the user chose.
	public String getPizzaType() {
		return pizzaChoice.getSelectedItem().toString();
	}
	
	//method to get the dough type that the user chose.
	public String getDoughType() {
		return doughChoice.getSelectedItem().toString();
	}
	
	//the method that will add to the ArrayList the String(s) that the user chose by clicking their respective CheckBox.
	public ArrayList<String> getListOfStrings() {
		if(cheese.isSelected()) {
			listOfToppings.add("cheese");
		} 
		if(mushrooms.isSelected()) {
			listOfToppings.add("mushrooms");
		}
		if(pineapple.isSelected()) {
			listOfToppings.add("pineapple");
		}
		if(sausage.isSelected()) {
			listOfToppings.add("sausage");
		}
		return listOfToppings;
	}
	
	
	//set method for the text field that will show the cost of the pizza he has chosen before placing the order.
	public void setCostTF(int pizzaCost) {
		costTF.setText(Integer.toString(pizzaCost));
	}
	
	
	//when clicking the calcCost button the showPizzaCostListener method will be called,
	//what this method does is that it will call the setCostTF method that will show to the user the cost of the pizza he chose before placing the order.
	void showPizzaCostListener(ActionListener listenForCalcCostButton) {
		calcCost.addActionListener(listenForCalcCostButton);
	}
	
	//When clicking the placeOrder button the addPlaceOrderListener method will be called,
	//what that method does will be written in the PizzaController class.
	void addPlaceOrderListener(ActionListener listenForPlaceOrderButton){
		placeOrder.addActionListener(listenForPlaceOrderButton);
	}
}
