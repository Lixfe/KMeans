import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
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
		clusterTest.calculerCentre();
		Variable centre = new Variable(clusterTest.getCentre());
		for (int i = 0; i < centre.getCoordonnees().size(); i++) {
			System.out.println("Coordonnée x"+i+" du centre : "+centre.getCoordonnees().get(i));
		}
	}

}
