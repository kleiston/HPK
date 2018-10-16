
public interface Script {

	public double parse(String expression);
	public double getVariable(String varName);
	public void setVariable(String variable, double value);
}
