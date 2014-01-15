import java.util.ArrayList;


/**
 * Classe représentant une variable donnée.
 * La dimension de la variable est libre
 * 
 * @author Felix
 *
 */
public class Variable {

	protected ArrayList<Float> coordonnees;
	
	/**
	 * Constructeur d'une instance de variable
	 * @param coord : coordonnées de la variable
	 */
	public Variable(ArrayList<Float> coord){
		coordonnees = coord;
	}
	
	
}
