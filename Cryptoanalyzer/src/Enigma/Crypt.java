package Enigma;

public class Crypt extends AuxCipherTools{
    private final int ASCII_START = 97;
    //private final int ASCII_STOP = 122;

    /**
     *
     * @param rot
     * @param plain
     * @return
     */
    public String makeRot(int rot, String plain){
        System.out.println(letters.length);
        plain = plain.toLowerCase();
        char ch = ' ';

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < plain.length(); i++){
            ch = plain.charAt(i);
            int ascii = (int)ch;
            ascii = ascii - ASCII_START;
            ascii = (ascii + rot)%26;
            //ascii += ASCII_START;
            sb.append(letters[ascii]);
        }
        return sb.toString();
    }

    /**
     *
     * @param rot
     * @param cipher
     * @return
     */

    public String solvRote(int rot, String cipher){

        cipher = cipher.toLowerCase();
        char ch = ' ';

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cipher.length(); i++){
            ch = cipher.charAt(i);
            int ascii = (int)ch;
            ascii = ascii - ASCII_START;
            ascii = Math.abs((ascii - rot)+26)%26;
            //ascii += ASCII_START;
            sb.append(letters[ascii]);
        }
        return sb.toString();
    }

    /**
     *
     * @param cipher
     */

    public void bruteRotation(String cipher){

        for(int i = 0; i < 26; i++){
            System.out.println("Rot: " + i +" = "+solvRote(i,cipher) );
        }
    }

    /**
     *
     */

    /**
     *
     * @param pText
     * @param key
     * @return
     */

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

    /**
     *
     * @param cipherText
     * @param key
     * @return
     */
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

    /**
     *
     */

    /**
     *
     * @param text
     * @return
     */

    public String transpCrypt(String text){

        setClearText(text);
        String cipherText  = "";
        int place = 0;
        char padding = clearText.charAt(0);
        char temp;
        for(int i = 0; i < 5; i++){

            for(int j = 0; j < transPosArray[0].length; j++){
                try{
                    transPosArray[i][j] += Character.toUpperCase(clearText.charAt(place));
                    place++;
                }
                catch(IndexOutOfBoundsException e){
                    transPosArray[i][j] = padding;
                }
            }

        }
        place = 0;
        for(int i = 0; i < transPosArray[0].length; i++){
            for(int j = 0; j < 5;j++){
                cipherText += transPosArray[j][i];
            }
            cipherText += " ";
        }
        return cipherText;
    }

    /**
     *
     * @param pText
     * @return
     */

    public String transpDeCrypt(String pText){

        setClearText(pText);
        int place = 0;
        char padding = clearText.charAt(0);
        for(int i = 0; i < transPosArray[0].length; i++){

            for(int j = 0; j < 5; j++){
                try{
                    transPosArray[j][i] += Character.toLowerCase(clearText.charAt(place));
                    place++;
                }
                catch(IndexOutOfBoundsException e){
                    transPosArray[j][i] = padding;
                    place++;
                }
            }
        }
        place = 0;
        pText="";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < transPosArray[0].length;j++){
                pText += transPosArray[i][j];
            }
        }
        return pText;
    }

    public String viganereCipher(){
        return "";
    }


}
