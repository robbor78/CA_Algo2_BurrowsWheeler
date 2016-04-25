import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularSuffixArrayTests {

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
        String s = "ABRACADABRA!";

        CircularSuffixArray target = new CircularSuffixArray(s);
        
        int[] expected = {11,10,7,0,3,5,8,1,4,6,9,2};
        
        int length = s.length();
        for (int i=0; i<length; i++) {
            assertEquals(expected[i], target.index(i));
        }
    }
    @Test
    public void testEmptyString() {
        String s = "";

        CircularSuffixArray target = new CircularSuffixArray(s);
        
        int[] expected = {0};
        
        int length = s.length();
        for (int i=0; i<length; i++) {
            assertEquals(expected[i], target.index(i));
        }
    }
}
