package Ciphers;

public class Xor implements ICipher {
    @Override
    public String encrypt(String plain, String key) {
        char[] ctletters = plain.toUpperCase().toCharArray();
        char[] kletters = key.toCharArray();
        int keyrotate = 0;
        String hex = "";

        for (int i = 0; i < plain.length(); i++) {
            if ((i % key.length()) == 0) {
                keyrotate = 0;
            }
            hex = hex + Integer.toHexString((int) ctletters[i] ^ (int) kletters[keyrotate]) + " ";
            keyrotate++;
        }
        return hex;
    }

    @Override
    public String decrypt(String cipher, String key) {
        String[] hex = cipher.split(" ");
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
        return clearText;
    }

    @Override
    public void analysis(String cipher) {

    }

    @Override
    public String brute(String cipher) {
        return null;
    }
}
