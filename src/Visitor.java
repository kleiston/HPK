
public class Visitor extends WRBBaseVisitor<Double> {

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
}
