import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Classe repr�sentant un cluster avec sa liste de points
 * @author Felix
 *
 */
public class Cluster {

	protected LinkedList<Variable> listeVariablesCluster;
	protected Variable centre;
	
	public Cluster(Variable centreDepart){
		listeVariablesCluster = new LinkedList<Variable>();
		centre = new Variable(centreDepart);
	}
	
	/**reclacule le centre de gravité d'un cluster
	 * renvoie vrai si la calcule a engendré des changements, faux si il n'a eu aucun effet
	 * @return
	 */
	public boolean calculerCentre(){
		
		// TODO throws ExceptionTaillevaribles pour le cas où le variables ne sont pas toutes de même dimensions
		
		
		ArrayList<Double> coordNouveauCentre = new ArrayList<Double>();
		
		//Si le cluster ne contient aucun point, son centre de gravit� est inchang�
		if (listeVariablesCluster.size() == 0)
		{coordNouveauCentre = new ArrayList<Double>(centre.getCoordonnees());}
	
		else{
			//Pour chaque dimension on calcule la coordonnee du centre de gravite
			for (int i = 0; i < centre.getCoordonnees().size(); i++) {
				Double x = new Double(0);
				for (Variable var : listeVariablesCluster) {
					x = x+var.getCoordonnees().get(i);
				}
				x = x/centre.coordonnees.size();
				coordNouveauCentre.add(x);
			}
		}
		
		if (this.centre.coordonnees.equals(coordNouveauCentre)){
			System.out.println("calcul nouveau centre : aucun changement");
			return false;
		}
		else{
			this.centre = new Variable(coordNouveauCentre);
			System.out.println("calcul nouveau centre : changement");
			return true;
		}
		
	}
	
	public void ajoutCluster(Variable var){
		this.listeVariablesCluster.add(var);
	}
	
	public Variable getCentre(){
		return this.centre;
	}
}
