public class UnikeTallTest {

	//Må vurdere om vi skal hardkode dette rett inn i parantesen eller om
	//vi skal ha et public static int. Stud.ass. sier begge funker fett
	public static int antallTall = 64;

	public static void main(String... args) {

		UnikeTall uk = new UnikeTall(antallTall);

		uk.Resultat();

	}
}

