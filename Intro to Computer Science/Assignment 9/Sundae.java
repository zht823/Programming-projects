public class Sundae extends IceCream {
	private String name;
	private String sundae;
	private int topping_cost;

	public Sundae(String name, int icecream_cost, String topping, int topping_cost) {
		super(name, icecream_cost);
		this.topping_cost = topping_cost;
		this.sundae = topping + " Sundae with";
	}

	public int getCost () {
		return super.getCost() + topping_cost;
	}

	public String getSundae () {
		return sundae;
	}



}