import java.io.IOException;
import java.util.ArrayList;

import Exceptions.ExceptionTailleVariables;


public class Test {

	public static void main(String[] args) throws ExceptionTailleVariables {
		// TODO Auto-generated method stub
		ArrayList<Double> coordV1 = new ArrayList<Double>();
		coordV1.add(0.);
		coordV1.add(0.);
		Variable v1 = new Variable(coordV1); 
		ArrayList<Double> coordV2 = new ArrayList<Double>();
		coordV2.add(0.);
		coordV2.add(1.);
		Variable v2 = new Variable(coordV2);
		
		Cluster clusterTest = new Cluster(v1);
		clusterTest.ajoutCluster(v1);
		clusterTest.ajoutCluster(v2);
		//clusterTest.calculerCentre();
		Variable centre = new Variable(clusterTest.getCentre());
		for (int i = 0; i < centre.getCoordonnees().size(); i++) {
			System.out.println("Coordonnee x"+i+" du centre : "+centre.getCoordonnees().get(i));
		}
		
		//test de la distance euclidienne
		Similarite sim = new DistanceEuclidienne()  ;
		double d = sim.similarite(v1, v2); 
		System.out.println("la distance euclidienne entre v1 et v2 est "+d);
		
		//test de la création d'un clustering, et de la convergence en deux étapes
		ArrayList<Variable> listeVariable = new ArrayList<Variable>();
		listeVariable.add(v1);
		listeVariable.add(v2);
		
		Clustering solutionClustering = new Clustering(listeVariable, 1);
		System.out.println("clustering créé");
		
		int nombrePasse = 0 ;//mettre le nombre de passage voulu dans la boucle
		
		for (int compteur = 1 ;compteur<=nombrePasse ; compteur++){ 
			System.out.println("pssage numéro "+compteur);
		for (int i = 0; i < solutionClustering.listeCluster.get(0).getCentre().getCoordonnees().size(); i++) {
			System.out.println("Coordonnee x"+i+" du centre : "+ solutionClustering.listeCluster.get(0).getCentre().getCoordonnees().get(i));
		}
		solutionClustering.reallocation(sim);
		}

		/*test de création d'un kmeans
		
		KMeans probleme = new KMeans(1, sim);
		System.out.println("kmeans créé");
		probleme.run(listeVariable);
		*/
		
		/*deuxieme test
		KMeans probleme2 = new KMeans(2, sim);
		
		ArrayList<Double> coordV3 = new ArrayList<Double>();
		coordV3.add(0.);
		coordV3.add(1.5);
		Variable v3 = new Variable(coordV3);
		listeVariable.add(v3);
		
		ArrayList<Double> coordV4 = new ArrayList<Double>();
		coordV4.add(0.);
		coordV4.add(2.5);
		Variable v4 = new Variable(coordV4);
		listeVariable.add(v4);
		
		probleme2.run(listeVariable);*/
		
		//test de la lecture fichier
		try{
		LecteurFichier lf = new LecteurFichier("C:\\donnees-kmeans1.txt");
		ArrayList<Variable> rep = lf.getVariables();
		for (int i = 0; i < rep.size(); i++) {
			System.out.print("Coordonnees de la varible "+i+" : ");
			for (int j=0 ; j<rep.get(i).coordonnees.size() ; j++){
				System.out.print(rep.get(i).coordonnees.get(j)+" ; ");
			}
			
		}
		}
		catch(IOException e){
			System.out.println("Erreur lors de l'entrée du nom de fichier");
		}
	}

}
