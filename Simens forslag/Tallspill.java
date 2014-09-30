import javax.swing.JOptionPane;
import java.util.Random;

public class Tallspill{

	// Objekter
	Random tilfeldig = new Random();

	// Datafelter
	private int riktigTall,antall,gjetning,�vreGrense,nedreGrense;

	// Metoder

	private int nyttTall() {
		�vreGrense = 199; // Eksklusiv 200 heltall
		nedreGrense = 1; // Eksklusiv 0 heltall


		// TODO: Fix random generator to be exclusive and still function
		return (int)(Math.random()*((�vreGrense)-(nedreGrense)) + nedreGrense);

	} // Slutt p� nyttTall-metoden

	/*

	visMelding-metoden brukes for � slippe � skerive ut den relativt
	lange metoden showMessageDialog fra JOptionPane, samtidig som
	dette �ker lesbarheten til koden, og gj�r at driverklassen ikke
	har behov for � importere noe som helst.

	Jeg har ikke noe behov for at metoden skal brukes i
	driverklassen, derfor har jeg satt metodetilgangen til 'private'

	*/

	private void visMelding(String melding) {

		JOptionPane.showMessageDialog(null,melding);

	} // Slutt p� visMelding-metoden

	private void forLite(int gjetning) {

		if (gjetning < riktigTall) {

			visMelding(gjetning + " er for lite!\nDu har gjettet " + antall + " ganger. \nPr�v igjen.");

		}

	} // Slutt p� forLite-metoden

	private void forStort(int gjetning) {
		if (gjetning > riktigTall) {

			visMelding(gjetning + " er for stort!\nDu har gjettet " + antall + " ganger. \nPr�v igjen.");

		}

	} // Slutt p� forStort-metoden

	public void avsluttRunde(int antall, int gjetning) {
		if (gjetning == riktigTall) {

			String riktig = gjetning + " er riktig!\nDu gjettet riktig p� " + antall
							+ " fors�k.";
			visMelding(riktig);
		}

	} // Slutt p� avsluttRunde-metoden

	public void kj�rSpill() {

		// Initialiserer tellervariabel
		antall = 0;

		// Initialiserer tilfeldig tall og beskriver det
		riktigTall = nyttTall();

		do {

			// Teller
			antall = antall + 1;

			// Motta informasjon fra bruker
			// "gjetningtest" brukes for � unders�ke om verdien er innenfor intervallet vi har valgt
			String gjetningtest = JOptionPane.showInputDialog("Jeg tenker p� et tall mellom 0 og 200. \nPr�v � gjette p� tallet: ");
			if (gjetningtest.length() > 0) {

				gjetning = Integer.parseInt(gjetningtest);

				if ((gjetning > (nedreGrense - 1)) && (gjetning < (�vreGrense + 1))) {

					// Hint til bruker
					forLite(gjetning);
					forStort(gjetning);

				}

				else {

				visMelding("Ugyldig verdi! \nDu har gjettet " + antall + " ganger s� langt.");

				}

			}

			else {

				visMelding("Ugyldig verdi! \nDu har gjettet " + antall + " ganger s� langt.");

			}

		} // Slutt p� do-while
		while (!(gjetning == riktigTall));

		avsluttRunde(antall, gjetning);
		nyttSpill();

	} // Slutt p� kj�rSpill-metoden

	public void nyttSpill() {

		String[] alternativ = { "Ja", "Nei"};
		int svar = JOptionPane.showOptionDialog( null,
		          "Vil du pr�ve en runde til ?",
		          "Gratulerer!", JOptionPane.YES_NO_OPTION,
		          JOptionPane.QUESTION_MESSAGE, null, alternativ,
		          alternativ[ 0 ] );

  		if (svar == JOptionPane.YES_OPTION) {

  			kj�rSpill();
  			nyttSpill();

		}

		else {

			visMelding("Takk for spillet!");

		}

	}

}