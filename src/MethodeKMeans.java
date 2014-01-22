import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
	
	public void parse(String nomFichier){
		
	}
	
	
	public static void main(String[] args) {
		
		try{
			//Lecture du nom de ficheir contenant les données sources
			System.out.println("Nom du fichier contenant les données sources");
			String adresseFichier = new String();
			
			Scanner sc = new Scanner(adresseFichier);
			
			adresseFichier = sc.next();
			
			
			sc.close();
			 
		}
		catch(IOException e){
			System.out.println("Erreur lors de l'entrée du nom de fichier");
		}

	}

}
