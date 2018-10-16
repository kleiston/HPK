import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WRBScriptTest {

	Script script;
    final double eps = 1.E-8;
	
	@BeforeEach
	public  void setUp() throws Exception {
		script = new WRBScript();
	}
	
	/**
     * Test method for {@link de.lab4inf.wrb.Script#parse(java.lang.String)}.
     * Testing some very simple operation. More to come...
     */
	
	
	/**
     * Get the actual implementation for the script test.
     * 
     * @return script implementation
     */
    protected Script getScript() {
        return new WRBScript();
    }

    /**
     * Test method for
     * {@link de.lab4inf.wrb.Script#setVariable(java.lang.String,double)}. and
     * {@link de.lab4inf.wrb.WRBScript#getVariable(java.lang.String)}.
     */
    @Test
    public final void testSetGetVariable() throws Exception {
        double y, x = 2.78;
        String key = "XYZ";
        script.setVariable(key, x);
        y = script.getVariable(key);
        assertEquals(x, y, eps);
        x = Math.random();
        script.setVariable(key, x);
        y = script.getVariable(key);
        assertEquals(x, y, eps);
    }
	

    @Test
    public final void testPlus() throws Exception {
        String task = "2+3";
        assertEquals(5.0, script.parse(task), eps);
    }

    @Test
    public final void testMinus() throws Exception {
        String task = "2 - 6";
        assertEquals(-4.0, script.parse(task), eps);
    }

    @Test
    public final void testConstant() throws Exception {
        String task = "0815; 4711";
        assertEquals(4711.0, script.parse(task), eps);
    }

    @Test
    public final void testSigned() throws Exception {
        String task = "-2 + 6";
        assertEquals(4.0, script.parse(task), eps);
    }

    @Test
    public void testSignedSecondArg() throws Exception {
        String task = "2 + -6";
        assertEquals(-4.0, script.parse(task), eps);
    }

    @Test
    public final void testMixedFloat() throws Exception {
        String task = "2.0/3 - 5.2*4";
        assertEquals(2. / 3.0 - 5.2 * 4, script.parse(task), eps);
    }

    @Test
    public final void testLongAdd() throws Exception {
        String task = "2.0 + 3 + 4.0 + 5";
        assertEquals(14, script.parse(task), eps);
    }

    @Test
    public final void testLongMult() throws Exception {
        String task = "2 * 3.0 * 4 * 5.000";
        assertEquals(120, script.parse(task), eps);
    }

    @Test
    public final void testLongMixed() throws Exception {
        String task = "2.0 * 3 * 4.0 + 5 + 6.0 / 3 ";
        assertEquals(31, script.parse(task), eps);
    }

    @Test
    public void testParseBracket() throws Exception {
        String task = " 2*(4.0 + 3)";
        assertEquals(14, script.parse(task), eps);
    }
    
    @Test
    public void testAssignmentSimple() throws Exception {
    	String task = "testkey13 = 13.00";
    	assertEquals(13.00, script.parse(task), eps);
    }
    
    @Test
    public void testAssignmentFloat() throws Exception {
    	String task = "test13key = 13.373";
    	assertEquals(13.373, script.parse(task), eps);
    }
    
    @Test
    public void testAssignmentExpression() throws Exception {
    	String task = "testkey59: 42 + 17.99";
    	assertEquals(59.99, script.parse(task), eps);
    }
}
