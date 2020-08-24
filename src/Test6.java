public class Test6 {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);//休眠5秒钟，等待其他线程执行b块代码
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("执行lock2" + Thread.currentThread().getName());
                }
            }
            System.out.println(Thread.currentThread() + "waiting");
        }, "线程1").start();


        new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);//休眠5秒钟，等待其他线程执行b块代码
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }


        }, "456").start();


    }
}
