
public class BaseIncome implements Income{
	protected double income;
	public BaseIncome(double income) {
		this.income = income;
	}
	
	@Override
	public double getTax() {
		// TODO Auto-generated method stub
		return income * 0.1;
	}

}
