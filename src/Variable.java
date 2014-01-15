import java.util.ArrayList;



/**
 * Classe représentant une variable donnée.
 * La dimension de la variable est libre
 * 
 * @author Felix
 *
 */
public class Variable {

	protected ArrayList<Double> coordonnees;
	
	/**
	 * Constructeur d'une instance de variable
	 * @param coord : coordonnées de la variable
	 */
	public Variable(ArrayList<Double> coord){
		coordonnees = coord;
	}
	
	public Variable(Variable var){
		coordonnees = new ArrayList<Double>(var.getCoordonnees());
	}
	
	public ArrayList<Double> getCoordonnees(){
		return this.coordonnees;
	}
	
	
}
