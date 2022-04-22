package sandwicherie;


import java.util.ArrayList;


public class Test {
	public static void main(String[] args) throws NiveauCalException{
		
		//----Initialisation des ingredients----	
		Pain baguette = new Pain("Baguette");
		baguette.setKcalPour100g(0.01);
		PainVegetarien pvege = new PainVegetarien("Pain aux herbes");
		pvege.setKcalPour100g(30);
		PainVegan pvegan = new PainVegan("Pain au blé complet");
		pvegan.setKcalPour100g(100);

		Sauce s = new Sauce("Algerienne");
		s.setKcalPour100g(10);
		SauceVegetarienne svege = new SauceVegetarienne("Sauce Blanche");
		svege.setKcalPour100g(30);
		SauceVegan svegan = new SauceVegan("The vert");
		svegan.setKcalPour100g(15);
		
		Ingredient kebab = new Ingredient("Kebab");
		kebab.setKcalPour100g(100);
		Ingredient agneau = new Ingredient("Agneau");
		agneau.setKcalPour100g(120);
		IngredientVegetarien saumon = new IngredientVegetarien("Saumon");
		saumon.setKcalPour100g(130);
		IngredientVegetarien fromage = new IngredientVegetarien("Fromage");
		fromage.setKcalPour100g(23);
		IngredientVegan salade = new IngredientVegan("Salade");
		salade.setKcalPour100g(999);
		IngredientVegan the = new IngredientVegan("The noir")	;
		the.setKcalPour100g(999);
		
		
		
		ArrayList<IngredientVegetarien> listIngredientsVege = new ArrayList<IngredientVegetarien>();
		listIngredientsVege.add(saumon);
		listIngredientsVege.add(fromage);
		
		ArrayList<IngredientVegan> listIngredientsVegan = new ArrayList<IngredientVegan>();
		listIngredientsVegan.add(salade);
		listIngredientsVegan.add(the);
		//----Fin de l'initialisation des ingredients----
		
		
		//----Creation des sandwichs simple, vegetarien et vegan----
		Sandwich<Pain, Sauce, Ingredient> sandwichPasCher = new SandwichPasCher<Pain, Sauce, Ingredient>(baguette,s,kebab,agneau); 
		SandwichVegetarien<PainVegetarien,SauceVegetarienne,IngredientVegetarien> sandwichVegetarien = new SandwichVegetarien<>(pvege,svege,listIngredientsVege);
		SandwichVegan <PainVegan,SauceVegan,IngredientVegan> sandwichVegan = new SandwichVegan<>(pvegan,svegan,listIngredientsVegan);
		//----Fin de la creation----
		
		
		//----test methode de deplacement----
		assert(!sandwichVegetarien.deplacerVers(saumon, sandwichPasCher));
		Sandwich<Pain,Sauce,Ingredient> sandwichQuelconque = new Sandwich<>(baguette);
		assert(sandwichVegetarien.deplacerVers(saumon, sandwichQuelconque));
		assert(sandwichPasCher.deplacerVers(kebab,sandwichQuelconque));
		assert(sandwichQuelconque.deplacerVers(saumon,sandwichPasCher)); 
		assert(sandwichPasCher.deplacerVers(saumon,sandwichQuelconque));
		assert(sandwichVegan.deplacerVers(the,sandwichVegetarien));
		assert(sandwichVegetarien.deplacerVers(the,sandwichQuelconque));
		//----fin test----
		
		sandwichVegan.ajouterIngredient(the);
		
		//----test method si deux sandwichs ont un ingredient en commun----
		assert(sandwichQuelconque.aUnIngredientCommun(sandwichQuelconque));
		assert(sandwichQuelconque.aUnIngredientCommun(sandwichVegan));
		assert(!sandwichVegetarien.aUnIngredientCommun(sandwichVegan));
		//----fin test----
		
		
		//----test methode element plus lourd avec iterateur, stream et sans iterateur ou stream----
		assert(sandwichQuelconque.elementPlusLourd()==saumon); 
		System.out.println(sandwichQuelconque.elementPlusLourd().getNom()); 
		System.out.println(saumon.getNom());
		System.out.println(saumon.getClass());

		//----fin test----
		
		
		
	}
}
