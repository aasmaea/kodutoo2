package kalkulaator;

/**
 * @author Aare Aasmäe IA18 Antud classi on kirjutanud autor ise reaalsete
 *         faktide või lubaduste alusel, kasutades andmeid:
 *         Neivelt - http://uudised.err.ee/v/arvamus/00b94117-fadb-47b7-beae-6feaad321b8c 
 *         IRL - http://arileht.delfi.ee/news/uudised/vaata-tabelist-kui-suur-oleks-sinu-palk-irl-i-pakutud-tulumaksuvabastusega.d?id=69603445 
 *         Keskerakond -http://uudised.err.ee/v/majandus/4a3dce34-8fe1-406f-b7e9-31ad5cfc392b
 *         Sotsiaaldemokraadid - http://blogid.sotsdem.ee/rahandus/
 *         Reformierakond-http://www.reform.ee/kindlalt-edasi/?utm_source=re&utm_medium
 *         =banner&utm_campaign=kindlalt_edasi
 *         2014. maksusüsteem -http://www.emta.ee/index.php?id=34957 
 *         2015. maksusüsteem -http://www.emta.ee/index.php?id=35954
 *
 */
public class Määr {
	// erinevate tööjõumaksusüsteemide väljapakkujad
	public static final String[] valimised = { "Neiveltit", "IRL-i",
			"Keskerakonda", "Sotsiaaldemokraate", "Reformierakonda",
			"2014. Palk", "2015. Palk"};
	// erinevate platvormide sotsiaalmaksumäärad
	public static final double[] smm = { (double) 0.26, (double) 0.33,
			(double) 0.33, (double) 0.33, (double) 0.31, (double) 0.33,
			(double) 0.33 };
	// erinevate platvormide tööandjatöötuskindlustusmäärad
	public static final double[] tatkmm = { (double) 0.008, (double) 0.008,
			(double) 0.008, (double) 0.008, (double) 0.0065, (double) 0.01,
			(double) 0.008 };
	// erinevate platvormide maksuvaba tulud
	public static final double[] mvt = { (double) 400, (double) 400,
			(double) 154, (double) 1000, (double) 300, (double) 144,
			(double) 154 };
	// erinevate platvormide töötaja töötuskindlustusmäärad
	public static final double[] tttkmm = { (double) 0.016, (double) 0.016,
			(double) 0.016, (double) 0.016, (double) 0.013, (double) 0.02,
			(double) 0.016 };
	// erinevate platvormide tulumaksumäärad
	public static final double[] tmm = { (double) 0.24, (double) 0.2,
			(double) 0.2, (double) 0.26, (double) 0.2, (double) 0.21,
			(double) 0.20 };
	// KOV tuludesse laekub brutopalgast 11,6 %. Ei leidnud infot, selle
	// muutmise kohta
	public static final double komm = 0.116;
	// Riik lisab kahekordse töötaja kogumispensioni panuse
	public static final double kpfm = 2;
	// Brutopalgast peatakse kogumispensionisse üldjuhul kinni 2%
	public static final double kpm = 0.02;
	// keskerakonna spetsiifilised - igast eurost, mis ületab brutotasu 2000 €
	// pakub KE välja tulumaksu 33%
	public static final double tmm2 = 0.33;
	public static final double btm = 2000;
	// irl spetsiifilised - Kui brutopalk Kuni 500 €, siis on see tulumaksuvaba;
	// 500-846 € teatud tulumaksuvabastusega.
	public static final double mvt2 = 500; // IRL tuluvabastus start
	public static final double mvt3 = 846; // IRL tuluvabastus lõpp

}
