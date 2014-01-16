import Exceptions.ExceptionTailleVariables;

/**
 * Classe représentant une similarite
 * @author Raphaël
 *
 *a et b sont deux variables de mêmes dimensions
 *
 */
public class DistanceEuclidienne extends Similarite {

	//TODO en faire eun singleton ? 
	
	@Override
	public double similarite(Variable a, Variable b) throws ExceptionTailleVariables {
		int n = a.coordonnees.size() ;
		double distanceCarre = 0d; 
		
		try {
			if (n != b.coordonnees.size()) {
				throw new ExceptionTailleVariables();
			}
			
			//TODO faire un conctructeur de l'exception ExceptionTailleVariables avec comme arguments les deux entiers tailles des tableaux 
			
			//définition de la distance euclidienne : d²(i,i') = Somme(pour j=1..n) (Zij-Zi'j)²
			
				for (int j = 0 ; j < n ; j++ ){
					distanceCarre = distanceCarre + Math.pow( a.coordonnees.get(j)-b.coordonnees.get(j), 2);
				}
			return Math.sqrt(distanceCarre);	
			
		}
		catch (ExceptionTailleVariables e){
			System .out . println ("variables de tailles différentes");
			return 0d ;
		}
	
		
	}

}
