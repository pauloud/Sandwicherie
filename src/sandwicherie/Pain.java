package sandwicherie;

public class Pain implements Aliment{
	
	private double getKcalPour100g;
	private String nom;
	
	public Pain(String nom) {this.nom = nom;}
	
	public void setKcalPour100g(double kcal) throws NiveauCalException{
		if (kcal>1000 || kcal<=0) {
			throw new NiveauCalException("kcal hors norme !");
		}
		this.getKcalPour100g = kcal;
	}


	public double getKcalPour100g() { return this.getKcalPour100g;}

	@Override
	public String getNom() {
		return nom;
	}
}
