import java.security.Key;

public class Ciphers extends AuxTextTools {

    private final int ASCII_START = 97;
    //private final int ASCII_STOP = 122;
    private char[] ALPHABET;// = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    //private final char[] ALPHABET;// = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    char[][] transPosArray;
    String clearText;

    public Ciphers(String charset) {
        Charset cs = new Charset();
        if (charset.equals("se")) {
            cs.setSet(0);
            this.ALPHABET = cs.getSet();
        } else if (charset.equals("en")) {
            cs.setSet(1);
            this.ALPHABET = cs.getSet();
        }
    }

    //private int LETTERS = ALPHABET.length;

    /**
     * @param text
     * @param key
     */
    public void makeRot(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(encrypt(array[i], key));
        }
    }

    /**
     * @param text
     * @param key
     */

    public void decryptRot(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            System.out.print(encrypt(array[i], ALPHABET.length - key));
        }

    }

    /**
     * @param cipher
     */

    public void bruteRotation(String cipher) {

        for (int i = 0; i < 26; i++) {
            decryptRot(cipher, ALPHABET.length - i);
            System.out.println();
        }
    }

    /**
     * @param times
     * @return
     */

    public String makeRandomKey(int times) {
        int j;
        String temp = "";
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < times; i++) {
            j = random();

            temp = "" + ALPHABET[j];//PLAIN_TEXT_ALPHABET.substring(j, j+1);
            if (key.indexOf(temp) == -1) {
                key.append(temp);
            }
        }
        return key.toString();
    }

    /**
     *
     */

    /**
     * @param text
     * @return
     */

    public String keyMaker(String text) {

        StringBuilder removeDuplicates = new StringBuilder();

        for (int i = ALPHABET.length - 1; i >= 0; i--) {
            text = text + ALPHABET[i];
        }

        for (int i = 0; i < text.length(); i++) {
            String temp = text.substring(i, i + 1).toUpperCase();
            if (removeDuplicates.indexOf(temp) == -1) {
                removeDuplicates.append(temp);
            }
        }

        String fullKey = removeDuplicates.toString();
        return rmWhite(fullKey);
    }

    /**
     * @param pText
     * @param key
     * @return
     */

    public String substitutionCrypt(String pText, String key) {

        pText = pText + " ";
        String cipherBet = keyMaker(key);
        String cipherText = "";
        int place = 0;

        StringBuilder substitute = new StringBuilder();

        for (int i = 0; i < ALPHABET.length; i++) {
            substitute.append(ALPHABET[i]);
        }

        for (int i = 0; i < pText.length() - 1; i++) {
            String temp = pText.substring(i, i + 1).toLowerCase();
            place = substitute.indexOf(temp);
            if (place != -1) {
                cipherText = cipherText + cipherBet.charAt(place);
            } else {
                cipherText = cipherText + " ";
            }
        }
        return cipherText;
    }

    /**
     * @param cipherText
     * @param key
     * @return
     */

    public String substitutionDeCrypt(String cipherText, String key) {

        cipherText = cipherText + " ";
        String cipherBet = keyMaker(key);
        String plainText = "";
        int place = 0;

        StringBuilder substitute = new StringBuilder();
        substitute.append(cipherBet);
        //System.out.println(substitute.toString());

        for (int i = 0; i < cipherText.length() - 1; i++) {

            String temp = cipherText.substring(i, i + 1).toUpperCase();
            place = substitute.indexOf(temp);

            if (place != -1) {
                plainText = plainText + ALPHABET[place];
            } else {
                plainText = plainText + " ";
            }
        }
        return plainText;
    }


    /**
     * @param text
     * @return
     */

    public String transpCrypt(String text) {

        setClearText(text);
        String cipherText = "";
        int place = 0;
        char padding = clearText.charAt(0);
        char temp;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < transPosArray[0].length; j++) {
                try {
                    transPosArray[i][j] += Character.toUpperCase(clearText.charAt(place));
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

    /**
     * @param pText
     * @return
     */

    public String transpDeCrypt(String pText) {

        setClearText(pText);
        int place = 0;
        char padding = clearText.charAt(0);
        for (int i = 0; i < transPosArray[0].length; i++) {

            for (int j = 0; j < 5; j++) {
                try {
                    transPosArray[j][i] += Character.toLowerCase(clearText.charAt(place));
                    place++;
                } catch (IndexOutOfBoundsException e) {
                    transPosArray[j][i] = padding;
                    place++;
                }
            }
        }
        place = 0;
        pText = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < transPosArray[0].length; j++) {
                pText += transPosArray[i][j];
            }
        }
        return pText;
    }

    /**
     * @param cleartext
     * @param key
     */

    public void xorEncrypt(String cleartext, String key) {

        char[] ctletters = cleartext.toUpperCase().toCharArray();
        char[] kletters = key.toCharArray();
        int keyrotate = 0;
        String hex = "";

        for (int i = 0; i < cleartext.length(); i++) {
            if ((i % key.length()) == 0) {
                keyrotate = 0;
            }
            hex = hex + Integer.toHexString((int) ctletters[i] ^ (int) kletters[keyrotate]) + " ";
            keyrotate++;
        }
        System.out.println(hex);
    }

    /**
     * @param encryptedText
     * @param key
     */

    public void xorDecrypt(String encryptedText, String key) {

        String[] hex = encryptedText.split(" ");
        char[] kletters = key.toCharArray();
        int keyrotate = 0;
        String clearText = "";

        for (int i = 0; i < hex.length; i++) {
            if ((i % key.length()) == 0) {
                keyrotate = 0;
            }
            clearText = clearText + (char) ((Integer.decode("0x" + hex[i]) ^ (int) kletters[keyrotate]));
            keyrotate++;
        }
        System.out.println(clearText);
    }

    /**
     * @param ch
     * @param key
     * @return
     */

    private char encrypt(char ch, int key) {
        int base = 0;
        if ('A' <= ch && ch <= 'Z') {
            base = 'A';
        } else if ('a' <= ch && ch <= 'z') {
            base = 'a';
        } else {
            return ch;
        }
        int offset = ch - base + key;
        return (char) ((offset % 26) + base);
    }

    /**
     * @return
     */

    private int random() {
        return (int) (Math.random() * ALPHABET.length);
    }
    // TODO Clear out this mess

    /**
     * @param text
     */

    public void setClearText(String text) {

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

    public void setCipherText(String text) {
        String cipherText = rmWhite(text);
        transPosArray = new char[5][cipherText.length() / 5];
    }

    /**
     * @param text
     * @return
     */

    // TODO fix!!!!!
    protected String justLetters(String text) {
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

    public char[] alphabetBackwards() {
        char[] alphabetBackwards = new char[ALPHABET.length];
        int j = 0;
        for (int i = ALPHABET.length - 1; i >= 0; i--) {
            alphabetBackwards[j] = ALPHABET[i];
            j++;
        }
        return alphabetBackwards;
    }

    public String alphabetBackwardstoString() {
        char[] ar = alphabetBackwards();
        String alfa = "";
        for (int i = 0; i < ar.length; i++) {
            alfa += ar[i];
        }
        return alfa;
    }
}