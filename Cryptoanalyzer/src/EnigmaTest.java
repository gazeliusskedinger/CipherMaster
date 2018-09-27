import Crypto.AuxCipherTools;
import Crypto.Crypt;

public class EnigmaTest extends Enigma.AuxCipherTools {

    public static void main(String[] args) {
        int[][] rotors = {{4,  10, 12, 5,  11, 6,  3,  16, 21, 25, 13, 19, 14, 22, 24, 7,  23, 20, 18, 15, 0,  8,  1,  17, 2,  9}
                         ,{0,  9,  3,  10, 18, 8,  17, 20, 23, 1,  11, 7,  22, 19, 12, 2,  16, 6,  25, 13, 15, 24, 5,  21, 14, 4}
                         ,{1,  3,  5,  7,  9,  11, 2,  15, 17, 19, 23, 21, 25, 13, 24, 4,  8,  22, 6,  0,  10, 12, 20, 18, 16, 14}};
        int[][] reflectors = {{4,  9,  12, 25, 0,  11, 24, 23, 21, 1,  22, 5,  2,  17, 16, 20, 14, 13, 19, 18, 15, 8,  10, 7,  6,  3}};
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String testMessage = "The ring settings";//, or Ringstellung, are used to change the position of the internal wiring relative to the rotor. They do not change the notch or the alphabet ring on the exterior. Those are fixed to the rotor. Changing the ring setting will therefore change the positions of the wiring, relative to the turnover-point and start position.";
        char crypt;
        AuxCipherTools act = new AuxCipherTools() {
        };
        Crypt c = new Crypt();

        StringBuilder sb = new StringBuilder();

        Rotor I = new Rotor();
        I.setOut(rotors[0]);
        I.setName("I      ");
        Rotor II = new Rotor();
        II.setOut(rotors[1]);
        II.setName("II     ");
        Rotor III = new Rotor();
        III.setOut(rotors[2]);
        III.setName("III    ");

        Component A = new Component();
        A.setOut(reflectors[0]);
        A.setName("A      ");

        testMessage = justLetters(testMessage.toLowerCase());

        for(int rI = 0; rI < testMessage.length(); rI++ ){

            I.stepUp();

            if(I.flipNextR()){
                II.stepUp();
            }

            I.setFlowIndexIndex((int)(testMessage.charAt(rI))-97);

            System.out.println(I.toString());
            System.out.println(I.toStringCoded());

            /*II.setFlowIndexIndex(I.getOut());

            System.out.println(II.toString());
            System.out.println(II.toStringCoded());

            III.setFlowIndexIndex(II.getOut());

            System.out.println(III.toString());
            System.out.println(III.toStringCoded());

            A.setIndex(III.getOut());

            System.out.println(A.toString());
            System.out.println(A.toStringCoded());

            III.setFlowIndexIndex(A.getOut());

            System.out.println(III.toString());
            System.out.println(III.toStringCoded());

            II.setFlowIndexIndex(III.getOut());

            System.out.println(II.toString());
            System.out.println(II.toStringCoded());

            I.setFlowIndexIndex(II.getOut());

            System.out.println(I.toString());
            System.out.println(I.toStringCoded());*/

            sb.append(chars[I.getOut()]);
        }
        System.out.println(testMessage);
        String cipher = sb.toString();
        System.out.println(sb.toString());

        StringBuilder sbre = new StringBuilder();

        I.setIndex(0);
        II.setIndex(0);
        III.setIndex(0);
        for(int rI = 0; rI < cipher.length(); rI++ ){

            I.stepUp();

            if(I.flipNextR()){
                II.stepUp();
            }

            I.setFlowIndexIndex((int)(cipher.charAt(rI))-97);

            System.out.println(I.toString());
            System.out.println(I.toStringCoded());/*

            II.setFlowIndexIndex(I.getOut());

            System.out.println(II.toString());
            System.out.println(II.toStringCoded());

            III.setFlowIndexIndex(II.getOut());

            System.out.println(III.toString());
            System.out.println(III.toStringCoded());

            A.setIndex(III.getOut());

            System.out.println(A.toString());
            System.out.println(A.toStringCoded());

            III.setFlowIndexIndex(A.getOut());

            System.out.println(III.toString());
            System.out.println(III.toStringCoded());

            II.setFlowIndexIndex(III.getOut());

            System.out.println(II.toString());
            System.out.println(II.toStringCoded());

            I.setFlowIndexIndex(II.getOut());

            System.out.println(I.toString());
            System.out.println(I.toStringCoded());*/

            sbre.append(chars[I.getOut()]);
        }
        System.out.println(cipher);
        String plain = sbre.toString();
        System.out.println(plain);
    }
}
