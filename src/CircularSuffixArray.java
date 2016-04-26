import java.util.Arrays;

public class CircularSuffixArray {

    private final int N;
    private int[] indices;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        checkNullOrEmpty(s);
        N = s.length();
        sortSuffixes(s);
    }

    // length of s
    public int length() {
        return N;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        checkIndex(i);
        return indices[i];
    }

    private void sortSuffixes(String s) {
        StringWrapper[] ws = new StringWrapper[N];

        for (int i = 0; i < N; i++) {
            ws[i] = new StringWrapper(s, i);
        }

        RadixQuickSort.sort(ws);
        //Arrays.sort(ws);

        indices = Arrays.stream(ws).mapToInt(x -> x.offset()).toArray();

    }

    private void checkNullOrEmpty(String s) {
        if (s == null) {
            throw new java.lang.NullPointerException();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= N) {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }

    // unit testing of the methods
    // (optional)
    public static void main(String[] args) {

    }
}