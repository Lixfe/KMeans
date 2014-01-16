package Exceptions;

/**
 * Exception renvoyé lorsque qu'on tente de mesurer une similarité ou une distance entre deux varibales qui n'ont pas la même dimension
 * par exemple une distance entre une variable dans R et une autre dans R²
 * @author Raphaël
 *
 */
public class ExceptionTailleVariables extends Exception {


	private static final long serialVersionUID = 1L;
	public int n,m;
	
	//TODO faire un conctructeur de l'exception ExceptionTailleVariables avec comme arguments les deux entiers tailles des tableaux
		
	}
