package bAdvance.aThread;

/**
 * <pre>
 *     这展示的是volatile的非原子性。
 *      自增符号本质上通过两个原子操作来完成自己的逻辑。1、读取；2、自增
 *      当进程1完成读取后被其他进程抢占，那么全局变量依然保持未自增状态，此时进程2读取到的依然是旧的数据。
 *
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/29 16:30
 */
public class BTestVolatile {
    public volatile int inc = 0;

    public void increase(){
        inc ++;
    }

    public static void main(String[] args) {
        final BTestVolatile test = new BTestVolatile();
        System.out.println("尝试发起线程");
        for( int i = 0 ; i < 10; i++){
            new Thread(() -> {
                for(int j = 0 ; j < 1000; j ++){
                    test.increase();
                }
            }).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终结果: "+test.inc);
    }
}
