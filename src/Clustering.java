import java.util.ArrayList;
import java.util.Random;

import Exceptions.ExceptionTailleVariables;

/**
 * Classe représentant un clustring, c'est à dire une liste de variable + la liste des cluster dans lesquelles ils sont distribués 
 * 
 * @author Raphaël
 *
 */
public class Clustering{

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
	public Clustering (ArrayList<Variable> listevar, int valeurK)  throws ExceptionTailleVariables {
		this.listeVariables = listevar ;
		this.listeCluster = new ArrayList <Cluster>(valeurK) ;
		
		//sélection de K variables au hasard
		ArrayList<Variable> selectionHasard = new ArrayList<Variable>(valeurK) ;
		
		try {
			if (listevar.size()<valeurK){
				//lancer exception s'il y a moins de variables de K
				throw new ExceptionTailleVariables(2);
			}
		}
		catch (ExceptionTailleVariables e){
			System .out . println (e.getMessage());
			return ;
		}
		
		//mettre dans selection K variables choisies au hasard dans listevar, c'est possible car on vient de tester
		Random random = new Random();
		 for (int i = 0; i < valeurK; i++)
		    {
			 	// pour chaque i on ajoute à selectionHasard une variable choisie au hasard parmi listevar
		        selectionHasard.add(listevar.get(random.nextInt(listevar.size()))); 
		   
		    }
		
		for (int i=0 ; i < valeurK ; i++){
			//ajout d'un cluster avec pour centre la i-ème variable sélectionnée au hasrad ci-dessus
			listeCluster.add(new Cluster(selectionHasard.get(i)));
		}
		
	}
	
	//Méthodes
	
	/**
	 * réalloue chaque variable de listeVariables dans le cluster le plus proche parmi ceux de listeCluster
	 * renvoie vrai si la réallocation a engendré des changements, faux si elle n'a eu aucun effet
	 * 
	 * 2 étapes :
	 * 
	 * 	1) effacer les listeVariablesCluster de chaque cluster de la listeCluster
	 * 		tout en gardant son centre intact (ce n'est pas un recentrage)
	 * 	2) prendre une à une chaque variable de listeVariables et la copier dans 
	 * 		la liste des variables du cluster le plus similaire
	 * 	3) recalcule les centres des clusters grâce à la méthode recentrer de chaque cluster
	 * 	4) si l'un au moins des clusters a changé de centre, alors il y a modification donc on renvoie VRAI
	 * 	sinon on renvoie FAUX
	 * 
	 * @param sim : similarité utilisée (par exemple distance euclidienne)
	 */	 
	public boolean reallocation(Similarite sim) throws ExceptionTailleVariables {
		System.out.println("début de la réallocation");
		try {
		//effacer les variables de chaque cluster
		for (int i=0 ; i<this.listeCluster.size();i++){
			this.listeCluster.get(i).listeVariablesCluster.clear();
		};
		System.out.println("variables effacees");
		
		//réattribution des variables :
		//pour chaque variable...
		for (int i=0 ; i<this.listeVariables.size() ; i++){
			//...on cherche parmi les centres de cluster le plus similaire...
			
			int indiceClusterProche = 0 ;
			for (int j=0 ; j<this.listeCluster.size() ; j++){
				//pour chaque cluster on regarde si le centre est plus similaire à la variable considérée que le centre d'indice "indiceClusterProche"
				if (sim.similarite(this.listeVariables.get(i), this.listeCluster.get(j).centre) > sim.similarite(this.listeVariables.get(i), this.listeCluster.get(indiceClusterProche).centre)){
					indiceClusterProche=j;
				}		
			}
			
			//...et on place la variable dans ce cluster
			this.listeCluster.get(indiceClusterProche).listeVariablesCluster.add(this.listeVariables.get(i));
		}
		System.out.println("variables reattribues");
		
		//reclalcul des centres des clusters, en regardant si l'un au moins a change :
		boolean changement = false ;
		for (int i = 0 ; i<this.listeCluster.size() ; i++){
			System.out.println("recalcul du centre du cluster numero "+(i+1));
			if (this.listeCluster.get(i).calculerCentre()){
				changement = true ;
			};
			System.out.print("nouveau centre du cluster "+(i+1)+" : ");
			for (int d=0 ; d<this.listeCluster.get(i).centre.coordonnees.size() ; d++){
				System.out.print(this.listeCluster.get(i).centre.coordonnees.get(d)+" , ");
			}
			System.out.println("");
		}
		
		System.out.println("resultat reallocation : il y a eu du changement ? "+changement);
	
		return changement;
		
		}
		catch (ExceptionTailleVariables e){
			System .out . println (e.getMessage());
			return false ; 
		}
	}
}
