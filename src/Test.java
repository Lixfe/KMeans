import java.util.ArrayList;

import Exceptions.ExceptionTailleVariables;


public class Test {

	public static void main(String[] args) throws ExceptionTailleVariables {
		// TODO Auto-generated method stub
		ArrayList<Double> coordV1 = new ArrayList<Double>();
		coordV1.add(1.);
		coordV1.add(1.);
		Variable v1 = new Variable(coordV1); 
		ArrayList<Double> coordV2 = new ArrayList<Double>();
		coordV2.add(2.);
		coordV2.add(2.);
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

		//test de création d'un kmeans
		
		KMeans probleme = new KMeans(1, sim);
		System.out.println("kmeans créé");
		probleme.run(listeVariable);
		
		
		
	}

}
