package src;
public interface Aliment {
    static double kcToKj(double kcal){
        return kcal *  4.1855; 
    }
    double kcalFor100g(); 
    
}
