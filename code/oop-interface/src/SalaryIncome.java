
public class SalaryIncome extends BaseIncome{

	public SalaryIncome(double income) {
		super(income);
	}
	@Override
	public double getTax() {
		// TODO Auto-generated method stub
		if (income<5000) {
			return 0;
		}
		return income*0.2;
	}

}
