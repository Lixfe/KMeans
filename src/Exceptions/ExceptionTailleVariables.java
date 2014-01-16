package Exceptions;

/**
 * différents types :
 * 	1) Exception renvoyée lorsque qu'on tente de mesurer une similarité ou une distance entre deux varibales qui n'ont pas la même dimension
 * 		par exemple une distance entre une variable dans R et une autre dans R²
 * 
 * 	2) Exception renvoyé lorsqu'une liste de variable est trop courte
 * 		par exemple lorsqu'on essaie de sélectionner K variables parmi une liste
 * 		qui en compte moins de K
 * 
 * @author Raphaël
 *
 */
public class ExceptionTailleVariables extends Exception {

	//attributs
	private static final long serialVersionUID = 1L;
	public int code;
	
	//constructeurs
	public ExceptionTailleVariables(int codeRenvoye) {
		this.code=codeRenvoye;
	}
	
	//TODO faire un conctructeur de l'exception ExceptionTailleVariables avec comme arguments les deux entiers tailles des tableaux
		
	}
