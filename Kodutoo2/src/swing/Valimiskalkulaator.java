package swing;

import javax.swing.JOptionPane;
import kalkulaator.Määr;
import kalkulaator.Kalk;

public class Valimiskalkulaator {
	public static void main(String args[]) {
		new Valimiskalkulaator();
	}

	public Valimiskalkulaator() {
		boolean exit = false;
		while (!exit) {
			exit = true;

			String[] vastus = new String[2];
			JOptionPane
					.showMessageDialog(
							null,
							"2015. aasta 1.märtsil toimuvad Eesti Riigikogu valimised."
									+ "\nViimaste kuude jooksul on kõik suuremad erakonnad andnud"
									+ "\nlubadusi, nende võimule pääsemise puhul muuta tööjõu"
									+ "\nmaksustamissüsteeme. Antud valimiskalkulaator aitab"
									+ "\norienteeruda lubatud maksusüsteemi muudatustes."
									+ " \n\n"
									+ "Põhilised lubatud muudatused:"
									+ " \n\n"
									+ "IRL – 500 € tulumaksuvaba. Brutopalk kuni 846 € osalise \ntulumaksuvabastusega."
									+ "\n\n"
									+ "Keskerakond – Täiendav tulumaksumäär 33 % brutopalgast, mis \nületab 2000€."
									+ "\n\n"
									+ "Sotsiaaldemokraadid – Maksuvabatulu 1000 €. Tulumaksumäär \npraeguse 21 % asemel 26 %."
									+ "\n\n"
									+ "Reformierakond – Maksuvabatulu 300 €. Tulumaksumäär 20%."
									+ "\n\n"
									+ "Neivelti idee – Maksuvabatulu 400 €. Tulumaksumäär 24 %. Osa"
									+ "\nsotsiaalmaksu asendada tarbimismaksudega."
									+ "\n\n", "Valimiskalkulaator",
							JOptionPane.INFORMATION_MESSAGE);
			String[] valimised = Määr.valimised;
			int valimised_index = JOptionPane.showOptionDialog(null,
					"Millist maksusüsteemi eelistad sina?", "Maksusüsteemid",
					0, JOptionPane.QUESTION_MESSAGE, null, valimised, 0);
			vastus[0] = valimised[valimised_index];

			vastus[1] = JOptionPane.showInputDialog(null,
					"Mis on sinu Brutopalk?", "Palk",
					JOptionPane.QUESTION_MESSAGE);
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

			while (Integer.parseInt(vastus[1]) <= 0) {
				vastus[1] = JOptionPane
						.showInputDialog("Orjatööd Eesti Vabariigis ei tehta, palun sisestage korrektne brutopalk.");
			}

			int bp = Integer.parseInt(vastus[1]);

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
			double kov = Kalk.kov(bp);
			double kp = Kalk.kp(bp);
			double kpf = Kalk.kpf(bp);

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
			double maxnp = Integer.MIN_VALUE;
			String npmax = null;
			for (double arv : np) {
				if (arv > maxnp) {
					maxnp = arv;

					for (int j = 0; j < intnp.length; j++) {
						if (maxnp == np[j]) {
							npmax = valimised[j];
						}
					}
				}
			}

			int input = JOptionPane.showConfirmDialog(null, "Kas oled kindel?");
			if (input == 1 || input == 2) {
				exit = false;
			} else {
				JOptionPane
						.showMessageDialog(null,
								"Hoia oma piip ja prillid, sest siit tulevad tulemused");
			}

			if (exit) {
				JOptionPane
						.showMessageDialog(
								null,
								"Teie toetate "
										+ vastus[0]
										+ " ja teie brutopalk on "
										+ bp
										+ " €. "
										+ "\nValitud erakonna valimisplatform on lubanud Teile netopalka"
										+ "\nsuuruses "
										+ intnp[valimised_index]
										+ " €. See netopalk erineb "
										+ "Teie praegusest \nnetopalgast "
										+ (intnp[valimised_index] - intnp[5])
										+ " €. Kõige suurema netopalga saaksite valides "
										+ "\n"
										+ npmax
										+ " , seega saaksite netopalgana kätte "
										+ maxnp
										+ " €."
										+ "\n\nKui erakond viib läbi lubatud maksusüsteemi"
										+ "reformid, siis\ntänu Teie palgale panustatakse riigirahandusse"
										+ " "
										+ intriik[valimised_index]
										+ "€"
										+ "\nvõrra. See erineb 2014."
										+ " seaduste järgi panustatud summast  "
										+ (intriik[valimised_index] - intriik[5])
										+ " €"
										+ "\nKohaliku omavalitsuse tuludesse laekuks"
										+ " "
										+ intkov
										+ " €. \n\nTeie pensionifondi laekub brutopalgast"
										+ " "
										+ intkp
										+ "€ lisaks kahekordistab\nriik Teie panuse"
										+ ". seega laekub pensionifondi kokku "
										+ ""
										+ intkpf
										+ " €.\n\nTeie tasu pealt arvestatakse töötuskindlustusmaksu  "
										+ inttatkm[valimised_index]
										+ " €. \nTööandja lisab töötuskindlustusfondi "
										+ inttttkm[valimised_index]
										+ " €. \n\nErinevate erakondade suurim vahe on tulumaksu arvutamises. \nValides "
										+ vastus[0]
										+ " tasute"
										+ "	 tulumaksu "
										+ inttm[valimised_index]
										+ " €.\nKõik valikus olnud variandid peale Reformierakonna on lubanud \nastmelist tulumaksu võimule tulles kasutada.");
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								"Selles suures poliitilises demagoogia virrvarris ei tasu teha kiireid otsuseid. Alustame uuesti. :) ");
			}
		}
	}
}
