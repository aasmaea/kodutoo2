package kalkulaator;

import kalkulaator.M‰‰r;

public class Kalk {
	public static String poliitika(int i) {
		String poliitika = M‰‰r.valimised[i];
		return poliitika;
	}

	public static double tatkm(int i, double a) {

		double tatkm = a * (M‰‰r.tatkmm[i]);
		return tatkm;

	}

	public static double sm(int i, double a) {
		double sm = a * (M‰‰r.smm[i]);
		return sm;
	}

	public static double tttkm(int i, double a) {
		double tttkm = a * (M‰‰r.tttkmm[i]);
		return tttkm;
	}

	public static double kp(double a) {
		double kp = a * (M‰‰r.kpm);
		return kp;
	}

	public static double tm(int i, double a) {
		double tm = 0;
		// irl
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

			// kesk
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
		} else {
			tm = (a - kp(a) - tttkm(i, a) - M‰‰r.mvt[i]) * M‰‰r.tmm[i];
			if (tm < 0)
				tm = 0;
			return tm;
		}
	}

	public static double np(int i, double a) {
		double np = a - tm(i, a) - kp(a) - tttkm(i, a);
		return np;
	}

	public static double pf(int i, double a) {
		double pf = a + sm(i, a) + tatkm(i, a);
		return pf;
	}

	public static double kpf(double a) {
		double kpf = kp(a) + kp(a) * M‰‰r.kpfm;
		return kpf;
	}

	public static double kov(double a) {
		double kov = a * M‰‰r.komm;
		return kov;
	}

	public static double riik(int i, double a) {
		double riik = pf(i, a) - np(i, a) - kov(a) - kpf(a);
		return riik;
	}

	public static int i = 5;

//	public static void main(String[] args) {
//		System.out.println("Palun sisestage soovitud maksus¸steem "
//				+ "\n1- Neivelt" + "\n2- IRL" + "\n3- Keskerakond"
//				+ "\n4- Sotsiaaldemokraadid" + "\n5- Reformierakond"
//				+ "\n6- 2014. kehtiv s¸steem" + "\n7- 2015. kehtiv s¸steem");
//	int i = TextIO.getlnInt() - 1;
//		System.out.println("Palun sisestage brutopalk");
//		double a = TextIO.getDouble();
//		System.out.println("Te valite " + M‰‰r.valimised[i]);
//		System.out.println("Teie netopalk on " + np(i, a) + " Ä");
//		System.out.println();
//		System.out.println("Ettevıtte palgakulu on " + pf(i, a) + " Ä");
//		System.out.println("Ettevıte maksab sotsiaalmaksu " + sm(i, a) + " Ä");
//		System.out.println("Tˆˆandja maksab tˆˆtuskindlustusmaksu "
//				+ tatkm(i, a) + " Ä");
//		System.out.println();
//		System.out.println("Tˆˆtaja maksab tˆˆtuskindlustusmaksu "
//				+ tttkm(i, a) + " Ä");
//		System.out.println("Pensionifondi maksab tˆˆtaja " + kp(a) + " Ä");
//		System.out.println("Tulumaksu tasute " + tm(i, a) + " Ä");
//		System.out.println();
//		System.out.println("Riigile laekub maksudena " + riik(i, a) + " Ä");
//		System.out.println("Kohalikule omavalitsusele laekub maksudena "
//				+ kov(a) + " Ä");
//		System.out.println("Kogumispensionifondi laekub " + kpf(a) + " Ä");
//
//	}
}
