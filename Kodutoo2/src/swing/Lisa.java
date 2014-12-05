package swing;

import javax.swing.JOptionPane;

import kalkulaator.Kalk;
import kalkulaator.M‰‰r;

/**
 * @author Aare Aasm‰e IA18. Antud classi on kirjutanud autor ise.
 */
public class Lisa {

	// koostan kalkulaatoris arvutatud v‰‰rtustest massiivid ning tagastan need
	// Valimiskalkulaatorisse
	public static Object[] obj(int bp) {

		final double[] np = { Kalk.np(0, bp)+0.5, Kalk.np(1, bp)+0.5, Kalk.np(2, bp)+0.5,
				Kalk.np(3, bp)+0.5, Kalk.np(4, bp)+0.5, Kalk.np(5, bp)+0.5, Kalk.np(6, bp)+0.5 };
		final double[] tm = { Kalk.tm(0, bp)+0.5, Kalk.tm(1, bp)+0.5, Kalk.tm(2, bp)+0.5,
				Kalk.tm(3, bp)+0.5, Kalk.tm(4, bp)+0.5, Kalk.tm(5, bp)+0.5, Kalk.tm(6, bp)+0.5 };
		final double[] sm = { Kalk.sm(0, bp)+0.5, Kalk.sm(1, bp)+0.5, Kalk.sm(2, bp)+0.5,
				Kalk.sm(3, bp)+0.5, Kalk.sm(4, bp)+0.5, Kalk.sm(5, bp)+0.5, Kalk.sm(6, bp)+0.5 };
		final double[] riik = { Kalk.riik(0, bp)+0.5, Kalk.riik(1, bp)+0.5,
				Kalk.riik(2, bp)+0.5, Kalk.riik(3, bp)+0.5, Kalk.riik(4, bp)+0.5,
				Kalk.riik(5, bp)+0.5, Kalk.riik(6, bp)+0.5 };
		final double[] tttkm = { Kalk.tttkm(0, bp+0.5), Kalk.tttkm(1, bp+0.5),
				Kalk.tttkm(2, bp+0.5), Kalk.tttkm(3, bp+0.5), Kalk.tttkm(4, bp+0.5),
				Kalk.tttkm(5, bp+0.5), Kalk.tttkm(6, bp+0.5) };
		final double[] tatkm = { Kalk.tatkm(0, bp+0.5), Kalk.tatkm(1, bp+0.5),
				Kalk.tatkm(2, bp+0.5), Kalk.tatkm(3, bp+0.5), Kalk.tatkm(4, bp+0.5),
				Kalk.tatkm(5, bp+0.5), Kalk.tatkm(6, bp+0.5) };
		final double[] pf = { Kalk.pf(0, bp+0.5), Kalk.pf(1, bp+0.5), Kalk.pf(2, bp+0.5),
				Kalk.pf(3, bp+0.5), Kalk.pf(4, bp+0.5), Kalk.pf(5, bp+0.5), Kalk.pf(6, bp+0.5) };

		double kov = Kalk.kov(bp)+0.5;
		double kp = Kalk.kp(bp)+0.5;
		double kpf = Kalk.kpf(bp)+0.5;
		// double to int - et oleks lihtsam tulemusi implementeerida
		final int[] intnp = new int[np.length];
		final int[] intriik = new int[np.length];
		final int[] inttm = new int[np.length];
		final int[] inttttkm = new int[np.length];
		final int[] inttatkm = new int[np.length];
		final int[] intsm = new int[np.length];
		final int[] intpf = new int[np.length];

		final int intkov = (int) kov;
		final int intkp = (int) kp;
		final int intkpf = (int) kpf;
		for (int i = 0; i < np.length; i++) {
			intnp[i] = (int) np[i];
			intriik[i] = (int) riik[i];
			inttm[i] = (int) tm[i];
			inttttkm[i] = (int) tttkm[i];
			inttatkm[i] = (int) tatkm[i];
			intsm[i] = (int) sm[i];
			intpf[i] = (int) pf[i];

			// Leian maksimaalse netopalga sisendipuhul
		}
		int maxnp = Integer.MIN_VALUE;
		String npmax = null;
		for (int arv : intnp) {
			if (arv >= maxnp) {
				maxnp = arv;
				// leian ka, kes antud palgataseme juures pakub kıige
				// kırgemat netopalka
				for (int j = 0; j < 7; j++) {
					if (maxnp == intnp[j]) {
						npmax = M‰‰r.valimised[j];
					}
				}
			}
		}
		return new Object[] { intnp, inttm, intsm, intriik, inttttkm, inttatkm,
				intpf, intkov, intkp, intkpf, maxnp, npmax };

	}

	// testin, et kas on sisestanud ikka numbri. Selleks konventeerin sisestatud
	// Stringi
	// int-iks.
	public static String kontroll(String vastus) {
		boolean bError = true;
		do {
			try {
				Integer.parseInt(vastus);
				bError = false;
			} catch (NumberFormatException e) {
				vastus = JOptionPane.showInputDialog(null,
						"Eesti Vabariigis ei maksta palka " + vastus
								+ "-des, palun sisestage korrektne brutopalk",
						"EBAKORREKTNE VASTUS", JOptionPane.CANCEL_OPTION);
				continue;
			}
		} while (bError);
		return vastus;
	}

	public static int kontroll2(String vastus) {
		// testin ka, kas sisestus on suurem kui kehtiv min palk
		while (Integer.parseInt(vastus) <= 0) {
			vastus = JOptionPane
					.showInputDialog(
							null,
							"Orjatˆˆd Eesti Vabariigis ei tehta, palun sisestage korrektne brutopalk.",
							"Orjatˆˆ", JOptionPane.CANCEL_OPTION);

			boolean bError = true;
			do {
				try {
					Integer.parseInt(vastus);
					bError = false;
				} catch (NumberFormatException e) {
					vastus = JOptionPane
							.showInputDialog(
									null,
									"Eesti Vabariigis ei maksta palka "
											+ vastus
											+ "-des, palun sisestage korrektne brutopalk",
									"EBAKORREKTNE VASTUS",
									JOptionPane.CANCEL_OPTION);
					continue;
				}
			} while (bError);
		}
		// lıpuks nıustun, et sisestuse n‰ol vıib tıepoolest tegu olla
		// brutopalgaga
		int bp = Integer.parseInt(vastus);
		return bp;
	}

}