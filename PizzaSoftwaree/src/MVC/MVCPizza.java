package MVC;

public class MVCPizza {
	
	public static void main(String[] args) {
		PizzaModel pm=new PizzaModel();
		View v=new View();
		database db=new database();
		new PizzaController(pm,v,db);
		v.setVisible(true);
	}

}
