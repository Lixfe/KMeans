import java.util.ArrayList;



/**
 * Classe repr�sentant une variable donn�e.
 * La dimension de la variable est libre
 * 
 * @author Felix
 *
 */
public class Variable {

	protected ArrayList<Double> coordonnees;
	
	/**
	 * Constructeur d'une instance de variable
	 * @param coord : coordonn�es de la variable
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
