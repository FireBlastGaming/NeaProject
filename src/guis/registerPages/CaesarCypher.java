package guis.registerPages;

public class CaesarCypher {

    // constant alphabet
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    // method that encrypts any input text using the Caeser cypher
    public static String encrypt (String plainText){
        // turns the input text into lowercase
        plainText = plainText.toLowerCase();
        StringBuilder cypherText = new StringBuilder();
        // loops through the length of the plainText
        for (int i = 0; i < plainText.length(); i++) {
            int charIndex = alphabet.indexOf(plainText.charAt(i));
            // sets the new value of the character to the encrypted value by summing the current index with the shiftKey of 15
            int keyValue = (15 + charIndex) % 26;
            char replaceValue = alphabet.charAt(keyValue);
            // adds to the String CypherText
            cypherText.append(replaceValue);
        }
        // returns the encrypted text
        return cypherText.toString();
    }
    // encase we need it in the future
//    public static String decrypt (String cypherText){
//        cypherText = cypherText.toLowerCase();
//        StringBuilder plainText = new StringBuilder();
//        for (int i = 0; i < cypherText.length(); i++) {
//            int charPosition = alphabet.indexOf(cypherText.charAt(i));
//            int keyValue = (charPosition-15) % 26;
//            if (keyValue < 0){
//                keyValue = alphabet.length() + keyValue;
//            }
//            char replaceValue = alphabet.charAt(keyValue);
//            plainText.append(replaceValue);
//        }
//        return plainText.toString();
//    }
}
