package cas0611;

public class Racunari extends EProizvodi {
	private String procesor;
	private int memorija;
	
	public Racunari(String opisProizvoda, String sifraProizvoda, double uvoznaCijena, String procesor, int memorija) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.procesor = procesor;
		this.memorija = memorija;
	}
	
	@Override
    public double Cijena() {
        
		return uvoznaCijena * 1.05;
    }
	
	@Override
    public String toString() {
        return "RAČUNAR - " + super.toString() + ", Procesor: " + procesor + ", Memorija: " + memorija + "GB";
    }
	
}
