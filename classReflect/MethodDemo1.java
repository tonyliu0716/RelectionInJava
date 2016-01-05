package classReflect;

import java.lang.reflect.Method;

//利用反射机制调用类中的方法

public class MethodDemo1 {
	public static void main(String[] args){
		//获取print方法，但是有两个：我们获取的是print(int, int)
		A a1 = new A();
		Class c = a1.getClass();
		
		//获取方法，由名称和参数列表来决定,获取的是public的方法
		try {
			//下面两种方式均可
			//Method m = c.getDeclaredMethod("print", new Class[]{int.class, int.class});
			//Object o = m.invoke(a1, new Object[]{10, 20});
			
			Method m = c.getDeclaredMethod("print", int.class, int.class);
			//a1.print(10, 20) 方法的反射操作是用m对象来进行方法调用 和a1.print直接调用的效果是相同的
			Object o  = m.invoke(a1, 10, 20);
			
			//方法如果没有返回值，返回null,如果有返回值就返回值
	
			System.out.println("============");
			
			//获取方法对象的两种方式，效果是相同的
			//Method m1 = c.getDeclaredMethod("print", String.class, String.class);
			//Object o1 = m1.invoke(a1, "hello", "world");
			
			Method m1 = c.getDeclaredMethod("print", new Class[]{String.class, String.class});
			Object o1 = m1.invoke(a1, new Object[]{"hello", "world"});
			
			System.out.println("============");
			
			//下面是反射无参数的方法
			//Method m2 = c.getDeclaredMethod("print", new Class[]{});
			//m2.invoke(a1, new Object[]{});
			
			Method m2 = c.getDeclaredMethod("print");
			m2.invoke(a1);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

class A {
	
	//有参数
	public void print(int a, int b) {
		System.out.println(a + b);
	}
	
	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
	
	//无参数
	public void print() {
		System.out.println("helloworld...");
	}
}
