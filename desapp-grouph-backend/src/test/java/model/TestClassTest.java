package model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestClassTest {

    @Test
    public void simpleTest() {
        TestClass tc = new TestClass();
        assertEquals(1, tc.one());
    }
}
