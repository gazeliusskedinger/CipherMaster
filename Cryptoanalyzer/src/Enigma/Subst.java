package Enigma;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author delorian1986
 */
public class Subst extends AuxCipherTools {
    
    public Subst(String text){
        setClearText(text);
    }
    
    public String rot(String plainText){
        
        String chifferText = "";
        return chifferText;
        
    }
    
    public String substitutionCrypt(String pText, String key){
        
        pText = pText+" ";
        String cipherBet = keyMaker(key);
        String cipherText = "";
        int place = 0;
        int length ;
        
        StringBuilder substitute = new StringBuilder();
        substitute.append(PLAIN_TEXT_ALPHABET);
        //System.out.println(substitute.toString());
        
        for(int i = 0; i < pText.length()-1; i++){
        
            String temp = pText.substring(i,i+1).toLowerCase();
            place = substitute.indexOf(temp);
            
            if(place != -1){
                cipherText = cipherText + cipherBet.charAt(place);
            }
            else{
                cipherText = cipherText +" ";
            }
        }
        return cipherText;
    }
    public String substitutionDeCrypt(String cipherText, String key){
        
        cipherText = cipherText+" ";
        String cipherBet = keyMaker(key);
        String plainText = "";
        int place = 0;
        
        StringBuilder substitute = new StringBuilder();
        substitute.append(cipherBet);
        System.out.println(substitute.toString());
        
        for(int i = 0; i < cipherText.length()-1; i++){
        
            String temp = cipherText.substring(i,i+1).toUpperCase();
            place = substitute.indexOf(temp);
            
            if(place != -1){
                plainText = plainText + PLAIN_TEXT_ALPHABET.charAt(place);
             
            }
            else{
                plainText = plainText +" ";
            }
        }
        return plainText;
    }
    
   

    
}
