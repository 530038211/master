package rule3;

/**
 * 通过枚举实现Singleton更加简洁，同时枚举类型无偿地提供了序列化机制，
 * 可以防止反序列化的时候多次实例化一个对象。
 * 枚举类型也可以防止反射攻击，当你试图通过反射去实例化一个枚举类型的时候会抛出IllegalArgumentException异常：
 */
public enum Elvis {
	INSTANCE;

	public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
        
        Elvis elvis1 = Elvis.INSTANCE;
        
        //枚举实现对象
        System.out.println(elvis == elvis1);
    }
}
