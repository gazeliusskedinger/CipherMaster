package Ciphers;

public abstract class Cipher {
    protected char[]ALPHABET = null;

    public Cipher(){

    }

    public String encrypt(String plain, String key){

        return "";
    }

    public String decrypt(String cipher, String key){

        return "";
    }

    public void analyse(String cipher){

    }
    public String brute(String cipher){
        return "";
    }
    /**
     *
     * @param Text
     * @return
     */



    protected String rmWhite(String Text){
        return Text.replaceAll("\\s+", "");
    }


}
