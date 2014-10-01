import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class UnikeTall {

	// Deklarering av konstanter.
	public static final int ØVREGRENSE = 1000;
	public static final int NEDREGRENSE = 100;

	// Deklarering av arrayer for lagring av tilfeldige heltall.
	int[] heltallTabell;

	// Opprettelse av konstruktører
	public UnikeTall(int lengde) {
		heltallTabell = new int[lengde];
		arrayFyller();
		resultat();
	}
	
	public UnikeTall() {
		heltallTabell = new int[64]
		arrayFyller();
		resultat();
	}

	/*
	
	Metode som skal undersøke om et gitt tall finnes i arrayen fra før. Tallet det
	letes etter skal mottas som parameter. Metoden skal returnere true hvis tallet 
	finnes i arrayen. Hvis ikke skal metoden returnere false.
	
	*/

	private boolean tallSjekker(int tall) {


		for(int k=0; k<heltallTabell.length; k++){

			if(tall==heltallTabell[k]) {
				return true;
			}
		}

		return false;
	}


	/*
	
	Metode som fyller arrayen med tilfeldige tall fra og med 100 til og med 1000. 
	
	Utnytter tallSjekker() for å forsikre at alle verdiene i tabellen er unike.
	
	*/

	private void arrayFyller(){

		Random generator = new Random();

		for(int i=0;i<heltallTabell.length;i++){
			/*
			
			Det første NEDREGRENSE-leddet fører til at bare tall fra og med 
			NEDREGRENSE vil bli brukt. 
			
			generator.nextInt()-leddet beskriver alle tallene som skal kunne legges til 
			NEDREGRENSE for å gi intervallet. Altså vil dette leddet generere et tilfeldig
			heltall fra og med 0 til og med ((ØVREGRENSE-NEDREGRENSE)+1). 
			
			Når nextInt()-metoden blir matet med en grense, så er den grensen eksklusiv. Da
			oppgaven spesifiserer at ØVREGRENSE skal være inkludert, blir det nødvendig å 
			legge til 1 (derav +1).
			
			*/
			
			int sjekker = NEDREGRENSE + generator.nextInt((ØVREGRENSE-NEDREGRENSE)+1);
			
			/*
			
			Denne if-testen undersøker om sjekkervariabelen har en verdi som allerede
			eksisterer i arrayen. Hvis testen returnerer true vil tellervariabelen gå
			tilbake til forrige verdi og prøve på nytt til testen returnerer false, i 
			hvilket tilfelle så lagres sjekkervariabelens verdi i arrayen ved indeks gitt
			av tellervariabelen.
			
			*/
			
			if(tallSjekker(sjekker)) {
				i--;
			}
			else {
				heltallTabell[i] = sjekker;
			}
		} // Slutt på for-løkke
	} // Slutt på arrayFyller()


	/* 
	
	Metode som finner og returnerer det minste tallet i arrayen. Starter ved å sette
	en variabel lik det første arrayelementet, for så å kjøre en itererende løkke
	som sammenlikner sjekkervariabelen med elementet som stemmer overens med løkkens
	indeks. 
	
	Dersom elementet er mindre enn sjekkervariabelen, vil sjekkervariabelen bli gitt
	verdien til elementet før løkken kjøres på nytt, og sammenlikner den nye minste
	verdien så langt. Til slutt returneres den minste verdien.
	
	*/

	private int minsteTall() {
		int minst = heltallTabell[0];

		for(int i = 0; i<heltallTabell.length;i++) {

			if(heltallTabell[i] < minst) {
				minst = heltallTabell[i];
			}
		}

		return minst;
	}


	/*
	
	Metode som finner og returnerer det største tallet i arrayen. Bruker en enkel
	test på samme måte som minsteTall() gjør.

	*/
	
	private int størsteTall() {
		int størst = heltallTabell[0];

		for(int i = 0; i<heltallTabell.length;i++){

			if(heltallTabell[i] > storst) {
				storst = heltallTabell[i];
			}
		}

		return størst;
	}


	/*
	
	Metode som beregner og returnerer den gjennomstnittlige verdien av tallene i 
	arrayen som double. Bruker en for-løkke for å summere alle elementene.
	
	*/

	private double gjennomSnitt() {

		double sum = 0;

		for(int i=0; i<heltallTabell.length;i++){
			sum += heltallTabell[i];
		}

		return (double)(sum/heltallTabell.length);
	}

	/*
	
	Metode som finner heltallselementet i arrayen som kommer aller nærmest snittet
	av arrayen. Undersøker også om snittet faktisk er et heltall som matcher ett av
	tallene i arrayen ved bruk av en test.
	
	Math.abs() forsikrer at man ikke får et negativt tall som resultat av
	differansen mellom gjennomSnitt() og heltallTabell[i].
	
	*/

	private int nærHeltall() {

		double temp
		double helTall;
		temp = 0;
		helTall = ØVREGRENSE+1;
		int gs = 0;

		for(int i = 0; i<heltallTabell.length; i++){

			if(gjennomSnitt()==heltallTabell[i]) {
				return heltallTabell[i];
			}

			temp = Math.abs(gjennomSnitt()-(double)heltallTabell[i]);

			if(temp < helTall){
				helTall = temp;
				gs = heltallTabell[i];

			}
		}

		return gs;

	}


	/* 
	
	Metode som viser tallene i arrayen i et tekstområde, som mottas som parameter. 
	I tillegg skal det, i tekstområdet, skrives ut opplysninger om hvilket tall som
	er minst, hvilket som er størst,hva som er gjennomsnittsverdien, og hvilken 
	heltallsverdi som er nærmest gjennomnittet, jfr bildet over. Gjennomsnittverdien
	skal skrives ut med en desimal. Legg inn mellomrom mellom tallene
	og skriv ut et passende antall tall per linje. 
	
	TODO: Finn en måte å implementere parameterdelen av kravet på
	
	*/

	private void resultat(){
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


	} // Slutt på resultat()

} // Slutt på klasse
