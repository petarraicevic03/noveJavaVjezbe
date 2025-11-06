package cas0611;

public class Telefon extends EProizvodi{
	private String operativniSistem;
	private double velicinaEkrana;
	
	public Telefon(String opisProizvoda, String sifraProizvoda, double uvoznaCijena, String operativniSistem,
			double velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.operativniSistem = operativniSistem;
		this.velicinaEkrana = velicinaEkrana;
	}
	
	@Override
    public double Cijena() {
        double cijena = uvoznaCijena * 1.05;
        if (velicinaEkrana > 6)
            cijena *= 1.03; 
        return cijena;
    }

    @Override
    public String toString() {
        return "TELEFON - " + super.toString() + ", OS: " + operativniSistem + ", Ekran: " + velicinaEkrana + "''";
    }
}

