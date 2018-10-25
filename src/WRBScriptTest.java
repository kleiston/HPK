import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.lab4inf.wrb.AbstractScriptTest;
import de.lab4inf.wrb.Script;

public class WRBScriptTest extends AbstractScriptTest {

	Script script;
    final double eps = 1.E-8;
	
	@BeforeEach
	public  void setUp() throws Exception {
		script = new WRBScript();
	}

    protected Script getScript() {
        return new WRBScript();
    }
    
    @Test
    public void testSetVariableInExpression() throws Exception {
    	String varName = "testKey59";
    	String task = varName + "= 42 + 17.99";
    	script.parse(task);
    	assertEquals(59.99, script.getVariable(varName), eps);
    }
    
    @Test
    public void testGetAssignmentInExpression() throws Exception {
    	String varName = "a";
    	script.setVariable(varName, 4);
    	String task = "5 + " + varName;
    	assertEquals(9.0, script.parse(task), eps);
    }
    
    @Test
    public void testSignedSecondArg() throws Exception {
        String task = "2 + -6";
        assertEquals(-4.0, script.parse(task), eps);
    }
    
    @Test
    public final void testMixedFloatWithoutPre() throws Exception {
        String task = "2 + .5";
        assertEquals(2.5, script.parse(task), eps);
    }
    
    @Test
    public final void testMixedFloatWithoutPreSigned() throws Exception {
        String task = "2 + -.5";
        assertEquals(1.5, script.parse(task), eps);
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
}
