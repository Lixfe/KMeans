import java.util.ArrayList;


/**
 * Classe repr�sentant une variable donn�e.
 * La dimension de la variable est libre
 * 
 * @author Felix
 *
 */
public class Variable {

	protected ArrayList<Float> coordonnees;
	
	/**
	 * Constructeur d'une instance de variable
	 * @param coord : coordonn�es de la variable
	 */
	public Variable(ArrayList<Float> coord){
		coordonnees = coord;
	}
	
	
}
