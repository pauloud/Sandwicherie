package src;
import java.util.ArrayList;

public class ListeIngredients implements Ingredient {
    private ArrayList<Pair <Ingredient,Double> > composition;
    private double masseTotale; 
    public double kcalFor100g (){
            return composition.stream().reduce (0.0, (m,i) -> i.left.kcalFor100g()*i.right,(m,mi) -> m + mi)
                    /masseTotale; 
    }
     
    
}
