package Enigma;

public class Component {

    protected char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    protected int[] in =      {0,  1,  2,  3,  4,  5  ,6  ,7  ,8  ,9  ,10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    protected int[] out;//    {4,  9,  12, 25, 0,  11, 24, 23, 21, 1,  22, 5,  2,  17, 16, 20, 14, 13, 19, 18, 15, 8,  10, 7,  6,  3};
    //                         E   J   M   Z   A   L   Y   X   V   B   W   F   C   R   Q   U   O   N   T   S   P   I   K   H   G   D
    protected int index = 0;

    protected String name = "";

    public Component(){

    }

    public Component(int[] out, String name){
        this.out= out;
        this.name = name;
    }

    /**
     *
     * @param index
     */

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     *
     * @return
     */

    public int getSetting(){
        return index;
    }

    /**
     *
     * @return
     */

    public int getOut() {
        return out[index];
    }

    public void setOut(int[] out){
        this.out=out;
    }

    @Override
    public String toString(){
        int out = this.out[index];
        return "Enigma.Rotor "+name+"       | Setting : "+chars[index]+" | Out       : "+chars[out];
    }

    public String toStringCoded(){
        int out = this.out[index];
                return "Enigma.Rotor "+name+"       | Input   : "+chars[index]+" | Coded out : "+chars[out];
    }
}
