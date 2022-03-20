package com.itranswarp.learnjava;

public class ClassPrivateCon {

	static int i = 1;
       
		private ClassPrivateCon(){            
			System.out.println("ClassPrivateCon私有构造方法");        
			}    
		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws Exception {  
			Class<ClassPrivateCon> cls = ClassPrivateCon.class;  
			System.out.println(i++);
			cls.newInstance().main(new String[]{"",""});    


}
}