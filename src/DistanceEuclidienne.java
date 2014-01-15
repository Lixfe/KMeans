import Exceptions.ExceptionTailleVariables;


/**
 * Classe représentant une similarite
 * @author Raphaël
 *
 *a et b sont deux variables de mêmes dimensions
 *
 */
public class DistanceEuclidienne extends Similarite {

	@Override
	public float similarite(Variable a, Variable b) {
		int n = a.coordonnees.size() ;
		try {
			if (n != b.coordonnees.size()) {
				throw new ExceptionTailleVariables(a.coordonnees.size(),b.coordonnees.size());
			}
			else {

			}

		}
		catch (ExceptionTailleVariable e){
			System .out . println ("variables de tailles différentes");
			return ;
		}
		
	}

}
