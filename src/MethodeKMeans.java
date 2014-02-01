import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import Exceptions.ExceptionTailleVariables;

import com.sun.org.apache.xml.internal.serializer.ToUnknownStream;

/**
 * Classe principale du programme
 * Contient le jeu de données considéré ainsi qu'une méthode  pour lire le jeu de données à partir d'un fichier
 * externe
 * Classe qui contient la méthode main
 * @author Felix
 *
 */
public class MethodeKMeans {

	protected ArrayList<Variable> jeuDonnees;
	
		
	
	public static void main(String[] args) {
		
		try{
			//lecture du fichier et création de la liste des variables
			LecteurFichier lf = new LecteurFichier("C:\\donnees-kmeans.txt");
			
			//on place les données lues dans le fichier dans une liste de variables (le 2 correspond à la dimension des variables)
			ArrayList<Variable> donneesFichier = lf.getVariables();
			
			//on initialise le probleme avec une distance
			Similarite sim = new DistanceEuclidienne()  ;
			KMeans probleme = new KMeans(2, sim);
			
			//on lance l'algorithme du kmeans
			probleme.run(donneesFichier);
			
	
			
		} catch (ExceptionTailleVariables e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e){
			System.out.println("Erreur lors de l'entrée du nom de fichier");
		}
		finally {
			System.out.println("fini !");
		}

	}

}
