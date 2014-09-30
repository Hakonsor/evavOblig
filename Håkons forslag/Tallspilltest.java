import javax.swing.*;

public class Tallspilltest
{
	public static void main(String[] args)
	{
		Tallspill spill = new Tallspill();
		int svar = JOptionPane.NO_OPTION;
		do
		{
			spill.kjørSpill();
			String[] alternativ = { "Ja", "Nei"};
			svar = JOptionPane.showOptionDialog( null,
			          "Vil du prøve en runde til ?",
			          "Gratulerer!", JOptionPane.YES_NO_OPTION,
			          JOptionPane.QUESTION_MESSAGE, null, alternativ,
          				alternativ[ 0 ] );
		}while(svar == JOptionPane.YES_OPTION);
		spill.visMelding( "Takk for spillet!"); // viser ikke parameter som sudokoden sier at visMelding skal gjøre
	}

}