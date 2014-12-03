package swing;

import javax.swing.JOptionPane;
import kalkulaator.M��r;
import kalkulaator.Kalk;

/**
 * @author Aare Aasm�e IA18. Antud classi on kirjutanud autor ise, kuid
 *         kasutanud erinevate JOptionPane Tutorialite abi.
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
							JOptionPane.INFORMATION_MESSAGE);
			// Esimese k�simuse jaoks kutsun esile valimisplatvormide
			// valikuvariandid algandmedest
			String[] valimised = M��r.valimised;
			// Esimene k�simus kasutades JOptionPane
			int valimised_index = JOptionPane.showOptionDialog(null,
					"Millist maksus�steemi eelistad sina?", "Maksus�steemid",
					0, JOptionPane.QUESTION_MESSAGE, null, valimised, 0);
			// vastus[0] annab valimisplatvormi indexi [valimised_index], ehk
			// siis esimese vajaliku sisendi v�ljundi loomiseks
			vastus[0] = valimised[valimised_index];
			// vastus [1] annab brutopalga, ehk siis vajaliku teise sisendi
			vastus[1] = JOptionPane.showInputDialog(null,
					"Mis on sinu Brutopalk t�isarvuna?", "Palk",
					JOptionPane.QUESTION_MESSAGE);
			// Kuna ei leindud kahjuks JoptionPane v�imalust lasta sisestada
			// kohe int, siis lasen sisestada Stringi, mille muudan hiljem
			// int-iks. Esmalt testin, kas sisestus on korrektne, seda on tuleb
			// teha try-catchiga ning, et ei saaks mitu korda valesti sisestada
			// tekitan do-while loopi.
			boolean bError = true;
			do {
				try {
					Integer.parseInt(vastus[1]);
					bError = false;
				} catch (NumberFormatException e) {
					vastus[1] = JOptionPane
							.showInputDialog("Eesti Vabariigis ei maksta palka "
									+ vastus[1]
									+ "-des, palun sisestage korrektne brutopalk");
					continue;
				}
			} while (bError);
			// testin ka, kas sisestus on suurem kui null
			while (Integer.parseInt(vastus[1]) <= 0) {
				vastus[1] = JOptionPane
						.showInputDialog("Orjat��d Eesti Vabariigis ei tehta, palun sisestage korrektne brutopalk.");
			}
			// l�puks n�ustun, et sisestuse n�ol v�ib t�epoolest tegu olla
			// brutopalgaga
			int bp = Integer.parseInt(vastus[1]);
			// kutsun esile v��rtuste massiivid kalk-ist
			double[] np = { Kalk.np(0, bp), Kalk.np(1, bp), Kalk.np(2, bp),
					Kalk.np(3, bp), Kalk.np(4, bp), Kalk.np(5, bp),
					Kalk.np(6, bp) };
			double[] tm = { Kalk.tm(0, bp), Kalk.tm(1, bp), Kalk.tm(2, bp),
					Kalk.tm(3, bp), Kalk.tm(4, bp), Kalk.tm(5, bp),
					Kalk.tm(6, bp) };
			double[] riik = { Kalk.riik(0, bp), Kalk.riik(1, bp),
					Kalk.riik(2, bp), Kalk.riik(3, bp), Kalk.riik(4, bp),
					Kalk.riik(5, bp), Kalk.riik(6, bp) };
			double[] tttkm = { Kalk.tttkm(0, bp), Kalk.tttkm(1, bp),
					Kalk.tttkm(2, bp), Kalk.tttkm(3, bp), Kalk.tttkm(4, bp),
					Kalk.tttkm(5, bp), Kalk.tttkm(6, bp) };
			double[] tatkm = { Kalk.tatkm(0, bp), Kalk.tatkm(1, bp),
					Kalk.tatkm(2, bp), Kalk.tatkm(3, bp), Kalk.tatkm(4, bp),
					Kalk.tatkm(5, bp), Kalk.tatkm(6, bp) };
			// osad muutujad on erinevate maksus�steemidega j��nud samaks (v�i
			// t�helepanuta?)
			double kov = Kalk.kov(bp);
			double kp = Kalk.kp(bp);
			double kpf = Kalk.kpf(bp);

			// et muuta arve informatiivsemaks viin k�ik andmed �le double to
			// int.
			final int[] intnp = new int[valimised.length];
			final int[] intriik = new int[valimised.length];
			final int[] inttm = new int[valimised.length];
			final int[] inttttkm = new int[valimised.length];
			final int[] inttatkm = new int[valimised.length];

			final int intkov = (int) kov;
			final int intkp = (int) kp;
			final int intkpf = (int) kpf;
			for (int i = 0; i < valimised.length; i++) {
				intnp[i] = (int) np[i];
				intriik[i] = (int) riik[i];
				inttm[i] = (int) tm[i];
				inttttkm[i] = (int) tttkm[i];
				inttatkm[i] = (int) tatkm[i];
			}
			// andmeanal��si jaoks leian maksimaalse netopalga
			double maxnp = Integer.MIN_VALUE;
			String npmax = null;
			for (double arv : np) {
				if (arv > maxnp) {
					maxnp = arv;
					// leian ka, kes antud palgataseme juures pakub k�ige
					// k�rgemat netopalka
					for (int j = 0; j < intnp.length; j++) {
						if (maxnp == np[j]) {
							npmax = valimised[j];
						}
					}
				}
			}
			// k�sin kinnitavat, kui kasutaja vajutab cancel v�i no, siis l�heb
			// suunatakse l�ppu julgustava lause juurde, mis omakorda viib
			// algusesse tagasi.
			int input = JOptionPane.showConfirmDialog(null, "Kas oled kindel?");
			if (input == 1 || input == 2) {
				exit = false;
			} else {
				// lisan humoorika vahepala
				JOptionPane
						.showMessageDialog(null,
								"Hoia oma piip ja prillid, sest siit tulevad tulemused");
			}
			// esmane while-loop saab l�bi, kui kasutaja niikaugele on j�udnud,
			// ning kuvan vastused vastavalt kasutaja sisestusele
			if (exit) {
				JOptionPane
						.showMessageDialog(
								null,
								"Teie toetate "
										+ vastus[0]
										+ " ja teie brutopalk on "
										+ bp
										+ " �. "
										+ "\nValitud erakonna valimisplatform on lubanud Teile netopalka"
										+ "\nsuuruses "
										+ intnp[valimised_index]
										+ " �. See netopalk erineb "
										+ "Teie praegusest \nnetopalgast "
										+ (intnp[valimised_index] - intnp[5])
										+ " �. K�ige suurema netopalga saaksite valides "
										+ "\n"
										+ npmax
										+ " , seega saaksite netopalgana k�tte "
										+ maxnp
										+ " �."
										+ "\n\nKui erakond viib l�bi lubatud maksus�steemi"
										+ "reformid, siis\nt�nu Teie palgale panustatakse riigirahandusse"
										+ " "
										+ intriik[valimised_index]
										+ "�"
										+ "\nv�rra. See erineb 2014."
										+ " seaduste j�rgi panustatud summast  "
										+ (intriik[valimised_index] - intriik[5])
										+ " �"
										+ "\nKohaliku omavalitsuse tuludesse laekuks"
										+ " "
										+ intkov
										+ " �. \n\nTeie pensionifondi laekub brutopalgast"
										+ " "
										+ intkp
										+ "� lisaks kahekordistab\nriik Teie panuse"
										+ ". seega laekub pensionifondi kokku "
										+ ""
										+ intkpf
										+ " �.\n\nTeie tasu pealt arvestatakse t��tuskindlustusmaksu  "
										+ inttatkm[valimised_index]
										+ " �. \nT��andja lisab t��tuskindlustusfondi "
										+ inttttkm[valimised_index]
										+ " �. \n\nErinevate erakondade suurim vahe on tulumaksu arvutamises. \nValides "
										+ vastus[0]
										+ " tasute"
										+ "	 tulumaksu "
										+ inttm[valimised_index]
										+ " �.\nK�ik valikus olnud variandid peale Reformierakonna on lubanud \nastmelist tulumaksu v�imule tulles kasutada."
										+ "\n\n AARE AASM�E IA18");
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
