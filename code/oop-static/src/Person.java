
public class Person {

	// TODO
	private static int count = 0;
	protected String name;

	public Person(String name) {
		this.name = name;
		++count;
	}
	public  String getName() {
		return name;
		
	}
	public static int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

}
