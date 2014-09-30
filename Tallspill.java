import javax.swing.*;

public class Tallspill {

	//N�dvendige datafelt.

	public int nyttTall() {

		//Trekker og returnerer et slumptall mellom 0 og 200.

		return (int)(Math.random()*200);
	}

	public void visMelding(String melding) {

		//Viser parameterens innhold i en meldingsboks.

		/* Vi valgt � ikke ta denne koden i bruk, da vi syns brukergrenesnittet og programmet
		blir mer elegant om vi deklarerer de i hver metode (henholdsvis pga vindustittelen,
		JOptionPane.X_MESSAGE funksjonen osv. Dette resulterer i noen ekstra linjer kode,
		som er litt repetativ, men vi syns sluttproduktet ble best p� denne m�ten.*/

	}

	private void forLite( int tall ) {

		//Viser melding om at parameterens verdi er for lite tall og ber spilleren pr�ve igjen.

		JOptionPane.showMessageDialog(null, "Tallet " + tall + " er for lite! Pr�v igjen!", "Tallet er for lite", JOptionPane.ERROR_MESSAGE);
	}

	private void forStort( int tall ) {

		//Viser melding om at parameterens verdi er for	stort tall og ber spilleren pr�ve igjen.

		JOptionPane.showMessageDialog(null, "Tallet " + tall + " er for stort! Pr�v igjen!", "Tallet er for stort", JOptionPane.ERROR_MESSAGE);
	}

	public void avsluttRunde( int antall, int gjetning ) {

		//Viser melding om at det ble gjettet riktig og antall gjetninger som ble brukt.
		//Parametrene gir opplysninger om dette.

		JOptionPane.showMessageDialog(null, "Tallet " + gjetning + " er riktig!" +
									  "\nDu gjettet riktig p� " + antall + " fors�k.", "Gratulerer!", JOptionPane.INFORMATION_MESSAGE);

	}

	public void kj�rSpill(){
		/*Kj�rer en spillrunde ved � trekke et tall, nullstille tellevariabel,
		innhente gjentatte gjetninger fra bruker inntil det gjettes riktig.
		N�r det skjer, avsluttes runden med passe meldinger til spilleren.*/

		int nyttTall = nyttTall();
		int antall = 0;

		int tall = Integer.parseInt(JOptionPane.showInputDialog("Jeg tenker p� et tall mellom 0 og 200." +
									"\nPr�v � gjette p� tallet:" ));

		do{
			if(tall<nyttTall){
				forLite(tall);
				antall++;
				tall = Integer.parseInt(JOptionPane.showInputDialog("Jeg tenker p� et tall mellom 0 og 200." +
										"\nPr�v � gjette p� tallet:"));
			}

			if(tall>nyttTall){
				forStort(tall);
				antall++;
				tall = Integer.parseInt(JOptionPane.showInputDialog("Jeg tenker p� et tall mellom 0 og 200." +
										"\nPr�v � gjette p� tallet:"));
			}
		}while(tall!=nyttTall);


		avsluttRunde((antall+1), tall);

		String[] alternativ = { "Ja", "Nei"};
		int svar = JOptionPane.showOptionDialog( null, "Vil du pr�ve en runde til ?", "Ny runde?", JOptionPane.YES_NO_OPTION,
				   JOptionPane.QUESTION_MESSAGE, null, alternativ, alternativ[ 0 ] );

		if(svar == JOptionPane.YES_OPTION){
			kj�rSpill();
		}
		else{
			JOptionPane.showMessageDialog(null, "Takk for spillet!", "Takk", JOptionPane.INFORMATION_MESSAGE);
		}


	}
}