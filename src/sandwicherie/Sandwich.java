package sandwicherie;

import java.util.ArrayList;
import java.util.Iterator;



public class Sandwich <P extends Pain,S extends Sauce,I extends Ingredient> implements Iterable<Aliment>{
	
    private P pain;
    private S sauce;
    private ArrayList<I> ingredients = new ArrayList<>();
    
    //----------------Constructeur et getMethod------------
	public Sandwich(P pain){
		this.pain = pain; 
	}
	public Sandwich(P pain, S sauce, ArrayList<I> ingredients){
		
		this.pain = pain;
    	this.sauce = sauce;
    	ingredients.stream().forEach(i->ajouterIngredient(i));
    }
	
	public P getPain() {
		return pain;
	}
	public S getSauce() {
		return sauce;
	}
	public void setSauce(S sauce){
		this.sauce = sauce; 
	}
	
	protected final ArrayList<I> getIngredients() {
		return ingredients;
	}
	public final int nombreIngredients(){
		return ingredients.size(); 

	}
	
	public String toString() {
		String res ="Composition du sandwich : "
				+"Pain:"+this.getPain().getNom()+" + "
				+"Sauce:"+this.getSauce().getNom()+" + Ingredients:";
		for (Ingredient i:ingredients) {
			res += i.getNom()+"/";
		}
		
		res = res.substring(0,res.length()-1);
		return res;
	}
    //-------------------Methode Basique sans stream--------------------
	
	public final boolean aUnIngredientCommun(Sandwich<?,?,?> s){
		for(Ingredient i:getIngredients()) {
			if (s.getIngredients().contains(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean accepteIngredient(I ingredient){
		return true; 
	}
    public final boolean ajouterIngredient(I i){
		if (! accepteIngredient(i))
			return false; 
    	assert(this.ingredients.add((I)i));
		return true; 
    }
	public final <J extends Ingredient> boolean  deplacerVers(J ingredient, Sandwich<?,?,J> s){
		if (this.ingredients.contains(ingredient)&&s.accepteIngredient(ingredient)) {
			ingredients.remove(ingredient);
			s.ajouterIngredient(ingredient);
			return true; 
			
		}
		return false;
	}
    
	//----------------Pour appeler la fonction elementPlusLourd il faut avoir au max 3 ingredients dans le sandwich---------------

    public Aliment elementPlusLourd() {
    	Aliment resultat;
    	double plusLourd;
    	
    	if (sauce == null || Double.compare (sauce.getKcalPour100g(), pain.getKcalPour100g()) > 0) { 
    		resultat = pain; 
    		plusLourd = pain.getKcalPour100g();
    	}
    	else {
    		resultat = sauce;
    		plusLourd = sauce.getKcalPour100g();
    	}
    	
    	for(int indice = 0; indice < ingredients.size();indice++) {
			I i = ingredients.get(indice);
    		if (i != null && Double.compare (plusLourd, i.getKcalPour100g()) < 0) {
    			plusLourd = i.getKcalPour100g();
    			resultat = i;
    		}
    	}
    	
    	return resultat; 
    	
    }

    //----------------Methode pour iterateur----------------
	//----------------Pour appeler la fonction elementPlusLourd il faut avoir au max 3 ingredients dans le sandwich---------------

    public IteratorSandwich iterator() {
		return new IteratorSandwich(this);
	}
	
	public String elementPlusLourdAvecIterateur() {
		String lePlusLourd = "";
		double max = 0;
		for(Aliment a: this) {
			if (a != null && a.getKcalPour100g()> max) {
				max = a.getKcalPour100g();
				lePlusLourd = a.getNom();
			}
		}
		return "L'element le plus lourd montre par l'itarateur est : \n" + lePlusLourd;
	}
	
	//----------------Methode pour stream----------------
	//----------------Pour appeler la fonction elementPlusLourd il faut avoir au max 3 ingredients dans le sandwich---------------
	public ArrayList<Aliment> composition(){
		ArrayList<Aliment> resultat = new ArrayList<Aliment>();
		for(Aliment a: this) {
			resultat.add(a);
		}
		resultat.remove(resultat.size()-1);
		return resultat;
	}
    
	public int valMaxCalElement() {
		return this.composition().stream()
				.mapToInt(v -> (int) v.getKcalPour100g())
				.max().getAsInt();
	}
	
    public void elementPlusLourdAvecStream() {
    	System.out.println("L'elementle plus lourd montre par stream est : ");
    	this.composition().stream()
    		.filter(a -> a != null && a.getKcalPour100g()== this.valMaxCalElement())
    		.map(n -> n.getNom())
    		.forEach(System.out::println);
    }
	  
}
