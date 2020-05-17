import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    String originalMessage = scanner.nextLine();
    int total_shifts = scanner.nextInt();
    scanner.close();

    String result = caesarCipher_fromPlainText_toCipherText(originalMessage, total_shifts);
    System.out.println(result);
  }

  /**
   * Encrypts the original message by the method of Caesar's Cipher: each character in the original
   * message is shifted to the right of the alphabet. If the total number of shifts exceeds 
   * the number of letters in the alphabet, then it continues counting from the first alphabet character
   * again, and so on, until the total number of shifts is reached.
   *
   * The position of the punctuation marks, spaces and the letter case in the encrypted text
   * is preserved as in the original message.
   *
   * @return A string, representing the encrypted message.
   */
  private static String caesarCipher_fromPlainText_toCipherText(String plain_text, int total_shifts) {

    StringBuilder cipher_text = new StringBuilder();

    for (int i = 0; i < plain_text.length(); i++) {

      char ch = plain_text.charAt(i);
      if (Character.isLetter(ch)) {
        cipher_text.append(findCipherChar(ch, total_shifts));
      } else {
        cipher_text.append(ch);
      }
    }
    return cipher_text.toString();
  }

  private static char findCipherChar(char char_text, int total_shifts) {

    // The method is called only if the character is already confirmed as a letter.
    // Therefore, if the code point is greater than 96, then it is a lowercase character. 
    // Otherwise, it is an uppercase character.
    int codePoint_for_a_or_for_A = (int) char_text > 96 ? (int) 'a' : (int) 'A';
    int alphabetPosition_char_text = (int) char_text - codePoint_for_a_or_for_A;
    int alphabetPosition_char_cipher = alphabetPosition_char_text + total_shifts;

    if (alphabetPosition_char_cipher < 26) {
      return (char) (codePoint_for_a_or_for_A + alphabetPosition_char_cipher);
    }

    return (char) (codePoint_for_a_or_for_A + (alphabetPosition_char_cipher % 26));
  }
}
