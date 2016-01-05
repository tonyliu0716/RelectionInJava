package classReflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

//利用方法的反射机制避开泛型的限制

public class MethodDemo4 {
	public static void main(String[] args){
		//泛型
		ArrayList list = new ArrayList();
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hello");
		//list1.add(20); 错误
		
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1 == c2);//返回true，说明编译之后集合的泛型是去泛型化的
		
		//反射的操作都是编译之后的操作
		//证明java中的集合的泛型，都是防止错误输入的，只在编译阶段有效，绕过编译就无效了
		//我们可以通过方法的反射来操作，绕过编译
		
		try {
			Method m = c1.getMethod("add", Object.class);
			m.invoke(list1, 20);
			//即使list1已经规定了泛型，我们还是成功存入了20
			System.out.println(list1.size());
			System.out.println(list1);
			//但是不能使用foreach或者for进行遍历!只要遍历就会抛出异常ClassCastException
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
