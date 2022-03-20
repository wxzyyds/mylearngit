
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Person {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge( int age) {
		if (age<0||age>100) {
			 throw new IllegalArgumentException("invalid age value"); 
		}
		this.age =	age;
		
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	

}
