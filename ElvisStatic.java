package rule3;

import java.lang.reflect.Constructor;

/**
 * 静态成员
 * 保证了实例的全局唯一性，保证只有一个实例
 */
public class ElvisStatic {
	public static final ElvisStatic elvisStatic = new ElvisStatic();

    private ElvisStatic() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws Exception {
    	ElvisStatic elvis = ElvisStatic.elvisStatic;
        elvis.leaveTheBuilding();
        
        Constructor<?> constructor = ElvisStatic.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        ElvisStatic instance = (ElvisStatic) constructor.newInstance();
        instance.leaveTheBuilding();
        
        System.out.println(elvis==instance);
    }
}
