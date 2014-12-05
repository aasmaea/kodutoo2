package swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kalkulaator.Määr;

/**
 * @author Aare Aasmäe IA18. Antud classi on kirjutanud autor ise. Antud klassi
 *         kirjutas et kood oleks paremini liigendatud. Tulemused koosnevad II
 *         etapist, üks on kirjalik selgitav jutt ja teine on võrdlustabel.
 */
public class Tulemused {
	public static void tulemus(String vastus[], int bp, int valimised_index,
			int valimised_index2, int[] intsm, int[] inttatkm, int[] inttttkm,
			int[] intnp, int[] intriik, int[] inttm, int intkp, int intkpf,
			int intkov, String npmax, int maxnp) {
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
								+ vastus[0] + " tasute" + "	 tulumaksu "
								+ inttm[valimised_index]

						, "TULEMUSED", JOptionPane.INFORMATION_MESSAGE);

	}

	// Siin tuleb tabel
	public static void tabel(int bp, int valimised_index, int valimised_index2,
			int[] intsm, int[] inttatkm, int[] inttttkm, int[] intnp,
			int[] intriik, int[] inttm, int intkp, int intkpf, int intkov,
			int[] intpf) {
		// ridade initseerimine ja ridade nimetused ja ridade arvutused
		Object rowData[][] = {
				{ "Brutopalk", bp, bp, bp - bp },

				{ "Sotsiaalmaks", intsm[valimised_index],
						intsm[valimised_index2],
						intsm[valimised_index2] - intsm[valimised_index] },
				{ "Töötuskindlustus I", inttatkm[valimised_index],
						inttatkm[valimised_index2],
						inttatkm[valimised_index2] - inttatkm[valimised_index] },
				{ "Palgafond", intpf[valimised_index], intpf[valimised_index2],
						intpf[valimised_index2]

						- intpf[valimised_index] },
				{ "", "", "", "" },
				{ "Netopalk", intnp[valimised_index], intnp[valimised_index2],
						intnp[valimised_index2] - intnp[valimised_index] },
				{ "Tulumaks", inttm[valimised_index], inttm[valimised_index2],
						inttm[valimised_index2] - inttm[valimised_index] },
				{ "Töötuskindlustus II", inttttkm[valimised_index],
						inttttkm[valimised_index2],
						inttttkm[valimised_index2] - inttttkm[valimised_index] },
				{ "Kogumispension", intkp, intkp, 0 },
				{ "", "", "", "" },
				{ "Riigi tulud", intriik[valimised_index],
						intriik[valimised_index2],
						intriik[valimised_index2] - intriik[valimised_index] },
				{ "KOV-tulud", intkov, intkov, 0 },
				{ "Pensionifond", intkpf, intkpf, 0 },

		};
		// tulpade initseerimine, ning tulpade nimetused
		Object columnNames[] = { "Valite", Määr.valimised[valimised_index],
				(Määr.valimised[valimised_index2]), "Vahe" };
		// tabeli initseerimine läbi tulpade ja ridade massiivide
		JTable table = new JTable(rowData, columnNames);
		// frame initsieerimine
		JFrame frame = new JFrame("AARE AASMÄE IA18");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane(table); // lubab
															// tabelit
															// positsiooneerida
		frame.add(scrollPane, BorderLayout.CENTER); // et tabel oleks
													// frame keskel
		frame.setSize(500, 300); // frame suuruse määramine
		frame.setVisible(true);// et oleks nähtav
		// frame.setLocationRelativeTo(null); // et oleks ekraani keskel,

	}
}
