package sandwicherie;

public class Ingredient implements Aliment{

	private double kCalPour100g;
	private String nom;
	
	public Ingredient(String nom) {this.nom = nom;}
	
	public void setKcalPour100g(double kcal) throws NiveauCalException{
		/*if (kcal>1000 || kcal<=0) {
			throw new NiveauCalException("kcal hors norme !");
		}*/
		this.kCalPour100g = kcal;
	}

	public double getKcalPour100g() { return this.kCalPour100g;}

	public String getNom() {
		return nom;
	}
}
