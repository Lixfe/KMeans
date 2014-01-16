import java.util.ArrayList;

/**
 * Classe représentant un clustring, c'est à dire une liste de variable + la liste des cluster dans lesquelles ils sont distribués 
 * 
 * @author Raphaël
 *
 */
public class Clustering {

	//Attributs
	protected ArrayList<Variable> listeVariables; //liste de toutes les variables du problème
	protected ArrayList<Cluster> listeCluster; // la liste des cluster est de taille K, dans la méthode du "K-Means"
	
	//Constructeurs
	/**
	 * Construit un clustering à partir d'un jeu de variable et d'un nombre de cluster K
	 * Attribut les centres des K clusters créés à des variables aléatoirement choisies parmi le jeu de variable listevar
	 * 
	 * lance une exception si le jeu de variable donné en paramètre est de taille inférieure à valeurK (car dans ce cas on ne peut choisir K variables)
	 * 
	 * @param listevar
	 * @param valeurK
	 */
	public Clustering (ArrayList<Variable> listevar, int valeurK) {
		this.listeVariables = listevar ;
		this.listeCluster = new ArrayList <Cluster>(valeurK) ;
		
		//sélection de K variables au hasard
		ArrayList<Variable> selectionHasard = new ArrayList<Variable>(valeurK) ;
		
		try {
			if (listevar.size()<valeurK){
				//lancer exception s'il y a moins de variables de K
				//TODO créer une nouvelle exception pour ce cas
			}
		}
		catch (){
			//renvoyer un message d'erreur
		}
		
		//mettre dans selection K variables choisies au hasard dans listevar, c'est possible car on vient de tester
		
		for (int i=0 ; i < valeurK ; i++){
			//ajout d'un cluster avec pour centre la i-ème variable sélectionnée au hasrad ci-dessus
			listeCluster.add(new Cluster(selectionHasard.get(i)));
		}
		
	}
	
	//Méthodes
	
	/**
	 * réalloue l'ensemble des variables de listeVariables dans le cluster le plus proche parmi ceux de listeCluster
	 * 
	 * 2 étapes :
	 * 	1) effacer les listeVariablesCluster de chaque cluster de la listeCluster
	 * 		tout en gardant son centre intact (ce n'est pas un recentrage)
	 * 	2) prendre une à une chaque variable de listeVariables et la copier dans 
	 * 		la liste des variables du cluster le plus similaire
	 * 
	 * @param sim : similarité utilisée (par exemple distance euclidienne)
	 */	 
	public void reallocation(Similarite sim){
		
	}
}
