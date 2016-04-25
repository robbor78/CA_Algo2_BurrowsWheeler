import java.util.stream.IntStream;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int RADIX = 256;
    private static final int BITS = 8;

    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        int[] seq = IntStream.range(0, RADIX).toArray();
        // System.out.println(seq.length);
        while (!BinaryStdIn.isEmpty()) {
            int c = BinaryStdIn.readInt(BITS);

            int value = seq[c];

            // System.out.printf("0x%04X -> 0x%04X\n", c, value);

            BinaryStdOut.write(value, BITS);

            // if (value != 0) {
            seq[c] = 0;

            for (int i = 0; i < RADIX; i++) {
                if (i != c && seq[i] < value) {
                    seq[i]++;
                }
            }
            // }
        }

        BinaryStdOut.flush();
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {
        int[] seq = IntStream.range(0, RADIX).toArray();
        while (!BinaryStdIn.isEmpty()) {
            int i = BinaryStdIn.readInt(BITS);

            int c = seq[i];

            BinaryStdOut.write((char) c);

            for (int k = i; k > 0; k--) {
                seq[k] = seq[k - 1];
            }
            seq[0] = c;

        }
        BinaryStdOut.flush();
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
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
