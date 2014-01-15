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
		
		ArrayList<Float> coordNouveauCentre = new ArrayList<Float>();
		
		//Si le cluster ne contient aucun point, son centre de gravité est inchangé
		if (listeVariablesCluster.size() == 0)
		{coordNouveauCentre = new ArrayList<Float>(centre.getCoordonnees());}
	
		else{
			//Pour chaque dimension on calcule la coordonnee du centre de gravite
			for (int i = 0; i < centre.coordonnees.size(); i++) {
				Float x = new Float(0);
				for (Variable var : listeVariablesCluster) {
					x = x+var.getCoordonnees().get(i);
				}
				x = x/centre.coordonnees.size();
				coordNouveauCentre.set(i, x);
			}
		}

	}
}
