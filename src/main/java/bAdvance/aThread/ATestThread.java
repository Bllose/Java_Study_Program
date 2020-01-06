package bAdvance.aThread;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/29 8:05
 */
class RunnableDemo implements Runnable {
    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<Integer>();
    ThreadLocal<String> threadName = new ThreadLocal<>();

    private void initName() {
        String name = "";
        int num = (int) (Math.random()*100000);
        name = "myThread_" + num;
        threadName.set(name);
    }

    public void run() {

        // 模拟MDC创建线程名称
        initName();
        String name = threadName.get();

        System.out.println(name + " 被发起的线程开始运行... 当前counter:" + counter);
        // 针对全局变量进行递增计算
        counter++;

        // 针对threadLocal变量进行递增计算
        if(threadLocalCounter.get() != null) {
            threadLocalCounter.set(threadLocalCounter.get().intValue() + 1);
        } else {
            threadLocalCounter.set(0);
        }


        System.out.println(name + " Counter: " + counter);
        System.out.println(name + " threadLocalCounter: " + threadLocalCounter.get());

        System.out.println(name + " 开始休眠....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

public class ATestThread {

    public static void main(String args[]) {
        RunnableDemo commonInstance = new RunnableDemo();

        System.out.println("开始创建线程");
        Thread t1 = new Thread(commonInstance);
        Thread t2 = new Thread(commonInstance);
        Thread t3 = new Thread(commonInstance);
        Thread t4 = new Thread(commonInstance);

        System.out.println("发起线程");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("发起线程完毕");

        // wait for threads to end
        try {
            System.out.println("开始join线程，等待他们执行完毕");
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println("所有线程执行完毕~~~");
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}