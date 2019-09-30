import java.util.Scanner;

public class Assignment7 {
  
	public static void main(String[] args) {
	    Car car = new Car();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a number between 1-10 to select a car:");
		System.out.print("Input: ");
		int c = in.nextInt();
	    car.setCar (c);
	    System.out.println(car.toString());

		do{
			System.out.println("");
			System.out.println("What would you like to do?");
			System.out.println("1: Turn the ignition on/off");
			System.out.println("2: Change the position of the car");
			System.out.println("3: Change cars");
			System.out.println("Q: Quit program");
			System.out.print("Input: ");
			char input = in.next().charAt(0);
			System.out.println("");

			if (input == '1') {
				car.ignitionSwitch();
			} else if (input == '2') {
				System.out.println("In which direction do you want to move the car?");
				System.out.println("H: Horizontal");
				System.out.println("V: Vertical");
				System.out.print("Direction: ");
				String direction = in.next();
				System.out.println();
				if (direction.equals("H")) {
					car.moveHorizontally();
				} else if (direction.equals("V")) {
				    car.moveVertically();
				} else {
					System.out.println("Cannot recognize the direction. Please type H or V only!");
				}
			} else if (input == '3') {
				System.out.println("Which car would you like to use? (Choose from 1-10)");
		        System.out.print("Input: ");
		        c = in.nextInt();
		        car.setCar(c);
			} else if (input == 'Q') {
				System.exit(0);
			} else {
				System.out.println("Cannot recognize your input. Please type 1, 2, Q only!");
			}
			System.out.println(car.toString());
		} while(true);
	}
}