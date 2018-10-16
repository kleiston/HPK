import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WRBScriptTest {

	Script script;
	
	@BeforeEach
	public  void setUp() throws Exception {
		script = new WRBScript();
	}
	
	/**
     * Test method for {@link de.lab4inf.wrb.Script#parse(java.lang.String)}.
     * Testing some very simple operation. More to come...
     */

    @Test
    public final void testPlus() throws Exception {
        String task = "2+3";
        assertEquals(5.0, script.parse(task));
    }

    @Test
    public final void testMinus() throws Exception {
        String task = "2 - 6";
        assertEquals(-4.0, script.parse(task));
    }

    @Test
    public final void testConstant() throws Exception {
        String task = "0815; 4711";
        assertEquals(4711.0, script.parse(task));
    }

    @Test
    public final void testSigned() throws Exception {
        String task = "-2 + 6";
        assertEquals(4.0, script.parse(task));
    }

    @Test
    public void testSignedSecondArg() throws Exception {
        String task = "2 + -6";
        assertEquals(-4.0, script.parse(task));
    }

    @Test
    public final void testMixedFloat() throws Exception {
        String task = "2.0/3 - 5.2*4";
        assertEquals(2. / 3.0 - 5.2 * 4, script.parse(task));
    }

    @Test
    public final void testLongAdd() throws Exception {
        String task = "2.0 + 3 + 4.0 + 5";
        assertEquals(14, script.parse(task));
    }

    @Test
    public final void testLongMult() throws Exception {
        String task = "2 * 3.0 * 4 * 5.000";
        assertEquals(120, script.parse(task));
    }

    @Test
    public final void testLongMixed() throws Exception {
        String task = "2.0 * 3 * 4.0 + 5 + 6.0 / 3 ";
        assertEquals(31, script.parse(task));
    }

    @Test
    public void testParseBracket() throws Exception {
        String task = " 2*(4.0 + 3)";
        assertEquals(14, script.parse(task));
    }

}
