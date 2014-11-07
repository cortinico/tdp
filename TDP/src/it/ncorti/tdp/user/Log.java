package it.ncorti.tdp.user;
/**
 * Classe di debug per l'invio di messaggi di log su stdout/stderr nel formato Tag+Messaggio
 * 
 * @author Nicola Corti
 *
 */
public class Log {

	/** Lunghezza massima del campo TAG */
	private final static int TAGSIZE = 16;

	/**
	 * Metodo statico per formattare un TAG con lunghezza massima TAGSIZE
	 * 
	 * @param TAG Tag da formattare
	 * @return Il Tag formattato
	 */
	private static String formatTAG(String TAG) {
		if (TAG.length() > TAGSIZE) {
			return TAG.substring(0, TAGSIZE);
		} else if (TAG.length() < TAGSIZE) {
			for (int lenght = TAG.length(); lenght < TAGSIZE; lenght++)
				TAG += " ";
			return TAG;
		} else {
			return TAG;
		}
	}

	/**
	 * Metodo per stampare un errore su stderr
	 * 
	 * @param TAG Tag del messaggio
	 * @param message Messaggio di errore
	 */
	public static void e(String TAG, String message) {
		System.err.println(formatTAG(TAG) + "   >>  \t" + message);
	}

	/**
	 * Metodo per stampare un messaggio su stdout
	 * 
	 * @param TAG Tag del messaggio
	 * @param message Messaggio da stampare
	 */
	public static void o(String TAG, String message) {
		System.out.println(formatTAG(TAG) + "   >>  \t" + message);
	}
}
