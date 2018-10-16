import java.util.HashMap;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

 public class WRBScript implements Script {
	 	 
	 private HashMap<String, Double> values = new HashMap<String, Double>();
	 
		@Override
		public double parse(String expression) {
			ANTLRInputStream input = new ANTLRInputStream(expression);
    		WRBLexer lexer = new WRBLexer(input);
    		CommonTokenStream tokens = new CommonTokenStream(lexer);
    		WRBParser parser = new WRBParser(tokens);
    		ParseTree parseTree = parser.formula();
    		Visitor visitor = new Visitor(this);
    		return visitor.visit(parseTree);
		}

		@Override
		public double getVariable(String varName) {
			if (values.containsKey(varName)) {
				return values.get(varName).doubleValue();
			}
			// TODO: Exception
			return 0;
		}

		@Override
		public void setVariable(String variable, double value) {
			values.put(variable, value);
		}
 }