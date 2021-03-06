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
            // System.out.println(in.substring(index) + in.substring(0, index) +
            // " " + c);
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
        // System.out.println("1st: " + first);

        ArrayList<Integer> al = new ArrayList<Integer>();

        while (!BinaryStdIn.isEmpty()) {
            al.add(BinaryStdIn.readInt(8));
        }

        // al.stream().forEach(System.out::println);

        int length = al.size();
        Integer[] t = new Integer[length];
        Integer[] sorted = new Integer[length];
        t = al.toArray(t);
        sorted = al.toArray(sorted);

        Arrays.sort(sorted);

        int[] freq = new int[256 + 1];

        // for (int i = 0; i < length; i++) {
        // freq[t[i] + 1]++;
        // }

        // for (int i = 0; i < 256; i++) {
        // freq[i + 1] += freq[i]; // cumulates
        // }

        // for (int i = 0; i < length; i++) {
        // System.out.println(t[i] + "->" + freq[t[i]]);
        // }

        int[] next = new int[length];

        // for (int i = 0; i < length; i++) {
        // freq[t[i]]++;
        // next[i] = freq[t[i]];
        // System.out.println("n(" + i + "): " + next[i]);
        // }

        for (int i = 0; i < length; i++) {
            int sortedC = sorted[i];
            int k = freq[sortedC];
            for (; k < length; k++) {
                if (t[k] == sortedC) {
                    break;
                }
            }
            next[i] = k;
            freq[sortedC] = k + 1;
            // System.out.println("n(" + i + "): " + next[i]);
        }

        //StringBuilder sb = new StringBuilder();
        int r = first;
        for (int i = 0; i < length; i++) {
            // System.out.println("r= "+r);
            // int c = t[r - 1];
            int c = sorted[r];
            // sb.insert(0, (char) c);
            // sb.append((char) c);
            BinaryStdOut.write((char) c);
            r = next[r];
        }
        // sb.append((char) (int) t[r - 1]);

        // System.out.println(sb.toString());

        //BinaryStdOut.write(sb.toString());
        BinaryStdOut.flush();
        BinaryStdOut.close();

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
        default:
            return;
        }
    }
}