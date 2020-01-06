package dDesignPattern.b_singleton_pattern;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2020/1/6 8:54
 */
public class DoubleCheck {

    private DoubleCheck (){}

    // 2、保证线程在"new"完对象后，其他线程能“立刻”感知到
    private volatile static DoubleCheck doubleCheck;

    public static DoubleCheck getDoubleCheck() {
        if (doubleCheck == null) {
            // 1、当对象在高并发下首次被请求，将本对象加上同步锁。
            // 即仅运行一个线程运行下面的"new"操作
            synchronized (DoubleCheck.class) {
                // 3、保证在首个线程完成"new"操作后，后续线程不在重复"new"
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }

    /*最初级的单例
    * 存在的问题在于多线程并发的情况下，在第一个 "new" 生效前，
    * 多个线程已经请求进来，判断 "primary == null" 都为true
    * 此时多个线程实际上获取了多个不同的 primary 对象
    * */
    private static DoubleCheck primary;
    public static DoubleCheck getPrimary(){
        if(primary == null){
            primary = new DoubleCheck();
        }
        return primary;
    }

    /*中级单例
    * 此种单例模式解决了初级中并发请求下出现多个实例的情况。
    * 但是此种模式在运行的过程中会因为“同步”而浪费大量性能
    * */
    private static DoubleCheck intermediate;
    public synchronized static DoubleCheck getIntermediate(){
        if(intermediate == null){
            intermediate = new DoubleCheck();
        }
        return intermediate;
    }
    
}
