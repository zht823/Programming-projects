public class Cookie extends DessertItem {
	public String name;
	public int number;
	public int price_per_dozen;

	public Cookie(String name, int number, int price_per_dozen) {
		super(name);
		this.number = number;
		this.price_per_dozen = price_per_dozen;
	}

	public int getCost () {
		return (int)Math.round(price_per_dozen / 12 * number + 0.5);
	}
}