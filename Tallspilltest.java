import javax.swing.*;

public class Tallspilltest {
	public static void main(String... args){
		//Driverklasse som oppretter et Tallspill-objekt og kj�rer spillet gjentatte runder inntil brukeren velger � avslutte.

		Tallspill s = new Tallspill();

		s.kj�rSpill();
	}
}