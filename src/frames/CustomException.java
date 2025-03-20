package frames;

/**
 * Classe CustomException pour gérer des cas spécifiques d'erreurs.
 * Cette classe étend RuntimeException et permet de lever des exceptions personnalisées avec un message spécifique.
 */
public class CustomException extends RuntimeException {

    /**
     * Constructeur de la classe CustomException.
     * 
     * @param message Le message d'erreur à afficher lorsque l'exception est levée.
     */
    public CustomException(String message) {
        super(message);
    }
}