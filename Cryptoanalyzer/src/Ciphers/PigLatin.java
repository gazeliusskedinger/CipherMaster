package Ciphers;

public class PigLatin extends Cipher implements ICipher{

    public PigLatin(char[] alpha){
        this.ALPHABET = alpha;
    }

    @Override
    public String encrypt(String plain, String key) {
        plain = plain + " ";
        String cipherBet = charArrToStr(ALPHABET);
        String cipherText = "";
        int place = 0;

        StringBuilder substitute = new StringBuilder();

        for (int i = 0; i < ALPHABET.length; i++) {
            substitute.append(ALPHABET[i]);
        }

        for (int i = 0; i < plain.length() - 1; i++) {
            String temp = plain.substring(i, i + 1).toLowerCase();
            place = substitute.indexOf(temp);
            if (place != -1) {
                cipherText = cipherText + cipherBet.charAt(place);
            } else {
                cipherText = cipherText + " ";
            }
        }
        return cipherText;
    }

    @Override
    public String decrypt(String cipher, String key) {
        cipher = cipher + " ";
        String cipherBet = charArrToStr(ALPHABET);
        String plainText = "";
        int place = 0;

        StringBuilder substitute = new StringBuilder();
        substitute.append(cipherBet);
        //System.out.println(substitute.toString());

        for (int i = 0; i < cipher.length() - 1; i++) {

            String temp = cipher.substring(i, i + 1).toUpperCase();
            place = substitute.indexOf(temp);

            if (place != -1) {
                plainText = plainText + ALPHABET[place];
            } else {
                plainText = plainText + " ";
            }
        }
        return plainText;
    }

    @Override
    public void analysis(String cipher) {

    }

    @Override
    public String brute(String cipher) {
        return null;
    }


}
