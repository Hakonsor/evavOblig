import javax.swing.*;

public class Tallspilltest {
	public static void main(String... args){
		//Driverklasse som oppretter et Tallspill-objekt og kjører spillet gjentatte runder inntil brukeren velger å avslutte.

		Tallspill s = new Tallspill();

		s.kjørSpill();
	}
}