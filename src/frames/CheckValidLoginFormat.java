package frames;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckValidLoginFormat {

	/**
	 * Fais le test pour vérifier si le login utilisateur réspecte 
	 * les consignes 
	 */
	@Test
    @DisplayName("Test Correct login user format")
	    public void testValidEmail() {
	        assertTrue(FileAuthService.isValidEmail("user@example.com"));
	        assertTrue(FileAuthService.isValidEmail("john.doe123@domain.net"));
	        assertFalse(FileAuthService.isValidEmail("userexample.com")); // Pas de @
	    }

		/**
		 * Fais un test pour vérifier que le mot de passe
		 * contient des caractère spéciaux et soit au moins 12 caractères
		 */
	    @Test
	    @DisplayName("Test Correct password user format")
	   public void testValidPassword() {
	        assertTrue(FileAuthService.isValidPassword("Azertyuiop*4."));
	        assertFalse(FileAuthService.isValidPassword("qwerty")); // Trop court
	        assertFalse(FileAuthService.isValidPassword("johndoeburger")); // Pas de caractère spéciaux
	    }

}
