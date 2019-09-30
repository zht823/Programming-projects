import java.util.Scanner;

public class Car {

	boolean[] ignitions = new boolean[10];
	char[] colors = new char[10];
	int[] xs = new int[10];
	int[] ys = new int[10];

	int i;
	boolean ignition;
	char color_char;
	int x;
	int y;

	public Car() {   //Constructor

	    for (int i = 0; i < ignitions.length; i++){
	    	ignitions[i] = false;
		    colors[i] = assignColor();
		    xs[i] = 1 + (int)(Math.random()*20);
		    ys[i] = 1 + (int)(Math.random()*20);
		}
	}

	public void setCar(int c) {
		i = c-1;
		ignition = ignitions[i];
		color_char = colors[i];
		x = xs[i];
		y = ys[i];

	}

	public char assignColor() {
		int color_random = 1 + (int)(Math.random()*5);
		if (color_random == 1) {
			color_char = 'R';
		} else if (color_random == 2) {
			color_char = 'G';
		} else if (color_random == 3) {
			color_char = 'B';
		} else if (color_random == 4) {
			color_char = 'W';
		} else if (color_random == 5) {
			color_char = 'S';
		}
		return color_char;
	}

	public void moveHorizontally () {
		Scanner in = new Scanner(System.in);
		if (ignition == false) {
			System.out.println("The ignition is off, car location is unchanged");
		} else {
			System.out.print("Enter a movement distance: ");
		    int y_move = in.nextInt();
		    if (y + y_move > 20 || y + y_move < 1) {
		    	System.out.println("Not in bounds, x is unchanged");
			} else {
				y = y + y_move;
			}
		}
		ys[i]=y;
	}

	public void moveVertically () {
		Scanner in = new Scanner(System.in);
		if (ignition == false) {
			System.out.println("The ignition is off, car location is unchanged");
		} else {
			System.out.print("Enter a movement distance: ");
		    int x_move = in.nextInt();
		    if (x + x_move > 20 || x + x_move < 1) {
		    	System.out.println("Not in bounds, y is unchanged");
		    } else {
		    	x = x + x_move;
		    }
		}
		xs[i]=x;
	}

	public void ignitionSwitch() {
		if (ignition == false) {
			ignition = true;
		} else if(ignition == true) {
			ignition = false;
		}
		ignitions[i] = ignition;
	}

	public String getColor() {
		String car_color = "color";		
		if (color_char == 'R') {
			car_color = "Red";
        } else if (color_char == 'G') {
        	car_color = "Green";
        } else if (color_char == 'B') {
        	car_color = "Blue";
        } else if (color_char == 'W') {
        	car_color = "White";
        } else if (color_char == 'S') {
        	car_color = "Silver";
        }
        return car_color;
	}

	public boolean getIgnition() {
		return ignition;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		String ignition_sign = "ignition";
        if (getIgnition() == true) {
        	ignition_sign = "On";
        } else {
        	ignition_sign = "Off";
        }

        System.out.println("");
        System.out.println("Car #" + (i+1) + " Information");
        System.out.println("Color: " + getColor());
        System.out.println("Ignition: " + ignition_sign);
        System.out.println("Location: (" + getY() + "," + getX() + ")");
  
		for (int row = 1; row <= x-1; row++) {
			for (int column = 1; column <= 20; column++)
				System.out.print("-");
			System.out.println();
		}
		for (int column = 1; column <= (y-1); column++)
			System.out.print("-");
	    System.out.print(color_char);
	    for (int column = 1; column <= 20-y; column++)
	    	System.out.print("-");
	    System.out.println(); 
		for (int row = 1; row <= 20-x; row++) {
			for (int column = 1; column <= 20; column++)
				System.out.print("-");
			System.out.println();
		}
		return "";
/*
        return (System.lineSeparator()+"Car#: "+(i+1)+" Information"+System.lineSeparator()+
        	"Color: "+getColor()+System.lineSeparator()+"Ignition: "+ignition_sign+
        	System.lineSeparator()+"Location: ("+getX()+","+getY() + ")"+System.lineSeparator());
*/
	}
}