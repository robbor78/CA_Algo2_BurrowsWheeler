import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringWrapperTests {

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
    public void Offset0() {
        String s = "Hello World";
        StringWrapper ws = new StringWrapper(s, 0);

        int length = s.length();
        for (int i = 0; i < length; i++) {
            assertEquals(s.charAt(i), ws.charAt(i));
        }
    }

    @Test
    public void Offset3() {
        int offset = 3;
        String s = "Hello World";
        StringWrapper ws = new StringWrapper(s, offset);

        int length = s.length();
        for (int i = 0; i < length; i++) {
            assertEquals(s.charAt((i + offset) % length), ws.charAt(i));
            // System.out.println(ws.charAt(i));
        }
    }

    @Test
    public void Comapre_Equal() {
        int offset1 = 4;
        int offset2 = 4;
        String s = "Hello World";
        StringWrapper ws1 = new StringWrapper(s, offset1);
        StringWrapper ws2 = new StringWrapper(s, offset2);

        assertTrue(ws1.compareTo(ws2) == 0);
    }

}
