package samostalniCas30_10;

public class Kamion extends Vozilo {

		private double kapacitetTereta;
		private boolean imaPrikolicu;
		
		public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, double kapacitetTereta,
				boolean imaPrikolicu) {
			super(proizvodjac, godinaProizvodnje, kubikaza, boja);
			this.kapacitetTereta = kapacitetTereta;
			this.imaPrikolicu = imaPrikolicu;
		}
		

		public double getKapacitetTereta() {
			return kapacitetTereta;
		}
		public void setKapacitetTereta(double kapacitetTereta) {
			this.kapacitetTereta = kapacitetTereta;
		}
		public boolean isImaPrikolicu() {
			return imaPrikolicu;
		}
		public void setImaPrikolicu(boolean imaPrikolicu) {
			this.imaPrikolicu = imaPrikolicu;
		}


		@Override
		public void prikaziInformacije() {
			// TODO Auto-generated method stub
			super.prikaziInformacije();
			System.out.println("Kapacitet tereta: " + kapacitetTereta);
			System.out.println("Da li ima prikolicu: " + (imaPrikolicu ? "da" : "ne"));
		}


		@Override
		public double cijenaRegistracije() {
			double cijena = super.cijenaRegistracije();
			cijena += 50;
			if (imaPrikolicu) {
				cijena +=20;
			}
			return cijena;
		}
		
		
		
		
}
