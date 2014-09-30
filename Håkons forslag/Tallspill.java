import javax.swing.*;

public class Tallspill
{
  private int tall;
  private boolean won = true;
  public int nyttTall()
  {
	  return (int) (Math.random() * 100);
  }
  public void visMelding(String melding)
  {
   JOptionPane.showMessageDialog(null, melding);
  }
  private void forLite( int tall )
  {
	  visMelding(tall +" er for lite! Prøv igjen!");
  }
 private void forStort( int tall )
  {
     visMelding(tall +" er for stort! Prøv igjen!");
  }
  public void avsluttRunde( int antall, int gjetning )
  {
	 JOptionPane.showMessageDialog(null, gjetning + " er riktig!\nDu gjettet riktig på "
	 + antall+ " forsøk."  );
  }
  public void kjørSpill()
  {
    tall = nyttTall();
    won = false;
    int gjetning = 0;
	for(int antallGjetting = 0;!won;++antallGjetting)
	{
		gjetning = Integer.parseInt(JOptionPane.showInputDialog("Jeg tenker på et tall mellom 0 og 200.\nPrøv å gjette på tallet:"));
		if(gjetning < tall)
			forLite(gjetning);

		else if(gjetning > tall)
			forStort(gjetning);

		else if(gjetning == tall)
			{
			avsluttRunde(antallGjetting,tall );
			won = true;
			}
	}
  }
}
