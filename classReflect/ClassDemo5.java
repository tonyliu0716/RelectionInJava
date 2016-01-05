package classReflect;

public class ClassDemo5 {

	public static void main(String[] args) {
		ClassUtil.printConstructorMessage("hello");
		
		System.out.println("=================");
		
		ClassUtil.printConstructorMessage(new Integer(1));
	}

}
