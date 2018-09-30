package Ciphers;

import java.util.Arrays;
import java.util.HashSet;

public class Tools extends Cipher {

    private char[] ALPHABET;



    public Tools(String charset){
    }

    /**
     *
     * @param Text
     */

    public void freqAnalysis(String Text) {

        //char[] charSetSw = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö'};
        String cleanedText = rmWhite(Text).toLowerCase();
        char[] array = toArray(cleanedText);
        int[] numbers = new int[ALPHABET.length];

        for (int i = 0; i < cleanedText.length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (array[i] == ALPHABET[j]) {
                    numbers[j]++;
                }
            }
        }
        for (int i = 0; i < ALPHABET.length; i++) {
            System.out.println(ALPHABET[i] + " = " + numbers[i]);
        }
    }

    /**
     *
     * @param str
     */

    public void bigrams(String str){
        String[] bigrams = pullToPieces(str,2);
        countPieces(bigrams,str, 2);
    }

    /**
     *
     * @param str
     */

    public void trigrams(String str){
       String[] trigrams = pullToPieces(str,3);
       countPieces(trigrams,str, 3);
    }

    public void keyLengthBlock(String ciphertext){

    }

    /**
     *
     * @param text
     */

    public void annagrams(String text){
        int n = text.length();
        text = text.toLowerCase();
        permute(text,0,n-1);
    }

    /**
     *
     * @param str
     * @param length
     */

    private String[] pullToPieces(String str, int length){
        str = rmWhite(str).toLowerCase();
        String[] grams = new String[str.length()-(length-1)];
        for(int i = 0; i < str.length()-(length-1);i++){
            grams[i] = str.substring(i,i+(length));
        }
        grams = sortOutDuplicates(grams);
        return grams;
    }

    /**
     *
     * @param grams
     * @param text
     * @param length
     */

    private void countPieces(String[] grams, String text, int length){
        text = rmWhite(text).toLowerCase();
        int[] numbers = new int[grams.length];
        for(int i = 0; i < text.length()-(length - 1);i++){
            for(int j = 0; j < numbers.length; j++){
                //System.out.println("text.substring = " + (text.substring(i, i+length) + " == " + grams[j] + ".equals == " + text.substring(i, i+length).equals(grams[j])));
                if(text.substring(i, i+length).equals(grams[j])){
                    numbers[j]++;
                }
            }
        }
        for(int i = 0; i < grams.length;i++){
            System.out.println(grams[i] + " = " + numbers[i]);
        }
    }

    //private String highestCountFirst(String[] grams, int[] numbers){
    //    String tmp = "";
    //    String List ="";
    //    int temp = 0;
    //    for(int i = 0; i < numbers.length; i++){
    //        for(int j = 0; j < numbers.length; j++){
    //
    //        }
    //    }
    //
    // }

    /**
     *
     * @param str
     * @return
     */

    private String[] sortOutDuplicates(String[] str){
        return new HashSet<String>(Arrays.asList(str)).toArray(new String[0]);
    }


    /**
     *
     * @param Text
     * @return
     */

    private char[] toArray( String Text){
        return Text.toCharArray();
    }

    /**
     *
     * @param str
     * @param l
     * @param r
     */

    private void permute(String str, int l, int r ){
        if(l  == r){
            System.out.println(str);
        }
        else{
            for(int i = l;i <= r; i++){
                str = swap(str,l,i);
                permute(str, l+1,r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     *
     * @param a
     * @param i
     * @param j
     * @return
     */

    private String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
