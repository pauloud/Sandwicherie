package sandwicherie;

import java.util.ArrayList;

import sandwicherie.*;

public class  
	SandwichVegan<P extends PainVegan, S extends SauceVegan, I extends IngredientVegan> 
	extends Sandwich<P,S,I>{
	
	public SandwichVegan(P pain, S sauce, ArrayList<I> ingredients){
    	super(pain,sauce,ingredients);
    }
	


	
}
