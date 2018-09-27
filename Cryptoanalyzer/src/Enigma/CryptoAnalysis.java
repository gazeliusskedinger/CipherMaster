package Enigma;

import java.util.ArrayList;
import java.util.Collections;

public class CryptoAnalysis extends AuxCipherTools{
    private final int ASCII_START = 97;

    public CryptoAnalysis(){

    }

    public String clearText(String msg){
        return justLetters(msg);
    }

    public int[] statisticalAnalysis(String text){

        int[] list = new int[PLAIN_TEXT_ALPHABET.length()];
        char ch = ' ';
        // set the values to array to 0
        for(int i = 0; i < list.length; i++){
            list[i] = 0;
        }

        text = text.toLowerCase();

        int ascii = 0;
        for(int i = 0; i < text.length(); i++){
            ascii = (int)text.charAt(i);
            ascii -= ASCII_START;
            list[ascii]++;
        }
        return list;
    }

    public ArrayList<Node> bigrams(String text){

        text = justLetters(text.toLowerCase());
        String bi;
        int occurance = 0;
        String notCopy = text;
        String enter;

        ArrayList<Node> list = new ArrayList<>();
        Node n = null;

        for(int i = 0; i < text.length()-1; i++){
            bi = text.substring(i,i+2);
            occurance = 0;
            for (int j = 0; j < text.length()-1; j++ ){
                if (bi.equals(text.substring(j,j+2))){
                   occurance++;
                }
            }
            n = new Node(occurance,bi);
            if(!exists(list, n)){
                list.add(n);
            }
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<Node> trigrams(String text){
        ArrayList<Node> list = new ArrayList<Node>();
        text = justLetters(text.toLowerCase());
        String tri;
        int occurance = 0;
        String notCopy = text;
        String enter;

        Node n = null;

        for(int i = 0; i < text.length()-2; i++){
            tri = text.substring(i,i+3);
            occurance = 0;
            for (int j = 0; j < text.length()-2; j++ ){
                if (tri.equals(text.substring(j,j+3))){
                    occurance++;
                }
            }
            n = new Node(occurance,tri);
            if(!exists(list,n)) {
                list.add(n);
            }
        }
        Collections.sort(list);
        return list;
    }

    public String[] quadgrams(){
        return new String[5];
    }

    public int[] findRot(int[] frekvens, ArrayList<String> bigram,ArrayList<String> trigram){
        return new int[3];
    }


}