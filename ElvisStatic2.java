package rule3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 静态成员
 * 如果上面两种方法实现的Singleton是可以序列化的，加上 implements Serializable只保证它可以序列化，
 * 为了保证反序列化的时候，实例还是Singleton，必须声明所有的实例域都是transient的，
 * 并且提供 readResolve方法，否则，每次反序列化都会生成新的实例。
 */
public class ElvisStatic2 implements Serializable {

	private static final long serialVersionUID = -8120429180408581905L;
	
	public static final ElvisStatic2 INSTANCE = new ElvisStatic2();

    private ElvisStatic2() {
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator. 
        return INSTANCE;
    }
    
    // This code would normally appear outside the class!
    public static void main(String[] args) throws Exception {
    	ElvisStatic2 elvis = ElvisStatic2.INSTANCE;
        elvis.leaveTheBuilding();
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("elvis.ser"));
        oos.writeObject(elvis);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("elvis.ser"));
        ElvisStatic2 o = (ElvisStatic2) ois.readObject();
        ois.close();
        System.out.println(elvis == o);
    }
}
