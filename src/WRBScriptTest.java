import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WRBScriptTest {

	Script script;
	
	@BeforeEach
	public  void setUp() throws Exception {
		script = new WRBScript();
	}
	
	@Test
	void test() {
		assertEquals(5.0, script.parse("3 / 9 - 5"));
	}

}
