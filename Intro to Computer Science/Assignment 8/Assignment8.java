import java.util.Scanner;
import java.io.*;

public class Assignment8 {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		final int M = 25;
		final int N =75;
		char [][] input = new char [M+2][N+2];
		char [][] output = new char [M+2][N+2];

		Scanner consoleReader = new Scanner(System.in);
		System.out.print ("Which file do you want to open? ");
		String filename = consoleReader.next();
		File file = new File(filename);
		Scanner fileReader = null;

		try { 
		   fileReader = new Scanner (file);
		}
		catch (Exception e) {
		   System.out.print("file " + file + " does not exist");
		   System.exit(0);
		}

		for (int row = 0; row < M; row ++) {
			String line = fileReader.nextLine();
			System.out.println(line);
			for (int col = 0; col < N; col++){
  				input[row+1][col+1] = line.charAt(col);
  			} 
  		}
  		System.out.println("");
        
        int generation = 1;
        int neighbour;
        int same_char;
        int input_num;
        while (true) { 
        	neighbour = 0;
        	same_char = 0;
  	     	for (int row = 1; row <= M; row ++) {
  	     		for (int col = 1; col <= N; col++){
  	     			neighbour = neighbours(input,row,col);
  			     	if (input[row][col] == 'X') {
  			     		if (neighbour < 2|| neighbour > 3)
  			     			output[row-1][col-1] = '.';
  					    else
  					      	output[row-1][col-1] = 'X';
  			        } else if (input[row][col] == '.') {	
  			        	if (neighbour == 3 )
  			        		output[row-1][col-1] = 'X';
  			    	    else
  			    		    output[row-1][col-1] = '.';
  			        }
  			    }
  	        }
  	        System.out.println("Generation number: " + generation);
  	        for (int row = 0; row < M; row ++) {
  	        	for (int col = 0; col < N; col++){
  	        		System.out.print(output[row][col]);
  	        		if (input[row+1][col+1] == output[row][col])
  	        			same_char++;
  	        		input[row+1][col+1] = output[row][col];
  			    } 
  			    System.out.println();
  	        }
  	        System.out.println();

  	        if (same_char == 25*75){ //check if any new change, if not then terminate the program
  	        	System.out.println("Successive generations will not yield any changes to the current generation.");
  	        	System.exit(0);
  	        }

  	        if (empty(output) == true){
  	        	System.out.println("The world becomes vacant.");
  	        	System.exit(0);
  	        }
            
            input_num = 0;
            char input_char;
  	        while (input_num!= 1 && input_num != 2) {
  	        	System.out.print("Please enter '1' if you want to generate a new generation or '2' if you want to terminate the program. ");
              input_char = in.next().charAt(0);
              if (Character.isDigit(input_char))
                input_num = Character.getNumericValue(input_char);
              else
                System.out.println("Exception: Input is not a digit. ");
  	        	if (input_num == 2)
  	        		System.exit(0);
  	        }
  	        generation ++;
  	    }
    }

  	public static int neighbours(char[][] input, int x, int y) {
  		int neighbour = 0;
  		if (input[x-1][y] == 'X')
  			neighbour++;
  		if (input[x-1][y-1] == 'X')
  			neighbour++;
  		if (input[x-1][y+1] == 'X')
  			neighbour++;
  		if (input[x][y] == 'X')
  			neighbour++;
  		if (input[x][y-1] == 'X')
  			neighbour++;
  		if (input[x][y+1] == 'X')
  			neighbour++;
  		if (input[x+1][y] == 'X')
  			neighbour++;
  		if (input[x+1][y-1] == 'X')
  			neighbour++;
  		if (input[x+1][y+1] == 'X')
  			neighbour++;
  		return neighbour;
  	}

  	public static boolean empty(char[][] output) {
  		for (int row = 0; row < output.length; row ++) {
  			for (int col = 0; col < output[row].length; col++){
  				if (output[row][col] == 'X')
  					return false;
  			}
  		}
  		return true;
  	}
}