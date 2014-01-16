import Exceptions.ExceptionTailleVariables;


/**
 * Classe abstraite dont héritent les différentes similarités (distance euclidienne, etc...)
 * @author Raphaël
 *
 */
public abstract class Similarite  {
	
	public abstract double similarite (Variable a, Variable b) throws ExceptionTailleVariables;

}
