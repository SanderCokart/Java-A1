
public class HelpingFalco {

	public static void main(String[] args) {
		int rows = Integer.parseInt(args[0]);// aantal rijen
		int columns = Integer.parseInt(args[1]);// aantal columns
		int sumOfRow = 0;// som van de rijen wordt gedefineerd
		int sumOfAll = 0;// som van alle rijen wordt gedefineerd
		int averageOfRow = 0;// gemiddelde van de rij voor gedefineerd
		int[] deviationData = new int[rows];// deviation data is een object met de lengte van het aantal rijen

		int[] max = new int[columns];// max array wordt een object met de lengte van het aantal kolommen
		int[] min = new int[columns];// min array wordt een object met de lengte van het aantal kolommen

		for (int c = 0; c < columns; c++) {// loop door de eerste lijn aan code en print de column nummers uit
			System.out.print("\t" + (c+1));// print column nummers uit
			min[c] = 100;// min wordt alvast gedefineerd voor alle kolommen
			max[c] = 0;// max wordt alvast gedefineerd voor alle kolommen
		}
		System.out.println("\t" + "average");// print het woord average aan het einde van de kolom nummers

		System.out.println();// maak een lege regel
		System.out.println();// maak een lege regel

		for (int r = 0; r < rows; r++) {// buiten loop voor het maken van de rijen
			System.out.print(r+1 + "	");// zet het nummer voor de rijen neer met een tab

			for (int c = 0; c < columns; c++) {// binnen loop voor het maken van de kolommen

				int randomnumber = (int) (Math.random() * 100 + 1);// random nummer wordt gemaakt

				if (randomnumber < min[c]) {// checkt if randomnumber kleiner is dan min (min = 0)
					min[c] = randomnumber;// als randomnumber kleiner is dan 100 wordt dat het nieuwe min voor die kolom
				}

				if (randomnumber > max[c]) {// checkt of randomnumber groter is dan max (max = 0)
					max[c] = randomnumber;// als randomnumber hoger is dan 0 wordt dat het nieuwe max voor die kolom
				}

				System.out.print(randomnumber + "\t");// random nummer wordt uitgeprint met een tab

				sumOfRow += randomnumber;// som van de rij wordt opgeteld met randomnumber

			}

			averageOfRow = sumOfRow / columns;// gemiddelde van 1 rij wordt hier bepaalt
			System.out.println(averageOfRow);// voegt een enter toe aan het einde van de kolom

			deviationData[r] = averageOfRow;
			sumOfAll += averageOfRow; // som van de gemiddelde van alle rijen wordt opgetelt
			sumOfRow = 0;// som van de rij wordt gereset

		}

		System.out.println();// enter naar nieuwe lijn
		System.out.print("MIN:");// print het MIN
		for (int c = 0; c < columns; c++) {// gelijk aan het aantal kollomen
			System.out.print("\t" + min[c]);// zet hij het minimum neer met een tab ervoor
		}
		int averageOfAll = sumOfAll / rows;// gemiddelde van alle rijen word gedefineerd

		System.out.print("\t" + averageOfAll);// print de gemiddelde van alle rijen

		System.out.println();// enter naar nieuwe lijn
		System.out.print("MAX:");// print het MAX
		for (int c = 0; c < columns; c++) {// gelijk aan aantal kollomen
			System.out.print("\t" + max[c]);// zet hij het maximum neer met een tab ervoor

		}
		System.out.print("\t" + String.format("%.3f", getDeviation(deviationData)));
	}

	private static double getDeviation(int[] data) {

		double deviation = 0.0;
		double dataCopy[] = new double[data.length];
		double sum = 0;
		double average = 0;

		for (int d = 0; d < data.length; d++) {
			sum += data[d];
		}

		average = sum / data.length;

		for (int d = 0; d < data.length; d++) {
			dataCopy[d] = data[d] - average;
		}

		sum = 0;

		for (int d = 0; d < data.length; d++) {
			dataCopy[d] = dataCopy[d] * dataCopy[d];
			sum += dataCopy[d];
		}
		average = sum / data.length;

		deviation = Math.sqrt(average);

		return deviation;
	}
}