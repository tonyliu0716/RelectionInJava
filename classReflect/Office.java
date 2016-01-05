package classReflect;

public class Office{
	public static void main(String[] args){
		//new创建对象是静态加载类，在编译时刻就需要加载所有的可能使用到的类
		//如果其中一个类有问题，其他所有功能完全的类就不能再使用，因为已经报错了
		if("Word".equals(args[0])) {
			Word w = new Word();
			w.start();
		}
		
		if("Excel".equals(args[0])) {
			Excel e = new Excel();
			e.start();
		}
		
	}
}	

class Word implements OfficeAble{
	public void start() {
		System.out.println("Word start...");
	}
}

class Excel implements OfficeAble{
	public void start() {
		System.out.println("Excel start...");
	}
}
