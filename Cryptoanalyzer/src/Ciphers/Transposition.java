package Ciphers;

public class Transposition extends Cipher implements ICipher {
    char[][] transPosArray;
    @Override
    public String encrypt(String plain, String key) {


        String cipherText = "";
        int place = 0;
        char padding = plain.charAt(0);
        char temp;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < transPosArray[0].length; j++) {
                try {
                    transPosArray[i][j] += Character.toUpperCase(plain.charAt(place));
                    place++;
                } catch (IndexOutOfBoundsException e) {
                    transPosArray[i][j] = padding;
                }
            }

        }
        place = 0;
        for (int i = 0; i < transPosArray[0].length; i++) {
            for (int j = 0; j < 5; j++) {
                cipherText += transPosArray[j][i];
            }
            cipherText += " ";
        }
        return cipherText;

    }

    @Override
    public String decrypt(String cipher, String key) {
        String plain = "";
        int place = 0;
        char padding = cipher.charAt(0);
        for (int i = 0; i < transPosArray[0].length; i++) {

            for (int j = 0; j < 5; j++) {
                try {
                    transPosArray[j][i] += Character.toLowerCase(cipher.charAt(place));
                    place++;
                } catch (IndexOutOfBoundsException e) {
                    transPosArray[j][i] = padding;
                    place++;
                }
            }
        }
        place = 0;
        plain = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < transPosArray[0].length; j++) {
                plain += transPosArray[i][j];
            }
        }
        return plain;
    }

    @Override
    public void analysis(String cipher) {

    }

    @Override
    public String brute(String cipher) {
        return null;
    }

    private void setClearText(String text) {

        String clearText = rmWhite(text);
        text = clearText;
        clearText = justLetters(text);
        int len = clearText.length();

        if (Math.ceil(clearText.length() / 5) < len) {
            transPosArray = new char[5][clearText.length() / 5 + 1];
        } else {
            transPosArray = new char[5][clearText.length() / 5];
        }
    }

    /**
     * @param text
     */

    private void setCipherText(String text) {
        String cipherText = rmWhite(text);
        transPosArray = new char[5][cipherText.length() / 5];
    }

    /**
     * @param text
     * @return
     */

    // TODO fix!!!!!
    private String justLetters(String text) {
        String textOut = "";
        char test;
        for (int i = 0; i < text.length(); i++) {
            test = text.charAt(i);
            if (Character.isLetter(test)) {
                textOut += text.charAt(i);
            }
        }
        return textOut;
    }
}
