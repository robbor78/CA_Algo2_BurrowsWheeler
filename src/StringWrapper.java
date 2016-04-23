
/**
 * 
 * Source: Coursera forum
 *
 */
public class StringWrapper implements Comparable<StringWrapper> {

    private String s;
    private int offset;
    private int length;

    public StringWrapper(String s, int offset) {
        this.s = s;
        this.offset = offset;
        this.length = s.length();
    }

    public int length() {
        return length;
    }

    public char charAt(int index) {
        return s.charAt((offset + index) % length);
    }
    
    public int offset() {
        return offset;
    }

    @Override
    public int compareTo(StringWrapper other) {
        for (int pos = 0; pos < length; pos++) {
            char charHere = charAt(pos);
            char charThere = other.charAt(pos);
            if (charHere < charThere) {
                return -1;
            }
            if (charHere > charThere) {
                return 1;
            }
        }
        return 0;
    }

}
