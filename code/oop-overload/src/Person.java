
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Person {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(String familyName, String latName) {
		// TODO Auto-generated method stub
		this.name = familyName+" "+latName;
		
	}

}
