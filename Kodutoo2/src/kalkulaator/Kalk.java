package kalkulaator;

import kalkulaator.M‰‰r;

/**
 * @author Aare Aasm‰e IA18 Antud Classi on kirjutanud autor ise kasutades
 *         loogikat palgafondi osade arvutamiseks. Abi sai lehelt maksuameti
 *         veebilehelt. 2014. aasta kalkulatsioonid kontrollitud kalkulaator.ee
 *         palgakalkulaatoris.
 */
// class Kalk on kirjutatud, kokku algandmete classi (m‰‰r) alusel,
// kombineerides seda erinevate k‰ibelolevate valemitega, et leida erinevate
// sisendite (brutopalk ja valitav maksus¸steem) korral kıiki teisi palgafondi
// liikmeid
public class Kalk {
	// Poliitika v‰ljendab erinevate valimisplatformide
	// massiivi i-ndat elementi. Ehk siis ¸ksikut valimisplatformi.
	public static String poliitika(int i) {
		String poliitika = M‰‰r.valimised[i];
		return poliitika;
	}

	// tˆˆandja tˆˆtuskindlustusm‰‰r
	public static double tatkm(int i, double a) {

		double tatkm = a * (M‰‰r.tatkmm[i]);
		return tatkm;

	}

	// sotsiaalmaks
	public static double sm(int i, double a) {
		double sm = a * (M‰‰r.smm[i]);
		return sm;
	}

	// tˆˆtaja tˆˆtuskindlustusm‰‰r
	public static double tttkm(int i, double a) {
		double tttkm = a * (M‰‰r.tttkmm[i]);
		return tttkm;
	}

	// kogumispension brutopalgast
	public static double kp(double a) {
		double kp = a * (M‰‰r.kpm);
		return kp;
	}

	// tulumaksu arvutus. Kuna IRL ja Keskerakond lubavad senisest erisugust
	// tulumaksustamiss¸steemi siis ei saanud nende pıhjal ¸ldistusi teha ja
	// vajalik oli nendetulumaksus¸steemid eraldi v‰lja kirjutada. Kıik teised
	// tulumaksus¸steemid on sıltuvad maksuvabast tulust, tulumaksum‰‰rast ja
	// brutopalgast.
	public static double tm(int i, double a) {
		double tm = 0;
		// IRL tulumaksuarvutus
		if (i == 1 || i == 2) {
			if (i == 1) {
				if (a >= M‰‰r.mvt2) {
					if (a <= M‰‰r.mvt3)
						M‰‰r.mvt[1] = M‰‰r.mvt2 - (a - M‰‰r.mvt2);
				}
				tm = (a - kp(a) - tttkm(i, a) - M‰‰r.mvt[1]) * M‰‰r.tmm[1];
				if (tm < 0)
					tm = 0;
				return tm;
			}

			// Keskerakonna tulumaksuarvutus
			if (i == 2)
				;
			{
				if (a <= M‰‰r.btm) {
					tm = (a - kp(a) - tttkm(i, a) - M‰‰r.mvt[2]) * M‰‰r.tmm[2];
				} else {
					tm = (a - kp(a) - tttkm(i, a) - M‰‰r.mvt[2]) * M‰‰r.tmm[2]
							+ (M‰‰r.tmm2 - M‰‰r.tmm[2]) * ((a) - M‰‰r.btm);
				}
				if (tm < 0) {
					tm = 0;
				}
				return tm;
			}
		} else { // ‹lej‰‰nute tulumaksuarvutus
			tm = (a - kp(a) - tttkm(i, a) - M‰‰r.mvt[i]) * M‰‰r.tmm[i];
			if (tm < 0)
				tm = 0;
			return tm;
		}
	}

	// netopalk = brutopalk-tulumaks-kogumispension-tˆˆtajatˆˆtuskindlustusmakse
	public static double np(int i, double a) {
		double np = a - tm(i, a) - kp(a) - tttkm(i, a);
		return np;
	}

	// palgafond = brutopalk + tˆˆandja tˆˆtuskindlustusmakse + sotsiaalmaks
	public static double pf(int i, double a) {
		double pf = a + sm(i, a) + tatkm(i, a);
		return pf;
	}

	// riik lisab kahekordse tˆˆtajalt kinnipeetud kogumispensioni makse.
	public static double kpf(double a) {
		double kpf = kp(a) + kp(a) * M‰‰r.kpfm;
		return kpf;
	}

	// Hetkel kehtiva seaduse j‰rgi, saab 11,6 % brutopalgast oma tulusse
	// kohalik omavalitsus, kus palgatˆˆtaja on sisse kirjutatud.
	public static double kov(double a) {
		double kov = a * M‰‰r.komm;
		return kov;
	}

	// Riigimaksud = palgafond- netopalk - kohaliku omavalitsuse tulud -
	// kogumispensionifond
	public static double riik(int i, double a) {
		double riik = pf(i, a) - np(i, a) - kov(a) - kpf(a);
		return riik;
	}

	public static int i = 5;

	public static void main(String[] args) {
		System.out.println("Palun sisestage soovitud maksus¸steem "
				+ "\n1- Neivelt" + "\n2- IRL" + "\n3- Keskerakond"
				+ "\n4- Sotsiaaldemokraadid" + "\n5- Reformierakond"
				+ "\n6- 2014. kehtiv s¸steem" + "\n7- 2015. kehtiv s¸steem");
		int i = TextIO.getlnInt() - 1;
		System.out.println("Palun sisestage brutopalk");
		double a = TextIO.getDouble();
		System.out.println("Te valite " + M‰‰r.valimised[i]);
		System.out.println("Teie netopalk on " + np(i, a) + " Ä");
		System.out.println();
		System.out.println("Ettevıtte palgakulu on " + pf(i, a) + " Ä");
		System.out.println("Ettevıte maksab sotsiaalmaksu " + sm(i, a) + " Ä");
		System.out.println("Tˆˆandja maksab tˆˆtuskindlustusmaksu "
				+ tatkm(i, a) + " Ä");
		System.out.println();
		System.out.println("Tˆˆtaja maksab tˆˆtuskindlustusmaksu "
				+ tttkm(i, a) + " Ä");
		System.out.println("Pensionifondi maksab tˆˆtaja " + kp(a) + " Ä");
		System.out.println("Tulumaksu tasute " + tm(i, a) + " Ä");
		System.out.println();
		System.out.println("Riigile laekub maksudena " + riik(i, a) + " Ä");
		System.out.println("Kohalikule omavalitsusele laekub maksudena "
				+ kov(a) + " Ä");
		System.out.println("Kogumispensionifondi laekub " + kpf(a) + " Ä");

	}
}
