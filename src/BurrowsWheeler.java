import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    // apply Burrows-Wheeler encoding, reading from standard input and writing
    // to standard output
    public static void encode() {
        String in = BinaryStdIn.readString();

        // System.out.println(in);

        CircularSuffixArray csa = new CircularSuffixArray(in);

        int length = in.length();

        int i = 0;
        for (; i < length; i++) {
            if (csa.index(i) == 0) {
                break;
            }
        }

        BinaryStdOut.write(i);

        for (i = 0; i < length; i++) {
            int index = csa.index(i);
            char c = in.charAt((index + length - 1) % length);
            // char c = in.charAt(csa.index(i));
            // System.out.println(c+" "+csa.index(i));
            BinaryStdOut.write(c);
        }
        BinaryStdOut.flush();
        BinaryStdOut.close();

    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing
    // to standard output
    public static void decode() {
        int first = BinaryStdIn.readInt();
        System.out.println("1st: " + first);

        ArrayList<Integer> al = new ArrayList<Integer>();

        while (!BinaryStdIn.isEmpty()) {
            al.add(BinaryStdIn.readInt(8));
        }

        al.stream().forEach(System.out::println);

        int length = al.size();
        Integer[] next = new Integer[length];
        Integer[] t = new Integer[length];
        t = al.toArray(t);

        Integer[] col1 = new Integer[length];
        col1 = al.toArray(col1);

        Arrays.sort(col1);

    }

    // if args[0] is '-', apply Burrows-Wheeler encoding
    // if args[0] is '+', apply Burrows-Wheeler decoding
    public static void main(String[] args) {
        char s = args[0].charAt(0);
        switch (s) {
        case '-':
            encode();
            break;
        case '+':
            decode();
            break;

        }
    }
}