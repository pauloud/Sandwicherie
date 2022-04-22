package sandwicherie;

 

public class SandwichPasCher<P extends Pain,S extends Sauce,I extends Ingredient> extends Sandwich<P,S,I> {
    public SandwichPasCher(P pain, S sauce, I ingredient1, I ingredient2){
        super(pain);
       ajouterIngredient(ingredient1);
       ajouterIngredient(ingredient2);
    }
    @Override 
    public boolean accepteIngredient(I ingredient){
        return nombreIngredients()< 2 ;  
    }
    
}
