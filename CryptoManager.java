
public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters
	 * 
	 * @param plainText
	 *            a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean stringInBounds(String plainText) {

		// char[] plainTextArray = plainText.toCharArray();
		boolean stringBool = false;
		for (int i = 0; i < plainText.length(); i++) {

			int ascii = (int) plainText.charAt(i);

			if (ascii >= LOWER_BOUND && ascii <= UPPER_BOUND) {

				stringBool = true;

			} else {

				stringBool = false;

				return stringBool;
			}

		}

		return stringBool;

		// throw new RuntimeException("method not implemented");
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText
	 *            an uppercase string to be encrypted.
	 * @param key
	 *            an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {

		int value = 0;
		String result = "";
		for (int i = 0; i < plainText.length(); i++) {
			int ascii = (int) plainText.charAt(i);
			value = ascii + key;
			while (key > UPPER_BOUND) {
				key -= RANGE;

			}
			char strValue = (char) value;
			result = result + strValue;
		}

		return result;

		// throw new RuntimeException("method not implemented");
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText
	 *            an uppercase string to be encrypted.
	 * @param bellasoStr
	 *            an uppercase string that specifies the offsets, character by
	 *            character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {

		String result = "";

		for (int i = 0; i < plainText.length(); i++) {

			int num = 0;

			num = plainText.charAt(i) + bellasoStr.charAt(i % bellasoStr.length());

			while (num > UPPER_BOUND) {

				num = num - (RANGE);
			}

			result = result + (char) num;
		}

		return result;

		// throw new RuntimeException("method not implemented");
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText
	 *            an encrypted string to be decrypted.
	 * @param key
	 *            an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {

		int value = 0;
		String result = "";

		for (int i = 0; i < encryptedText.length(); i++) {

			int ascii = (int) encryptedText.charAt(i);
			value = ascii - key;
			while (value > UPPER_BOUND) {

				value -= RANGE;

			}
			char strValue = (char) value;
			result = result + strValue;
		}

		return result;

		// throw new RuntimeException("method not implemented");
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText
	 *            an uppercase string to be encrypted.
	 * @param bellasoStr
	 *            an uppercase string that specifies the offsets, character by
	 *            character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		String result = "";

		for (int i = 0; i < encryptedText.length(); i++) {

			int num = 0;

			num = encryptedText.charAt(i) - bellasoStr.charAt(i % bellasoStr.length());

			while (num < LOWER_BOUND) {

				num = num + RANGE;
			}

			result = result + (char) num;
		}

		return result;

		// throw new RuntimeException("method not implemented");
	}
}
