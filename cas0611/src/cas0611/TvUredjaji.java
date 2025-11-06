package cas0611;

public class TvUredjaji extends EProizvodi {
	private double velicinaEkrana;

	public TvUredjaji(String opisProizvoda, String sifraProizvoda, double uvoznaCijena, double velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.velicinaEkrana = velicinaEkrana;
	}
	
	 @Override
	    public double Cijena() {
	        double cijena = uvoznaCijena * 1.05;
	        if (velicinaEkrana > 65)
	            cijena *= 1.10; 
	        return cijena;
	    }

	    @Override
	    public String toString() {
	        return "TV - " + super.toString() + ", Ekran: " + velicinaEkrana + "''";
	    }
}
