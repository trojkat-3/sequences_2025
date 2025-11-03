package sequences;

import java.util.ArrayList;

abstract public class Sequence {
    protected String name;
    protected ArrayList<Integer>  sequence=new ArrayList<>();

    public Sequence(String name){
        this.name=name;
    }
    abstract void initializeSequence();
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getSequence() {
        return sequence;
    }
}
