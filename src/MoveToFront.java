import java.util.stream.IntStream;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    // apply move-to-front encoding, reading from standard input and writing to
    // standard output
    public static void encode() {
        int[] seq = IntStream.range(0, 255).toArray();
        while (!BinaryStdIn.isEmpty()) {
            int c = BinaryStdIn.readInt(8);
            
            int value = seq[c];
            
            BinaryStdOut.write(value, 8);
            
            seq[c] = 0;
            
            for (int i=0; i<c; i++) {
                seq[i]++;
            }
        }
        
        BinaryStdOut.flush();
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to
    // standard output
    public static void decode() {

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

        }

    }
}
