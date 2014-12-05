package swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kalkulaator.M��r;

/**
 * @author Aare Aasm�e IA18. Antud classi on kirjutanud autor ise. Antud klassi
 *         kirjutas et kood oleks paremini liigendatud. Tulemused koosnevad II
 *         etapist, �ks on kirjalik selgitav jutt ja teine on v�rdlustabel.
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
				{ "T��tuskindlustus I", inttatkm[valimised_index],
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
				{ "T��tuskindlustus II", inttttkm[valimised_index],
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
		Object columnNames[] = { "Valite", M��r.valimised[valimised_index],
				(M��r.valimised[valimised_index2]), "Vahe" };
		// tabeli initseerimine l�bi tulpade ja ridade massiivide
		JTable table = new JTable(rowData, columnNames);
		// frame initsieerimine
		JFrame frame = new JFrame("AARE AASM�E IA18");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane(table); // lubab
															// tabelit
															// positsiooneerida
		frame.add(scrollPane, BorderLayout.CENTER); // et tabel oleks
													// frame keskel
		frame.setSize(500, 300); // frame suuruse m��ramine
		frame.setVisible(true);// et oleks n�htav
		// frame.setLocationRelativeTo(null); // et oleks ekraani keskel,

	}
}
