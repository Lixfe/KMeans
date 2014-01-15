import java.util.ArrayList;

/**
 * Classe abstraite dont héritent les différentes similarités (distance euclidienne, etc...)
 * @author Raphaël
 *
 */
public abstract class Similarite {
	
	public abstract float similarite (Variable a, Variable b);

}
