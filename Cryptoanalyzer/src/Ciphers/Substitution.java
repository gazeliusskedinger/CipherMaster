package Ciphers;

public class Substitution extends Cipher implements ICipher{
    @Override
    public String encrypt(String plain, String key) {
        return null;
    }

    @Override
    public String decrypt(String cipher, String key) {
        return null;
    }

    @Override
    public void analysis(String cipher) {

    }

    @Override
    public String brute(String cipher) {
        return null;
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
     * @return
     */

    private int random() {
        return (int) (Math.random() * ALPHABET.length);
    }

}
