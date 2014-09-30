import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class UnikeTall {

	//Deklarasjon av array for lagring av tilfeldige heltall og andre nødvendige variabler og/eller konstanter.  >

	int[] heltallTabell;

	//Konstruktør som mottar arrayens lengde som parameter og oppretter arrayen.

	public UnikeTall(int lengde) {
		heltallTabell = new int[lengde];
		fylle();
	}


	/*Metode som skal undersøke om et gitt tall finnes i arrayen fra før.
	Tallet det letes etter skal mottas som parameter.
	Metoden skal returnere true hvis tallet finnes i arrayen.
	Hvis ikke skal metoden returnere false.*/

	public boolean tallSjekker(int tall) {


		for(int k=0; k<heltallTabell.length; k++){

			if(tall==heltallTabell[k]) {
				return true;
			}
		}

		return false;
	}


	/*Metode som skal fylle arrayen med tilfeldige tall mellom 100 og 1000,
	begge grenser inkludert. Metoden skal gjøre dette på en måte
	som sikrer at alle tallene er forskjellige. Metoden skal ikke ha
	parametre og heller ikke returnere noen verdi.*/

	public void fylle(){
		Random generator = new Random();
		for(int i=0;i<heltallTabell.length;i++){
			int sjekker = 100 + generator.nextInt(900);
			if(tallSjekker(sjekker)) {
				i--;
			}
			else {
				heltallTabell[i] = sjekker;
			}
		}
	}


	//Metode som finner og returnerer det minste tallet i arrayen. >

	public int minsteTall() {
		int minst = heltallTabell[0];

		for(int i = 0; i<heltallTabell.length;i++) {

			if(heltallTabell[i] < minst) {
				minst = heltallTabell[i];
			}
		}

		return minst;
	}


	//Metode som finner og returnerer det største tallet i arrayen.

	public int storsteTall() {
		int storst = heltallTabell[0];

		for(int i = 0; i<heltallTabell.length;i++){

			if(heltallTabell[i] > storst) {
				storst = heltallTabell[i];
			}
		}

		return storst;
	}


	//Metode som beregner og returnerer den gjennomstnittlige verdien (double-verdi) av tallene i arrayen.

	public double gjennomSnitt(){

		double sum = 0;

		for(int i=0; i<heltallTabell.length;i++){
			sum += heltallTabell[i];
		}

		return (double)(sum/heltallTabell.length);
	}

	/*Metode som returnerer den heltallsverdien som ligger nærmest
	gjennomsnittverdien. Hint! Her kan du bruke Math.abs(...) som
	returnerer absoluttverdien til uttrykket mellom parentesene.*/

	public int nærHeltall() {

		int temp = 0;
		int helTall = 1000;
		int gs = 0;

		for(int i = 0; i<heltallTabell.length; i++){

			if(gjennomSnitt()==heltallTabell[i]) {
				return heltallTabell[i];
			}

			temp = Math.abs((int)gjennomSnitt()-heltallTabell[i]);

			if(temp < helTall){
				helTall = temp;
				gs = heltallTabell[i];

			}
		}

		return gs;

	}


	/* Metode som viser tallene i arrayen i et tekstområde, som mottas
	som parameter. I tillegg skal det, i tekstområdet, skrives ut
	opplysninger om hvilket tall som er minst, hvilket som er størst,
	hva som er gjennomsnittsverdien, og hvilken heltallsverdi som
	er nærmest gjennomnittet, jfr bildet over. Gjennomsnittverdien
	skal skrives ut med en desimal. Legg inn mellomrom mellom tallene
	og skriv ut et passende antall tall per linje. */

	public void Resultat(){
		JTextArea resultat = new JTextArea();
		DecimalFormat d = new DecimalFormat("0.0");
		String line = "";
		int linjeTeller = 0;

		for(int i = 0; i<heltallTabell.length;i++){
			line += heltallTabell[i] + "  ";
			linjeTeller++;

			if(linjeTeller%8==0 ){
				line += "\n";
			}
		}
		resultat.append(line +
						"\nMinste tall er: " + minsteTall() +
						"\nStørste tall er: " + storsteTall() +
						"\nGjennomsnittsveriden er: " + d.format(gjennomSnitt()) +
						"\nTallet nærmest gjennomsnittet er: " + nærHeltall());

		JOptionPane.showMessageDialog(null, resultat, "Resultat", JOptionPane.INFORMATION_MESSAGE);


	}//End of Resultat

}//End of class