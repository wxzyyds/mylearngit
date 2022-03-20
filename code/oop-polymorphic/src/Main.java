
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		// TODO: 给一个有工资收入和稿费收入的小伙伴算税:
		Income[] incomes = new Income[] { new Income(3000), new SalaryIncome(7500), new RoyaltyIncome(12000) };
		double total = getIncome(incomes );
		// TODO:
		System.out.println(total);
	}
	
	public static double getIncome(Income ...incomes ) {
		double money = 0.0;
		for (Income income : incomes) {
			money+=income.getTax();
		}
		return money;
		
	}

}


