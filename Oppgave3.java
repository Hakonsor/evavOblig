import javax.swing.*;
import java.io.*;

public class Oppgave3 {
	public static void main(String... args) {

		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0;
		int n = 0, o = 0, p = 0, q = 0, r = 0, s = 0, t = 0, u = 0, v = 0, w = 0, x = 0, y = 0, z = 0, æ = 0, ø = 0, å = 0;

		String inPut = JOptionPane.showInputDialog("Vennligst skriv inn en setning." +
							   "\nProgrammet vil skrive ut hvor mange ganger hver enkelt bokstav forekommer i setningen");

		inPut.toLowerCase();

		char[] bokstaver = new char[inPut.length()];

		bokstaver = inPut.toCharArray();

		for(int ii = 0; ii<bokstaver.length; ii++){

			switch (bokstaver[ii]) {

				case 'a': a++;
						  break;
				case 'b': b++;
						  break;
				case 'c': c++;
						  break;
				case 'd': d++;
						  break;
				case 'e': e++;
						  break;
				case 'f': f++;
						  break;
				case 'g': g++;
						  break;
				case 'h': h++;
						  break;
				case 'i': i++;
						  break;
				case 'j': j++;
						  break;
				case 'k': k++;
						  break;
				case 'l': l++;
						  break;
				case 'm': m++;
						  break;
				case 'n': n++;
						  break;
				case 'o': o++;
						  break;
				case 'p': p++;
						  break;
				case 'q': q++;
						  break;
				case 'r': r++;
						  break;
				case 's': s++;
						  break;
				case 't': t++;
						  break;
				case 'u': u++;
						  break;
				case 'v': v++;
						  break;
				case 'w': w++;
						  break;
				case 'x': x++;
						  break;
				case 'y': y++;
						  break;
				case 'z': z++;
						  break;
				case 'æ': æ++;
						  break;
				case 'ø': ø++;
						  break;
				case 'å': å++;
						  break;
			}
        }

        JTextArea bok = new JTextArea();

        bok.append("Antall forekomster av bokstaver i setningen:" +
        		   "\n" + inPut +
        		   "\nA: "+ a + "		B: " + b + "		C: " + c + "		D: " + d + "		E : "+ e +
        		   "\nF: "+ f + "		G: " + g + "		H: " + h + "		I: " + i + "		J : "+ j +
        		   "\nK: "+ k + "		L: " + l + "		M: " + m + "		N: " + n + "		O : "+ o +
        		   "\nP: "+ p + "		Q: " + q + "		R: " + r + "		S: " + s + "		T : "+ t +
        		   "\nU: "+ u + "		V: " + v + "		W: " + w + "		X: " + x + "		Y : "+ y +
        		   "\nZ: "+ z + "		Æ: " + æ + "		Ø: " + ø + "		Å: " + å);
        JOptionPane.showMessageDialog(null, bok);

	}
}