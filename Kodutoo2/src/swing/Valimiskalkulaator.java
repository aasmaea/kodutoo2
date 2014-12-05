package swing;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import swing.Lisa;
import kalkulaator.M��r;

/**
 * @author Aare Aasm�e IA18. Antud classi on kirjutanud autor ise, kuid
 *         kasutanud erinevate JOptionPane Tutorialite abi.
 *         Nt. https://www.youtube.com/watch?v=UQgh1vRh68k
 */

public class Valimiskalkulaator {
	public static void main(String args[]) {

		new Valimiskalkulaator(); // kutsun esile programmi Valimiskalkulaator
	}

	public Valimiskalkulaator() {

		

		// while loop selleks, et kui programm pole l�petanud t��, suunataks
		// algusesse tagasi
		boolean exit = false;
		
		while (!exit) {
			exit = true;
			// M��ran vastuste massiivi
			String[] vastus = new String[2];
			// Esimene Informatiivne dialoog kasutades JOption.Pane
			JOptionPane
					.showMessageDialog(
							null,
							"2015. aasta 1.m�rtsil toimuvad Eesti Riigikogu valimised."
									+ "\nViimaste kuude jooksul on k�ik suuremad erakonnad andnud"
									+ "\nlubadusi, nende v�imule p��semise puhul muuta t��j�u"
									+ "\nmaksustamiss�steeme. Antud valimiskalkulaator aitab"
									+ "\norienteeruda lubatud maksus�steemi muudatustes."
									+ " \n\n"
									+ "P�hilised lubatud muudatused:"
									+ " \n\n"
									+ "IRL � 500 � tulumaksuvaba. Brutopalk kuni 846 � osalise \ntulumaksuvabastusega."
									+ "\n\n"
									+ "Keskerakond � T�iendav tulumaksum��r 33 % brutopalgast, mis \n�letab 2000�."
									+ "\n\n"
									+ "Sotsiaaldemokraadid � Maksuvabatulu 1000 �. Tulumaksum��r \npraeguse 21 % asemel 26 %."
									+ "\n\n"
									+ "Reformierakond � Maksuvabatulu 300 �. Tulumaksum��r 20%."
									+ "\n\n"
									+ "Neivelti idee � Maksuvabatulu 400 �. Tulumaksum��r 24 %. Osa"
									+ "\nsotsiaalmaksu asendada tarbimismaksudega."
									+ "\n\n", "Valimiskalkulaator",
							JOptionPane.OK_CANCEL_OPTION);
			// Esimese k�simuse jaoks kutsun esile valimisplatvormide
			// valikuvariandid algandmedest
			String[] valimised = M��r.valimised;
			// Esimene k�simus kasutades JOptionPane
			int valimised_index = JOptionPane.showOptionDialog(null,
					"Millist maksus�steemi eelistad sina?", "Maksus�steemid",
					0, JOptionPane.QUESTION_MESSAGE, null, valimised,0);
			int valimised_index2 = JOptionPane.showOptionDialog(null,
					"Millega soovite v�rrelda oma eelistusi?",
					"Maksus�steemid", 0, JOptionPane.QUESTION_MESSAGE, null,
					valimised, 0);
			// Testin, et v�rreldaks ikka kahte erinevat maksus�steemi
			while (valimised_index2 == valimised_index) {
				valimised_index2 = JOptionPane
						.showOptionDialog(
								null,
								"Valisite sama maksus�steemi.\nMillega soovite v�rrelda oma eelistusi?",
								"Maksus�steemid", 0,
								JOptionPane.WARNING_MESSAGE, null, valimised, 0);
			}
			// vastus[0] annab valimisplatvormi indexi [valimised_index], ehk
			// siis esimese vajaliku sisendi v�ljundi loomiseks
			vastus[0] = valimised[valimised_index];
			// vastus [1] annab brutopalga, ehk siis vajaliku teise sisendi
			vastus[1] = JOptionPane.showInputDialog(null,
					"Mis on sinu Brutopalk t�isarvuna?", "Palk",
					JOptionPane.QUESTION_MESSAGE);
			// Lisas kontrollin kas tegemist on 1) arvulise sisendiga 2) kas on
			// suurem kui minpalk 355 �. L�bi selle saab kolmanda sisendi-
			// brutopalga
			String v = Lisa.kontroll(vastus[1]);
			int bp = Lisa.kontroll2(v);
			// Kutsun v�lja Lisas int-ideks teisendatud palgaelementide
			// massiivid
			int[] intnp = (int[]) Lisa.obj(bp)[0];
			int[] inttm = (int[]) Lisa.obj(bp)[1];
			int[] intsm = (int[]) Lisa.obj(bp)[2];
			int[] intriik = (int[]) Lisa.obj(bp)[3];
			int[] inttttkm = (int[]) Lisa.obj(bp)[4];
			int[] inttatkm = (int[]) Lisa.obj(bp)[5];
			int[] intpf = (int[]) Lisa.obj(bp)[6];
			int intkov = (int) Lisa.obj(bp)[7];
			int intkp = (int) Lisa.obj(bp)[8];
			int intkpf = (int) Lisa.obj(bp)[9];
			// Kutsun v�lja, arvutatud maksimaaalse netopalga ja selle
			// valimisplatformi
			int maxnp = (int) Lisa.obj(bp)[10];
			String npmax = (String) Lisa.obj(bp)[11];
			// k�sin kinnitavat, kui kasutaja vajutab cancel v�i no, siis l�heb
			// suunatakse l�ppu julgustava lause juurde, mis omakorda viib
			// algusesse tagasi.
			int input = JOptionPane.showConfirmDialog(null, "Kas oled kindel?");
			if (input == 1 || input == 2) {
				exit = false;

			} else {
				// Valmistan sisestaja tulemusteks
				JOptionPane
						.showMessageDialog(null,
								"Hoia oma piip ja prillid, sest siit tulevad tulemused");
			}
			// esmane while-loop saab l�bi, kui kasutaja niikaugele on j�udnud,
			// ning kuvan vastused vastavalt kasutaja sisestusele
			if (exit) {
				Tulemused.tabel(bp, valimised_index, valimised_index2, intsm,
						inttatkm, inttttkm, intnp, intriik, inttm, intkp,
						intkpf, intkov, intpf);

				Tulemused.tulemus(vastus, bp, valimised_index,
						valimised_index2, intsm, inttatkm, inttttkm, intnp,
						intriik, inttm, intkp, intkpf, intkov, npmax, maxnp);
				// K�sin kasutajalt, kas ta soovib programmi taasalustada
				int input2 = JOptionPane.showConfirmDialog(null,
						"Kas soovid taasalustada?");
				{
					if (input2 == 0) {
						exit = false;
					}
				}

			} else {
				// Kui vajutab mingil hetkel no v�i cancel, siis annan
				// julgustavad s�nad, et ei kasutaja ei heidaks meelt
				JOptionPane
						.showMessageDialog(
								null,
								"Selles suures poliitilises demagoogia virrvarris ei tasu teha kiireid otsuseid. Alustame uuesti. :) ");

			}
		}
	}
}
