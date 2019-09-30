public class Checkout {

	public DessertItem[] array;
	private int num = 0;

	public Checkout() {
		array = new DessertItem[100];
	}

	public void clear() {
		for (int i = 0; i < num; i++)
			array[i] = null;
		num = 0;
	}

	public void enterItem(DessertItem item) {
		array[num] = item;
		num++;
	}

	public int numberOfItems() {
		return (num);
	}

	public int totalCost() {
		int sum = 0;
		for (int i = 0; i < num ; i++)
			sum += array[i].getCost();
		return sum;
	}

	public int totalTax() {
		return (int)Math.round(this.totalCost() * DessertShoppe.TAX_RATE / 100);
	}

	public String toString() {
		System.out.println("\n"+"     " + DessertShoppe.STORE_NAME);
		System.out.print("     ");
		for (int i = 0; i < DessertShoppe.STORE_NAME.length(); i++) // print ("-")
			System.out.print("-");
		System.out.println("\n");
		for (int i = 0; i < num; i++) {
			if (array[i] instanceof Sundae) {
				System.out.println(((Sundae)array[i]).getSundae());
			} else if (array[i] instanceof Candy) {
				System.out.println(((Candy)array[i]).weight + " lbs. @ " + DessertShoppe.cents2dollarsAndCents(((Candy)array[i]).price_per_pound) + " /lb.");
			} else if (array[i] instanceof Cookie) {
				System.out.println(((Cookie)array[i]).number + " @ " + DessertShoppe.cents2dollarsAndCents(((Cookie)array[i]).price_per_dozen) + " /dz.");
			}
			System.out.print(array[i].name);
			for (int n = (array[i].name).length(); n < 27; n++) {
				System.out.print(" ");
			}
			System.out.print(DessertShoppe.cents2dollarsAndCents(array[i].getCost()));
			System.out.println();
		}
		System.out.println();
		System.out.println("Tax\t\t\t    " + DessertShoppe.cents2dollarsAndCents(totalTax()));
		System.out.println("Total Cost \t\t  " + DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax()));
		return"";
	}



}