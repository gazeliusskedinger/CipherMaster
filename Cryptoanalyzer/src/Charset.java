public class Charset {
    /**
     * 0 = sv
     * 1 = eng
     */
    private char[][] set = {{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö'},
                            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}};
    private int i = 0;

    /**
     *
     * @param i
     */
    public void setSet(int i) {
        this.i = i;
    }

    /**
     *
     * @return
     */

    public char[] getSet() {
        return set[i];
    }

    // TODO Add!!!!
    /**
     * Identify languages function
     */
}
