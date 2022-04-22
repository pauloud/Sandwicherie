package sandwicherie;

public interface Aliment {
	
	
    static double kcToKj(double kcal){
        return kcal *  4.1855; 
    }
    void setKcalPour100g(double kcal) throws NiveauCalException;
	double getKcalPour100g();
	String getNom();

}