package classReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//利用反射机制获取方法，方法参数及成员变量及构造函数

public class ClassUtil {
	
	//打印类的信息，包括类的成员函数
	public static void printClassMessage(Object obj) {
		//要获取类的信息，首先要获取类的类类型
		Class c = obj.getClass();//传递的是哪个子类的对象， c就是该子类的类类型
		
		//获取类的名称
		System.out.println("类的名称是： " + c.getName());
		
		//获取该类的所有的方法 : 一个成员方法就是一个Method对象
		//c.getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
		Method[] ms = c.getMethods();
		for(int i =0; i < ms.length; i++) {
			//得到方法的返回值类型的类类型
			Class returnType = ms[i].getReturnType();
			System.out.println(returnType.getName() + " ");
			//得到方法的名称
			System.out.print(ms[i].getName()  + "(");
			//获取参数类型: 得到的是参数列表的类型的类类型
			Class[] paramTypes = ms[i].getParameterTypes();
			for(Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
	}
	
	
	/*
	 * 成员变量也是对象
	 * java.lang.reflect.Field
	 * Field类封装了关于成员变量的操作
	 * getField()方法获取的是所有public成员变量的信息
	 * getDeclaredFields()获取的是自己该类自行声明的成员变量的信息
	 * */
	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for(Field field: fs) {
			//得到成员变量的类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			
			//得到成员变量的名称
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}

	
	//打印对象的构造函数的信息
	public static void printConstructorMessage(Object obj) {
		Class c = obj.getClass();
		
		//构造函数也是对象，属于java.lang.Constructor中封装了构造函数的信息
		//getConstructors获取所有的public的构造函数
		Constructor[] cs = c.getDeclaredConstructors();
		for(Constructor constructor: cs) {
			System.out.print(constructor.getName() + "(");
			//获取构造函数的参数列表  得到的是参数列表的类类型
			Class[] paramTypes = constructor.getParameterTypes();
			for(Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
		
		
	}
}
