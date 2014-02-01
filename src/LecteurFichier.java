import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class LecteurFichier {
	
	protected ArrayList<Variable> listeVariable;
	
	public LecteurFichier(String nomFichier) throws IOException{
		
		ArrayList<Variable> variables = new ArrayList<Variable>();
		
		Scanner fileScanner = new Scanner(new File(nomFichier));

		while (fileScanner.hasNextLine()){
			//On va extraire ligne par ligne pour récupérer les coordonnées de chaque variable (1 ligne = 1 variable)
			String line = fileScanner.nextLine();

			Scanner lineScanner = new Scanner(line);

			//On va stocker les coordonnées de la variable lue
			ArrayList<Double> listeCoord = new ArrayList<Double>();		
			while (lineScanner.hasNext()){
				listeCoord.add(lineScanner.nextDouble());
			}
			lineScanner.close();

			//On crée une variable dans laquelle on rentre les coordonnées
			Variable var = new Variable(listeCoord);
			variables.add(var);


		}
		
		fileScanner.close();

		
		this.listeVariable = variables;
	}
	
	public ArrayList<Variable> getVariables(){
		return this.listeVariable;
	}

}
