package Enigma;

import java.util.ArrayList;

public class SolveMain {
    public static void main(String[] args) {
        Crypt c = new Crypt();

        String cipher = c.makeRot(1, "abcdefghijklmnopqrstuvwxyz");

        System.out.println(cipher);
        System.out.println();
        System.out.println(c.solvRote(1, cipher));
        c.bruteRotation(cipher);

        String key = c.makeRandomKey(2000);
        String test = /*"enannanannasananas";//*/"I used the following C code to break the message above, it includes an implementation of the Enigma cipher, the quadgram scoring and a few other helper functions. To specify the message you want to decrypt, edit the";
        cipher = c.substitutionCrypt(test,key);

        System.out.println(cipher);
        System.out.println(c.substitutionDeCrypt(cipher,key ));

        cipher = c.transpCrypt(test);

        System.out.println(cipher);
        System.out.println(c.transpDeCrypt(cipher));


        /*CryptoAnalysis ca = new CryptoAnalysis();
        test = ca.clearText(test);
        int[] list = ca.statisticalAnalysis(test);
        for(int i = 0; i < list.length; i++){
            System.out.println(ca.PLAIN_TEXT_ALPHABET.charAt(i)+" : "+list[i]);
        }
        ArrayList<CryptoAnalysis.Node> list2 = new ArrayList<CryptoAnalysis.Node>();
        list2 = ca.bigrams(test);

        for(int i = list2.size()-1; i >=0 ;i--){
            System.out.println(list2.get(i));
        }

        list2  = ca.trigrams(test);
        for(int i = (list2.size()-1); i >= 0; i-- ) {
            System.out.println(list2.get(i));
        }*/


    }
}
