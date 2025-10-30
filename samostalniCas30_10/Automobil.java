package samostalniCas30_10;

public class Automobil extends Vozilo {
	
	private int brojVrata;
	private String tipMotora;
	
	public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int brojVrata,
			String tipMotora) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.brojVrata = brojVrata;
		this.tipMotora = tipMotora;
	}

	public int getBrojVrata() {
		return brojVrata;
	}

	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}

	public String getTipMotora() {
		return tipMotora;
	}

	public void setTipMotora(String tipMotora) {
		this.tipMotora = tipMotora;
	}

	@Override
	public void prikaziInformacije() {
		// TODO Auto-generated method stub
		super.prikaziInformacije();
		System.out.println("Broj vrata: " + brojVrata);
		System.out.println("Tip motora: " + tipMotora);
	}

	@Override
	public double cijenaRegistracije() {
		double cijena = super.cijenaRegistracije();
		cijena += 20;
		return cijena;
	}
	

	
	
	
}
