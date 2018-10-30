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
	 private HashMap<String, Function> functions = new HashMap<String, Function>();
	 private final CustomErrorListener errorListener = new CustomErrorListener();
	 
		@Override
		public double parse(String expression) {
				ANTLRInputStream input = new ANTLRInputStream(expression);
	    		WRBLexer lexer = new WRBLexer(input);
	    		lexer.removeErrorListeners();
	    		lexer.addErrorListener(errorListener);
	    		CommonTokenStream tokens = new CommonTokenStream(lexer);
	    		WRBParser parser = new WRBParser(tokens);
	    		parser.removeErrorListeners();
	    		parser.addErrorListener(errorListener);
	    		ParseTree parseTree = parser.start();
	    		Visitor visitor = new Visitor(this);
	    		return visitor.visit(parseTree);
		}

		@Override
		public double getVariable(String varName) {
			if (values.containsKey(varName)) {
				return values.get(varName).doubleValue();
			}
		throw new IllegalArgumentException("variable " + varName + " not set!");
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
			return null;
		}

		@Override
		public void setFunction(String name, Function fct) {
			this.functions.put(name, fct);
			
		}

		@Override
		public Function getFunction(String name) {
			if (values.containsKey(name)) {
				return functions.get(name);
			}
		throw new IllegalArgumentException("Function " + name + " not set!");
		}
 }