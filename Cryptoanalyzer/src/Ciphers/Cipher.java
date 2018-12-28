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

    public void analysis(String cipher){

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

    /**
     *
     * @return
     */

    protected char[] charArrBw(char [] charArr) {
        char[] charArrBW = new char[charArr.length];
        int j = 0;
        for (int i = charArr.length - 1; i >= 0; i--) {
            charArrBW[j] = charArr[i];
            j++;
        }
        return charArrBW;
    }

    /**
     *
     * @return
     */

    protected String charArrToStrBw(char[] charBw){
        return charArrToStr(charArrBw(charBw));
    }

    /**
     *
     * @param str
     * @return
     */

    protected String strToStrBw(String str){
        return charArrToStr(charArrBw(str.toCharArray()));
    }

    /**
     *
     * @param arr
     * @return
     */

    protected String charArrToStr( char[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }
        return str;
    }

}
