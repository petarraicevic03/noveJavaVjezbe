package cas0611;

public class EProizvodi {

		protected String opisProizvoda;
		protected String sifraProizvoda;
		protected double uvoznaCijena;
		
		public EProizvodi(String opisProizvoda, String sifraProizvoda, double uvoznaCijena) {
			super();
			this.opisProizvoda = opisProizvoda;
			this.sifraProizvoda = sifraProizvoda;
			this.uvoznaCijena = uvoznaCijena;
		}
				
		
		public double Cijena() {
	        return uvoznaCijena * 1.05;
	    }

		@Override
		public String toString() {
			return "opis= " + opisProizvoda + ", sifraProizvoda= " + sifraProizvoda + ", uvoznaCijena= " + uvoznaCijena;
		}
		
		
}
