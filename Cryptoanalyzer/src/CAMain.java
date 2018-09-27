import javax.crypto.Cipher;

public class CAMain {
    public static void main(String[] args) {
       // if (args[0].equals("-h")) {
        //    //print help file.
        //} else {


        //}
        ComandLineMenu clm = new ComandLineMenu(args);
        clm.menu();
        Tools to = new Tools("en");
        Ciphers cp = new Ciphers("en");
        //to.freqAnalysis("The quick brown fox jumps over the lazy dog");
        //to.bigrams("The quick brown fox jumps over the lazy dog");
        //to.trigrams("The quick brown fox jumps over the lazy dog The quick brown fox jumps over the lazy dog");
        //to.annagrams("quIck");
        //cp.makeRot("The quick brown fox jumps over the lazy dog", 3);
        //cp.decryptRot("Wkh txlfn eurzq ira mxpsv ryhu wkh odcb grj", 3);
        //System.out.println(cp.substitutionCrypt("The quick brown fox jumps over the lazy dog abcdefg",cp.makeRandomKey(100)));
       // System.out.println(cp.substitutionCrypt("The quick brown fox jumps over the lazy dog abcdefg",cp.keyMaker("twentieth century fox")));
        //System.out.println(cp.substitutionDeCrypt("LUI QKREF WPVGZ HVD YKXSM VJIP LUI OTAB NVC TWENIHC","twentieth century fox"));

        //cp.xorEncrypt("The quick brown fox jumps over the lazy dog abcdefg", "key3");
        //cp.xorDecrypt("3f 2d 3c 13 3a 30 30 70 20 45 3b 61 24 32 37 13 2d 2a 21 13 21 30 34 63 38 45 36 65 2e 37 59 67 23 20 59 7f 2a 3f 20 13 2f 2a 3e 13 2a 27 3a 77 2e 23 3e","key3");
       // cp.bruteRotation("udys");
        //System.out.print(cp.substitutionCrypt("JYFJ", cp.alphabetBackwardstoString()));
       // System.out.print(cp.substitutionCrypt("vyt vyttöwuhöl zyxypåy xäs äylj", cp.alphabetBackwardstoString()));
    }
}