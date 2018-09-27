package Enigma;

import Enigma.Component;

public class Rotor extends Component {

    private int flowIndex = 0;

    public Rotor(){

    }

    public Rotor(int[] out, String name){
        this.out = out;
        this.name = name;
    }

    public void stepUp() {
        index++;
        index = index%26;
    }

    public void setFlowIndexIndex(int flowIndex){
        this.flowIndex = flowIndex;
    }

    public boolean flipNextR() {
        if(index == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getOut(){
        return ((flowIndex-index)+26)%26;
    }

    @Override
    public String toString(){
        int out = this.out[index];
        return "Enigma.Rotor "+name+"       | Setting : "+chars[index]+" | Out       : "+chars[out];
    }
    @Override
    public String toStringCoded(){
        int out = this.out[((flowIndex-index)+26)%26];
        //System.out.println(((flowIndex-index)+26)%26);
        return "Enigma.Rotor "+name+"       | Input   : "+chars[(flowIndex-index+26)%26]+" | Coded out : "+chars[out];
    }
}
