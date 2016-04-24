import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFrontTests {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {

        BinaryStdOut.write('C', 8);
        BinaryStdOut.write('A', 8);
        BinaryStdOut.write('A', 8);
        BinaryStdOut.write('A', 8);
        BinaryStdOut.write('B', 8);
        BinaryStdOut.write('C', 8);
        BinaryStdOut.write('C', 8);
        BinaryStdOut.write('C', 8);
        BinaryStdOut.write('A', 8);
        BinaryStdOut.write('C', 8);
        BinaryStdOut.write('C', 8);
        BinaryStdOut.write('F', 8);

        BinaryStdOut.flush();
        BinaryStdOut.close();

        MoveToFront.encode();

        ArrayList<Integer> al = new ArrayList<>();
        while (!BinaryStdIn.isEmpty()) {
            int i = BinaryStdIn.readInt(8);
            al.add(i);
            System.out.println(i);
        }

    }

}
