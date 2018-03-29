package rule3;

import java.lang.reflect.Constructor;

/**
 * 静态工厂方法
 */
public class ElvisStaticFactory {
	private static int count = 0;
	private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();

    private ElvisStaticFactory() {
    	//防止创建对象 
    	if(count > 0) {
            throw new IllegalArgumentException("Cannot create Elvis twice");
        }
        count++;
    }

    public static ElvisStaticFactory getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) throws Exception{
    	//单例模式创建对象
    	ElvisStaticFactory elvis = ElvisStaticFactory.getInstance();
        elvis.leaveTheBuilding();
        //通过反射构造器创建对象
        Constructor<?> constructor = ElvisStaticFactory.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        ElvisStaticFactory instance = (ElvisStaticFactory) constructor.newInstance();
        instance.leaveTheBuilding();
    }
}
