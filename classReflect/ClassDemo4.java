package classReflect;

public class ClassDemo4 {
	
	public static void main(String[] args){
		//利用工具类获取成员变量
		ClassUtil.printFieldMessage("hello");
		System.out.println("===========");
		
		ClassUtil.printFieldMessage(new Integer(1));
	}
	
}
