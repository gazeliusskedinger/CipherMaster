
package Enigma;
import java.util.*;


public class MyHeap {
    private ArrayList<Node> heap;

    public MyHeap(){
        heap = new ArrayList<Node>();
        heap.add(null);
    }

    public void add(int nr, String chrs){
        Node n = new Node(nr,chrs);
        if (!exists(n)) {
        heap.add(null);
            Comparable comp = nr;
            int index = heap.size() - 1;
            while (index > 1
                    &&
                    getParent(index).compNr.compareTo(n.compNr) > 0)
            {
                heap.set(index, getParent(index));
                index = getParentIndex(index);
            }
            heap.set(index, n);
        }
    }

    public Node peek(){
        return heap.get(1);
    }

    public Node pop(){
        Node bigest = heap.get(1);

        int lastIndex = heap.size()-1;
        Node last = heap.remove(lastIndex);
        if(lastIndex > 1){
            heap.set(1,last);
            fixHeap();
        }
        return bigest;
    }

    private Node getParent(int index){
        return heap.get(index/2);
    }

    private int getParentIndex(int index){
        return index/2;
    }

    private Node getLeftChild(int index){
        return heap.get(2*index);
    }

    public int getLeftChildIndex(int index){
        return 2*index;
    }

    private Node getRightChild(int index){
        return heap.get(2*index-1);
    }

    public int getRightChildIndex(int index){
        return 2*index+1;
    }

    private void fixHeap(){
        Node root = heap.get(1);
        int lastIndex = heap.size()-1;
        int index = 1;
        boolean more = true;
        while(more){
            int childIndex = getLeftChildIndex(index);
            if (childIndex <= lastIndex){
                Node child = getLeftChild(index);
                if (getRightChildIndex(index) <= lastIndex
                        && getRightChild(index).compNr.compareTo(child.compNr)<0){
                    childIndex = getRightChildIndex(index);
                    child = getRightChild(index);
                }
                if (child.compNr.compareTo(root.compNr)<0){
                    heap.set(index,child);
                    index = childIndex;
                }
                else{
                    more = false;
                }
            }
            else{
                more = false;
            }
        }
        heap.set(index,root);
    }

    public boolean empty(){
        return heap.size()== 1;
    }

    private boolean exists(Node n){
        for(int i = 1; i < heap.size(); i++){
            if (heap.get(i).chrs.equals(n.chrs)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String text= "";
        for(int i = 1; i < heap.size(); i++){
            text = text + heap.get(i);
        }
        return text;
    }

    public int getSize(){
        return heap.size()-1;
    }

    public static void sort(){

    }

    public class Node{

        public int nr;
        public String chrs;
        public Comparable compNr;
        public Comparable compChrs;
        public Node(int nr, String chrs){
            this.nr = nr;
            this.chrs = chrs;
            this.compNr = nr;
        }

        @Override
        public String toString(){
            return chrs+":"+nr+"\n";
        }

    }
}
