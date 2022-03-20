
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		// TODO: 用接口给一个有工资收入和稿费收入的小伙伴算税:
		Income[] incomes = new Income[] {new BaseIncome(3000),new SalaryIncome(7500), new RoyaltyIncome(12000) };
		double total = 0;
		// TODO:
		total = getIncome( total,incomes);
		System.out.println(total);
	}
	public static double getIncome(double total,Income...incomes) {
		
		for (Income income : incomes) {
			total+=income.getTax();
		}
		return total;
		
	}

}
