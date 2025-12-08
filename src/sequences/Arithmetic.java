package sequences;

import exceptions.OutOfBoundsException;

public class Arithmetic extends Sequence {
    private int a1;
    private int diff;

    public Arithmetic(int a1, int diff) {
        super("Arithmetic sequence with: a1=" + a1 + ", diff=" + diff);
        this.a1 = a1;
        this.diff = diff;
        initializeSequence();
    }

    @Override
    public int sum(int n) throws OutOfBoundsException {
        if (n > sequence.size()) {
            throw new OutOfBoundsException("In " + name, n, max);
        }
        return (2 * a1 + (n - 1) * diff) * n / 2;
    }

    @Override
    void initializeSequence() {
        for (int i = 0; i < max; i++) {
            sequence.add(a1 + i * diff);
        }
    }
}
