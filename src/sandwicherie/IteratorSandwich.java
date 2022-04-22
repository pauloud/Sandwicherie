package sandwicherie;

import java.util.Iterator;

public class IteratorSandwich implements Iterator<Aliment>{
	private int nbrElementVu = 0;
	private Sandwich sandwich;
	
	public IteratorSandwich(Sandwich s) {
		this.sandwich = s;
	}

	@Override
	public boolean hasNext() {
		
		return this.nbrElementVu < sandwich.nombreIngredients() + 2;
	}

	@Override
	public Aliment next() {
		Aliment a;
		switch(nbrElementVu) {
		case 0: a = sandwich.getPain();break;
		case 1: a = sandwich.getSauce();break;
		default: a = (Aliment)sandwich.getIngredients().get(nbrElementVu -2); 
		}
		this.nbrElementVu++;
		return a;

	}

}
