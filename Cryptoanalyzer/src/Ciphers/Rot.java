package Ciphers;

public class Rot extends Cipher implements ICipher{

    public Rot(char[] alpha){
        this.ALPHABET = alpha;
    }

    @Override
    public String encrypt(String text, String key){

        int keyInt = Integer.parseInt(key);
        char[] array = text.toCharArray();
        String cipher = "";

        for (int i = 0; i < text.length(); i++) {
           cipher += ""+process(array[i], keyInt);
        }

        return cipher;
    }

    @Override
    public String decrypt(String cipher, String key){

        int keyInt = Integer.parseInt(key);
        char[] array = cipher.toCharArray();
        String text = "";

        for (int i = 0; i < cipher.length(); i++) {
            text += process(array[i], ALPHABET.length - keyInt);
        }

        return text;
    }

    @Override
    public String brute(String cipher) {

        String bruted = "";

        for (int i = 0; i < ALPHABET.length; i++) {
            bruted += i + " : "+ decrypt(cipher, (""+(ALPHABET.length - i)));
        }
        return bruted;
    }

    @Override
    public void analysis(String cipher){

    }

    public String reverseEncrypt(String Plain, String key){
        return encrypt(strToStrBw(Plain),key);
    }

    public String reverseDecrypt(String Cipher, String key){
        return decrypt(strToStrBw(Cipher),key);
    }

    public String reverseBrute(String Cipher){
        return brute(strToStrBw(Cipher));
    }

    private char process(char ch, int key) {
        int base = 0;
        if ('A' <= ch && ch <= 'Z') {
            base = 'A';
        } else if ('a' <= ch && ch <= 'z') {
            base = 'a';
        } else {
            return ch;
        }
        int offset = ch - base + key;
        return (char) ((offset % ALPHABET.length) + base);
    }
}
