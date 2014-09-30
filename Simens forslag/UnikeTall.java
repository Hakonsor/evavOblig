import java.util.*;

public class UnikeTall {

	// Objekter
	Random tilfeldig = new Random();
	List<Integer> likeTall = new ArrayList<Integer>();

	// Datafelt
	int[] tallArray;
	int arrayTall,antallLike;
	private static final int NEDRE_GRENSE = 100, ØVRE_GRENSE = 1000;


	// Konstruktører
	public UnikeTall(int lengde) {
		tallArray = new int[lengde];
		arrayFyller();

	} // Slutt på konstruktør med verdi

	public UnikeTall() {
		tallArray = new int[50];
		arrayFyller();

	} // Slutt på konstruktør uten parametre


	/*
	Metode som undersøker om et tall allerede finnes i arrayet

	Metoden mottar et heltall som så sjekkes for hver indeks av hele tallArray,
	ved hjelp av en if-test. I tilfellet hvor if-testen returnerer 'true' vil
	metoden returnere 'true'. I tilfellet hvor if-testen returnerer 'false' vil


	*/
	private boolean arraySjekker(int tall) {

		for (int i = 0; i < tallArray.length; i++) {

			if (tall == tallArray[i]) {
				likeTall.add(tallArray[i]);
				return true;

			}

		}

		return false;

	}

	// Metode som fyller arrayen med tilfeldige tall mellom to grenser
	private void arrayFyller() {

		for (int i = 0; i < tallArray.length; i++) {

			do {

				arrayTall = (NEDRE_GRENSE) + tilfeldig.nextInt((ØVRE_GRENSE)-(NEDRE_GRENSE-1));

			}

			while (arraySjekker(arrayTall) == true);

			tallArray[i] = arrayTall;

		}

	}

	private int arrayMinst() {

		for (int i = 1; i < tallArray.length; i++) {

			int x = tallArray[i];
			int j = i;

			while ((j > 0) && (tallArray[j-1] > x)) {

				tallArray[j] = tallArray[j-1];
				j = j-1;

			}

			tallArray[j] = x;
		}

		return tallArray[0];

	}

		private int arrayStørst() {

			for (int i = 1; i < tallArray.length; i++) {

				int x = tallArray[i];
				int j = i;

				while ((j > 0) && (tallArray[j-1] > x)) {

					tallArray[j] = tallArray[j-1];
					j = j-1;

				}

				tallArray[j] = x;
			}

			return tallArray[tallArray.length-1];

	}


	public void arrayTest() {

		double prosent = (double) likeTall.size() / tallArray.length * 100;

		for (int i = 0; i < tallArray.length; i++) {

			System.out.println(tallArray[i] + "\n");

		}

		System.out.println("Informasjon fra liste: \n");

		System.out.println("Antall 'like' tallpar: \t" + likeTall.size() + "\n");

		System.out.println("'Like' tall: \n");

		for (int j = 0; j < likeTall.size(); j++) {

			System.out.println((j+1) + "\t" + likeTall.get(j) + "\n");

		}

		System.out.println("Minste element: \t" + arrayMinst() + "\n");
		System.out.println("Største element: \t" + arrayStørst() + "\n");
		System.out.println("Prosent omvalg: \t" + prosent);
	}


}