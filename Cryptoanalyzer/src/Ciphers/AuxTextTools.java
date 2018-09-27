package Ciphers;

public abstract class AuxTextTools {

    public AuxTextTools(){

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
