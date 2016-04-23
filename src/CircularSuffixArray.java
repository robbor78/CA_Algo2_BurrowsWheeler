public class CircularSuffixArray {

    private final int N;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        CheckNullOrEmpty(s);
        N = s.length();
    }

    // length of s
    public int length() {
        return -1;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        CheckIndex(i);
        return -1;
    }

    private void CheckNullOrEmpty(String s) {
        if (s == null || s.trim().length() == 0) {
            throw new java.lang.NullPointerException();
        }
    }

    private void CheckIndex(int index) {
        if (index < 0 || index >= N) {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }

    // unit testing of the methods
    // (optional)
    public static void main(String[] args) {

    }
}