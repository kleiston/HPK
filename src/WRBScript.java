import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import de.lab4inf.wrb.Function;
import de.lab4inf.wrb.Script;

 public class WRBScript implements Script {
	 	 
	 private HashMap<String, Double> values = new HashMap<String, Double>();
	 
		@Override
		public double parse(String expression) {
			ANTLRInputStream input = new ANTLRInputStream(expression);
    		WRBLexer lexer = new WRBLexer(input);
    		CommonTokenStream tokens = new CommonTokenStream(lexer);
    		WRBParser parser = new WRBParser(tokens);
    		ParseTree parseTree = parser.start();
    		Visitor visitor = new Visitor(this);
    		return visitor.visit(parseTree);
		}

		@Override
		public double getVariable(String varName) {
			if (values.containsKey(varName)) {
				return values.get(varName).doubleValue();
			}
		throw new IllegalArgumentException("variable " + varName + " not found!");
		}

		@Override
		public void setVariable(String variable, double value) {
			values.put(variable, value);
		}

		@Override
		public double parse(InputStream defStream) throws IOException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Set<String> getFunctionNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<String> getVariableNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setFunction(String name, Function fct) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Function getFunction(String name) {
			// TODO Auto-generated method stub
			return null;
		}
 }