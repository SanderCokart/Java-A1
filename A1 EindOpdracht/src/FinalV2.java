public class FinalV2 {

	public static void main(String[] args) {

		int rows = Integer.parseInt(args[0]); // args0 is converted to an int and stored in rows
		int columns = Integer.parseInt(args[1]); // args1 is converted to an int and stored in columns
		int sum = 0;
		int averageofaverage = 0;

		int[] max = new int[columns];// creates a maximum integer array as an object with int as its type
		int[] min = new int[columns];// creates a minimum integer array as an object with int as its type

		int calculatedaverage = 0;
		int totalaverage = 0;
		int[] rowaverage = new int[rows];

//		System.out.println(rows); // print amount of rows specified
//		System.out.println(columns); // print amount of columns specified
//		System.out.println(); // add a enter space

		for (int c = 0; c < columns; c++) { // outer loop creating columns
			System.out.print("	");// prints a tab
			System.out.print(c);// prints the column number at the top of each column
			max[c] = 0;// sets the value of max to 0 relative to the column you're in
			min[c] = 100;// sets the value of min to 100 relative to the column you're in
		}
		System.out.println("	aver.:"); // puts the average a tab away from the column number
		System.out.println(); // goes to the next line

		for (int r = 0; r < rows; r++) { // loop for the rows, this also starts the first column

			System.out.print(r + "	");// shows row number on the left hand side and puts a tab in
			for (int c = 0; c < columns; c++) {
				int randomnumber = (int) (Math.random() * 100 + 1); // random number gets generated as double and is
																	// converted to an int using the cast (int)

				if (randomnumber > max[c]) {// if the randomly created number is bigger than max (which is 0) then max =
											// the randomly generated number
					max[c] = randomnumber;
				}

				if (randomnumber < min[c]) {// if the randomly created number is smaller than min (which is 100) then
											// min = the randomly generated number
					min[c] = randomnumber;
				}

				System.out.print(randomnumber + "	"); // prints out the random numbers plus a tab

				sum += randomnumber;// sum = 0 but will add up all the random numbers generated to sum
			}

			System.out.println(sum / columns);// prints the average which is sum devided by columns
			averageofaverage += sum / columns;// averageofaverage is the sum of all the row averages devided by the
												// amount of columns
			rowaverage[r] = averageofaverage;// rowaverage array is equal to the averageofaverage
			sum = 0;// sum gets reset back to 0 for next column
			totalaverage += averageofaverage;// total average is equal to averageofaverage
			calculatedaverage = totalaverage / rows;// calculated average becomes the total average devided by the
													// amount of rows
			averageofaverage = 0;// averageofaverage gets reset back to 0

		}
		System.out.println();// adds a enter space under the table
		System.out.print("min:	");// prints out min: plus a tab
		for (int c = 0; c < columns; c++) {// starts a loop the length equal to the amount of columns
			System.out.print(min[c] + "	");// prints out the minumum values at the bottom of the table and adds a tab
		}
		System.out.println(calculatedaverage);// prints the average of the averages
		System.out.print("max:	");// prints out the string max
		for (int c = 0; c < columns; c++) {// loop that continues for how many columns there are
			System.out.print(max[c] + "	");// prints out the max plus a tab
		}
		System.out.print(String.format("%.3f", GetDeviation(rowaverage)));// print out the return of GetDeviation with a
																			// formatting to shorten the double to 3
																			// numbers after the comma
	}

	public static double GetDeviation(int[] data) {// creation of a method to caculate the standard deviation
		double deviation = 0;// deviation is going to be a double and is initialized here
		double average = 0;
		for (int i = 0; i < data.length; i++) {// a loop that continues for as long as the array is. The array is
												// rowaverage but is redefined here as "data".
			average += data[i];// average becomes the sum of all the data inside the data array
		}
		average /= data.length;// average gets devided by the length of the data array
		for (int i = 0; i < data.length; i++) {// loop that runs for the length fo the array
			data[i] -= average;// data inside the array relative to the loop is subtracted by the value of
								// average
			data[i] = data[i] * data[i];// data inside the array relative to the loop equals itself squared
			deviation += data[i];// deviation is the sum of the newly calculated data array
		}
		deviation /= data.length;// deviation gets devided by the length of the array
		deviation = Math.sqrt(deviation);// gets the square route of deviation
		return deviation;// returns the deviation
	}

}
//end of program