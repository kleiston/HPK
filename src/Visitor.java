import de.lab4inf.wrb.Function;
import de.lab4inf.wrb.Script;

public class Visitor extends WRBBaseVisitor<Double> {
	
	private Script mScript;
	
	public Visitor(final Script script) {
		super();
		mScript = script;
	}

	@Override public Double visitMulDiv(WRBParser.MulDivContext ctx) {
		Double left = visit(ctx.expr(0));
		Double right = visit(ctx.expr(1));
		if (ctx.op.getType() == WRBParser.MUL) {
			return left * right;
		} 
		return left / right;
		}

	@Override public Double visitAddSub(WRBParser.AddSubContext ctx) {
		Double left = visit(ctx.expr(0));
		Double right = visit(ctx.expr(1));
		if (ctx.op.getType() == WRBParser.ADD) {
			return left + right;
		} 
		return left - right;
		}

	@Override public Double visitParens(WRBParser.ParensContext ctx) {
		return visit(ctx.expr());
		}

	@Override public Double visitNumb(WRBParser.NumbContext ctx) {
		return Double.valueOf(ctx.Number().getText());
		}
	
	@Override 
	public Double visitVariable(WRBParser.VariableContext ctx) {
		String variableName = ctx.Var().getText();
		return mScript.getVariable(variableName);
		}
	
	@Override public Double visitAssignVar(WRBParser.AssignVarContext ctx) { 
		Double value = visit(ctx.expr());
		if (mScript != null) mScript.setVariable(ctx.Var().getText(), value);
		return value;
	}

	@Override public Double visitAssignFunction(WRBParser.AssignFunctionContext ctx) { 
		//if (mScript != null) mScript.setVariable(ctx.Var().getText(), value);
		return 0.0;
			
	}
	
	@Override public Double visitFunction(WRBParser.FunctionContext ctx) {
		Function fct;
		if (mScript != null) {
			System.out.println(ctx.functionsignature().functionname().Var().getText());
		}
		return 0.0;
		}

}
