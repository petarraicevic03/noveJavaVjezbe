package samostalniCas30_10;

public class Kombi extends Vozilo{
	
		private int kapacitetPutnika;

		public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetPutnika) {
			super(proizvodjac, godinaProizvodnje, kubikaza, boja);
			this.kapacitetPutnika = kapacitetPutnika;
		}

		public int getKapacitetPutnika() {
			return kapacitetPutnika;
		}

		public void setKapacitetPutnika(int kapacitetPutnika) {
			this.kapacitetPutnika = kapacitetPutnika;
		}

		@Override
		public void prikaziInformacije() {
			// TODO Auto-generated method stub
			super.prikaziInformacije();
			System.out.println("Kapacitet putnika: " + kapacitetPutnika);
		}

		@Override
		public double cijenaRegistracije() {
			double cijena = super.cijenaRegistracije();
			if (kapacitetPutnika>8) {
				cijena +=30;
			}
			return cijena;
		}
		
		
		
}
