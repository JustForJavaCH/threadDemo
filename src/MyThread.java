import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    private CountDownLatch countDownLatch;
    private Integer a;

    public MyThread() {
    }

    public MyThread(CountDownLatch countDownLatch, Integer a) {
        this.countDownLatch = countDownLatch;
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("/////");
       /* try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (a > 0) {
            a--;
            System.out.println(a);
        }
*/

    }
}
