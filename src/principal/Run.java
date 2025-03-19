package principal;

import java.awt.EventQueue;

/**
 * Point d'entrée pour permettre à notre
 * interface graphique de s'afficher
 */
public class Run {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
