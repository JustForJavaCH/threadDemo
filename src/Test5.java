public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Test5MyRunnable test5MyRunnable = new Test5MyRunnable();
        test5MyRunnable.setFlag("a");
        Thread thread1 = new Thread(test5MyRunnable);
        thread1.start();
        Thread.sleep(100);
        test5MyRunnable.setFlag("b");
        Thread thread2 = new Thread(test5MyRunnable);
        thread2.start();
    }
}
