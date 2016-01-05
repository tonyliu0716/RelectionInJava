package classReflect;

public class OfficeBetter {
	public static void main(String[] args){
		
		try {
			//动态加载类，在运行时刻加载
			Class c = Class.forName(args[0]);
			
			//通过类类型，创建该类对象
			OfficeAble oa = (OfficeAble)c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}

interface OfficeAble{
	public void start();
}
