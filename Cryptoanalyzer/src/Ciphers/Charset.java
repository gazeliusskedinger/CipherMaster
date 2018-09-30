package Ciphers;

public class Charset {
    /**
     * 0 = sv
     * 1 = en
     */
    private char[][] set = {{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö'},
                            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}};
    private final int index;


    public Charset(String var){
        if (var.equals("se")) {
            this.index = 0;
        } else if (var.equals("en")) {
            this.index = 1;
        }
        else{
            this.index = 1;
        }
    }

    /**
     *
     * @return
     */

    public char[] getSet() {
        return set[index];
    }

    // TODO Add!!!!
    /**
     * Identify languages function
     */
}
