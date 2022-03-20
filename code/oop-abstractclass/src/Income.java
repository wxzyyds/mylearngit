
/**
 * 定义抽象类Income
 */
public abstract class Income {

	// TODO
	protected double income;

	public Income(double income) {
		this.income = income;
	}

	public abstract double getTax();

}
