package MVC;

import javax.swing.*;

public class newFrameOnClick extends JFrame{
	
	//this frame will be visible when the user press on the place order button 
	//it will show the needed steps to prepare a pizza and will show the user that his pizza
	//has been put in the box and ready to be taken.
	
	private PizzaModel pm;
	private View v;
	
	private String shownOnTheJTextField="";
	
	private JLabel prepDough=new JLabel("Preparing the dough of type: ");
	private JTextField doughTF=new JTextField(15);
	
	private JLabel addingIngredients=new JLabel("Adding the extra toppings :");
	private JTextField theExtraToppings=new JTextField(25);
	
	private JLabel backingPizza=new JLabel("Backing the pizza of type:");
	private JTextField pizzaTF=new JTextField(10);
	
	private JLabel pizzaCost=new JLabel("The pizza cost is equal to: ");
	private JTextField costTF=new JTextField(3);
	
	private JLabel pizzaFinished=new JLabel("Pizza is now in the box and ready to be taken.");

	//Constructor.
	public newFrameOnClick(PizzaModel pm,View v) {
		super("Your Pizza Order");
		
		this.pm=pm;
		this.v=v;
		
		this.setVisible(true);
		
		Box boxLayout=Box.createVerticalBox();
		this.add(boxLayout);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boxLayout.add(prepDough);
		boxLayout.add(doughTF);
		setDoughTField();
		
		boxLayout.add(addingIngredients);
		boxLayout.add(theExtraToppings);
		setExtraToppingsField();
		
		boxLayout.add(backingPizza);
		boxLayout.add(pizzaTF);
		setPizzaTField();
		
		boxLayout.add(pizzaCost);
		boxLayout.add(costTF);
		setCostField();
		
		boxLayout.add(pizzaFinished);
		
		
		
	}
	
	
	//method to show the dough type that the user chose.
	public void setDoughTField() {
		doughTF.setText(pm.getDough());
	}
	
	//method to show the pizza type that the user chose.
	public void setPizzaTField() {
		pizzaTF.setText(pm.getType());
	}
	
	//method to show the pizza cost of the pizza that the user chose.
	public void setCostField() {
		costTF.setText(Integer.toString(pm.getCost()));
	}
	
	//method to show the extra toppings that the user chose.
	public void setExtraToppingsField(){
		if(v.getCheeseBoolean()) {
			shownOnTheJTextField+=" Extra Cheese";
		}
		if(v.getMushroomsBoolean()) {
			shownOnTheJTextField+=" Mushrooms";
		}
		if(v.getPineappleBoolean()) {
			shownOnTheJTextField+=" Pineapple";
		}
		if(v.getSausageBoolean()) {
			shownOnTheJTextField+=" Sausage";
		}
		if(!v.getCheeseBoolean() && !v.getMushroomsBoolean() && !v.getPineappleBoolean() && !v.getSausageBoolean()) {
			shownOnTheJTextField="No Extra Toppings.";
		}
		
		theExtraToppings.setText(shownOnTheJTextField);  
	}
}
