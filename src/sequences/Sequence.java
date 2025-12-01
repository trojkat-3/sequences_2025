package sequences;

import exceptions.CantDecomposeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

abstract public class Sequence {
    protected int max = 1000;

    protected String name;
    protected ArrayList<Integer>  sequence=new ArrayList<>();

    public Sequence(String name){
        this.name=name;
    }

    public void setMax(int max) {
        this.max=max;
        sequence.clear();
        initializeSequence();
    }

    abstract void initializeSequence();

    public String getName() {
        return name;
    }
    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    public ArrayList<Integer> decompose(int n) throws CantDecomposeException {
        int nBackup=n;
        ArrayList<Integer> listDesc=new ArrayList<>(sequence); //shallow copy
        ArrayList<Integer> ret=new ArrayList<>();
        Collections.sort(listDesc, Collections.reverseOrder());
        int i=0;
        while (n>0 && i<listDesc.size()) {
            if (listDesc.get(i)<=n){
                ret.add(listDesc.get(i));
                n-=listDesc.get(i);
            } else {
                i++;
            }
        }
        if (n>0){
            throw new CantDecomposeException(name,nBackup);
        }
        return ret;
    }
}
