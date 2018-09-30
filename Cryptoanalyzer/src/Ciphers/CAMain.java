package Ciphers;

public class CAMain {
    public static void main(String[] args) {


        String[] validArgs = chkInput(args);
        ComandLineMenu clm = new ComandLineMenu(args);
        clm.menu();
        Charset cs = new Charset(validArgs[0]);
        Rot rot = new Rot(cs.getSet());

    }

    private static String[] chkInput(String[] args)throws IllegalArgumentException {
        String[] validArgs = new String[4];
        String help = "";
        if(args[0].equals("--help") || args[0].equals("-h")){
            if(args[0].equals("-c")){
                validArgs[0] = args[1];
            }
            else{
                throw new IllegalArgumentException("No Valid Args... Try Again");
            }
        }
        else {
            if(args[0].equals("-c")){
                validArgs[0] = args[1];
            }
            else{
                throw new IllegalArgumentException("No Valid Args... Try Again");
            }
        }
        return validArgs;
    }
}