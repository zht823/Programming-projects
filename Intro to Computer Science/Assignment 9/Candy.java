public class Candy extends DessertItem{
	public String name;
	public double weight;
	public int price_per_pound;

	public Candy(String name, double weight, int price_per_pound) {
		super(name);
		this.weight = weight;
		this.price_per_pound = price_per_pound;
	}

	public int getCost () {
		return (int)Math.round(price_per_pound * weight);
	}
}