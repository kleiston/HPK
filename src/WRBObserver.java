import java.util.IdentityHashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class WRBObserver {
	protected WRBScript script;
	

	/*
	public WRBObserver(final WRBScript script) {
		this.script = script;
		if (script == null) {
			throw new IllegalArgumentException("script is null");
			}	
		}

	@Override
	public void exitExpression(@NotNull WRBParser.ExpressionContext ctx) {
		System.out.println("exit expression dies das");
	}
	
	@Override
	public void exitAdditionExp(WRBParser.AdditionExpContext ctx) { 
		System.out.println("jo exit addition");
	}
	
	@Override 
	public void exitAtomExp(WRBParser.AtomExpContext ctx) {
		
	}
	*/
}
