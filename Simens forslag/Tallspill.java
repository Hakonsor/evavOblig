import javax.swing.JOptionPane;
import java.util.Random;

public class Tallspill{

	// Objekter
	Random tilfeldig = new Random();

	// Datafelter
	private int riktigTall,antall,gjetning,øvreGrense,nedreGrense;

	// Metoder

	private int nyttTall() {
		øvreGrense = 199; // Eksklusiv 200 heltall
		nedreGrense = 1; // Eksklusiv 0 heltall


		// TODO: Fix random generator to be exclusive and still function
		return (int)(Math.random()*((øvreGrense)-(nedreGrense)) + nedreGrense);

	} // Slutt på nyttTall-metoden

	/*

	visMelding-metoden brukes for å slippe å skerive ut den relativt
	lange metoden showMessageDialog fra JOptionPane, samtidig som
	dette øker lesbarheten til koden, og gjør at driverklassen ikke
	har behov for å importere noe som helst.

	Jeg har ikke noe behov for at metoden skal brukes i
	driverklassen, derfor har jeg satt metodetilgangen til 'private'

	*/

	private void visMelding(String melding) {

		JOptionPane.showMessageDialog(null,melding);

	} // Slutt på visMelding-metoden

	private void forLite(int gjetning) {

		if (gjetning < riktigTall) {

			visMelding(gjetning + " er for lite!\nDu har gjettet " + antall + " ganger. \nPrøv igjen.");

		}

	} // Slutt på forLite-metoden

	private void forStort(int gjetning) {
		if (gjetning > riktigTall) {

			visMelding(gjetning + " er for stort!\nDu har gjettet " + antall + " ganger. \nPrøv igjen.");

		}

	} // Slutt på forStort-metoden

	public void avsluttRunde(int antall, int gjetning) {
		if (gjetning == riktigTall) {

			String riktig = gjetning + " er riktig!\nDu gjettet riktig på " + antall
							+ " forsøk.";
			visMelding(riktig);
		}

	} // Slutt på avsluttRunde-metoden

	public void kjørSpill() {

		// Initialiserer tellervariabel
		antall = 0;

		// Initialiserer tilfeldig tall og beskriver det
		riktigTall = nyttTall();

		do {

			// Teller
			antall = antall + 1;

			// Motta informasjon fra bruker
			// "gjetningtest" brukes for å undersøke om verdien er innenfor intervallet vi har valgt
			String gjetningtest = JOptionPane.showInputDialog("Jeg tenker på et tall mellom 0 og 200. \nPrøv å gjette på tallet: ");
			if (gjetningtest.length() > 0) {

				gjetning = Integer.parseInt(gjetningtest);

				if ((gjetning > (nedreGrense - 1)) && (gjetning < (øvreGrense + 1))) {

					// Hint til bruker
					forLite(gjetning);
					forStort(gjetning);

				}

				else {

				visMelding("Ugyldig verdi! \nDu har gjettet " + antall + " ganger så langt.");

				}

			}

			else {

				visMelding("Ugyldig verdi! \nDu har gjettet " + antall + " ganger så langt.");

			}

		} // Slutt på do-while
		while (!(gjetning == riktigTall));

		avsluttRunde(antall, gjetning);
		nyttSpill();

	} // Slutt på kjørSpill-metoden

	public void nyttSpill() {

		String[] alternativ = { "Ja", "Nei"};
		int svar = JOptionPane.showOptionDialog( null,
		          "Vil du prøve en runde til ?",
		          "Gratulerer!", JOptionPane.YES_NO_OPTION,
		          JOptionPane.QUESTION_MESSAGE, null, alternativ,
		          alternativ[ 0 ] );

  		if (svar == JOptionPane.YES_OPTION) {

  			kjørSpill();
  			nyttSpill();

		}

		else {

			visMelding("Takk for spillet!");

		}

	}

}