package classReflect;

public class ClassDemo3 {
	
	public static void main(String[] args){
		String s = "hello";
		ClassUtil.printClassMessage(s);
		
		System.out.println("--------------");
		
		Integer i = 1;
		ClassUtil.printClassMessage(i);
	}
	
}
