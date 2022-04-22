package sandwicherie;
import java.util.ArrayList;


public class SandwichVegetarien<P extends PainVegetarien, S extends SauceVegetarienne, I extends IngredientVegetarien> 
	extends Sandwich <P,S,I>{


	public SandwichVegetarien(P pain, S sauce, ArrayList<I> ingredients)  {
			super(pain,sauce,ingredients); 
	}
	

	
}
