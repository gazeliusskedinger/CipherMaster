package Enigma;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.StringBufferInputStream;
import java.util.ArrayList;

/**
 * @author delorian1986
 */
public abstract class AuxCipherTools {
    protected String clearText = "";
    protected String cipherText = "";
    private final int ASCII_START = 97;
    public final String PLAIN_TEXT_ALPHABET ="abcdefghijklmnopqrstuvwxyz";
    protected final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected final String ALPHABET_BACKWARDS = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
    protected final char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};


    char[][] transPosArray;  
        
    public AuxCipherTools(){
      
    }
    
    public void setClearText(String text){
        
        clearText = whitespaceGone(text);
        text = clearText;
        clearText = justLetters(text);
        int len = clearText.length();
        if(Math.ceil(clearText.length()/5) < len  ){
            transPosArray= new char[5][clearText.length()/5+1];
        }
        else{
            transPosArray= new char[5][clearText.length()/5];
        }
        
    } 
    
    public void setCipherText(String text){
        cipherText = whitespaceGone(text);
        transPosArray= new char[5][cipherText.length()/5];
    }
    
    public char getCipherText(int i, int j){
        return transPosArray[i][j];
    }
     
    public String whitespaceGone(String text){
        
        String formattedText = "";
        int asciiValue = 0;
        for(int i = 0; i < text.length();i++){
            asciiValue = (int)text.charAt(i);
            if(asciiValue != 9 && asciiValue != 10 && asciiValue != 32){
                formattedText = formattedText + text.charAt(i);
            }
        }
        
        return formattedText;
    } 
    
    public String toString(char[] charArray){
        String text = "";
        for(int i = 0; i < charArray.length; i++){
            text = text + charArray[i];
        }
        return text;
    }
    
    public char[] toCharArray(String text){
        char[] textArray = new char[text.length()];
        for(int i = 0; i < text.length(); i++){
            textArray[i] = text.charAt(i);
        }
        return textArray;
    }
    
    protected String justLetters(String text){
        String textOut = "";
        char test;
        for(int i = 0; i < text.length(); i++){
            test = text.charAt(i);
            if(Character.isLetter(test)){
                textOut += text.charAt(i);
            } 
        }
        return textOut;
    } 
    
    public String keyMaker(String text){
        StringBuilder removeDuplicates = new StringBuilder();
        text = text+ALPHABET_BACKWARDS;
        for(int i = 0; i < text.length(); i++){
            String temp = text.substring(i,i+1).toUpperCase();
            if(removeDuplicates.indexOf(temp) == -1){
                removeDuplicates.append(temp);   
            }   
        }
        String fullKey = removeDuplicates.toString();
        return whitespaceGone(fullKey);
    }

    public String makeRandomKey(int times){
        int j;
        String temp;
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < times; i++){
            j = random();
            temp = PLAIN_TEXT_ALPHABET.substring(j, j+1);
            if(key.indexOf(temp) == -1){
                key.append(temp);
            }
        }
        return key.toString();
    }

    private int random(){
        return (int)(Math.random()*26);
    }

    public void testArray(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }

    public boolean exists(ArrayList<CryptoAnalysis.Node> list, CryptoAnalysis.Node n){
        for(int i = 1; i < list.size(); i++){
            if (list.get(i).chrs.equals(n.chrs)){
                return true;
            }
        }
        return false;
    }

    public class Node implements Comparable<Node>{

        public int nr;
        public String chrs;

        public Node(int nr, String chrs){
            this.nr = nr;
            this.chrs = chrs;
        }

        @Override
        public String toString(){
            return chrs+":"+nr;
        }

        public int compareTo(Node node) {
            return Integer.compare(nr, node.nr);
        }
    }

    /*public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(random());
        }

        System.out.println(makeRandomKey(2000));

    }*/

    //private class List {

    //}
}
