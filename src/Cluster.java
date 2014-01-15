import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Classe représentant un cluster avec sa liste de points
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
	
	public void calculerCentre(){
		
		ArrayList<Double> coordNouveauCentre = new ArrayList<Double>();
		
		//Si le cluster ne contient aucun point, son centre de gravité est inchangé
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
		this.centre = new Variable(coordNouveauCentre);
	}
	
	public void ajoutCluster(Variable var){
		this.listeVariablesCluster.add(var);
	}
	
	public Variable getCentre(){
		return this.centre;
	}
}
